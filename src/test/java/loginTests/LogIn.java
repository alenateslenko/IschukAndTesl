package loginTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LogIn {

    protected void checkAC (String message, boolean expectedUrl, boolean actual) {
        Assert.assertEquals(message, expectedUrl, actual);
    }
    WebDriver webDriver;
    @Before
    public void setUp() {

        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
    }


    @Test
    public void validLogin() {
        String expectedUrl = "https://jysk.ua/customer/dashboard";
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get("https://jysk.ua/ofis");
        webDriver.manage().timeouts();
        webDriver.findElement(By.xpath(".//*[@id='sc-modal']//*[@class='close-x']")).click();
        webDriver.findElement(By.xpath(".//*[@class='icon-profile']")).click();
        webDriver.findElement(By.id("email")).sendKeys("natalischuk17@gmail.com");
        webDriver.findElement(By.id("password")).sendKeys("VKqeZ46pvkZZ7Qp");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        webDriver.getCurrentUrl();
        String getCurrentUrl;
        Assert.assertEquals("user did not login", expectedUrl, getCurrentUrl());
        webDriver.quit();

    }

    public String getCurrentUrl() {return webDriver.getCurrentUrl();
    }

    @Test
    public void invalidLogin() {
        String expectedUrl = "https://jysk.ua/customer/dashboard";
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get("https://jysk.ua/ofis");
        webDriver.manage().timeouts();
        webDriver.findElement(By.xpath(".//*[@id='sc-modal']//*[@class='close-x']")).click();
        webDriver.findElement(By.xpath(".//*[@class='icon-profile']")).click();
        webDriver.findElement(By.id("email")).sendKeys("natalischuk@gmail.com");
        webDriver.findElement(By.id("password")).sendKeys("VKqeZ46pvkZZ7Qp");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();

        checkAC("user should not have a possibility to log in",false, true);
109 story

        webDriver.quit();

    }

}
