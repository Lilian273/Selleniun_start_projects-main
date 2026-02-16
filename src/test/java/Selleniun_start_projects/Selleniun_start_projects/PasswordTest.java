package Selleniun_start_projects.Selleniun_start_projects;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PasswordTest {

    static WebDriver browser;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\lilia\\OneDrive\\Desktop\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        browser.get("https://testpages.eviltester.com/apps/7-char-val/");
    }


    @Test
    public void testPassword_Valid() {
        WebElement passwordField = browser.findElement(By.name("characters"));
        passwordField.clear();
        passwordField.sendKeys("Lili123");

        browser.findElement(By.name("validate")).click();

        WebElement messageField = browser.findElement(By.name("validation_message"));
        String result = messageField.getAttribute("value");

        Assert.assertEquals("Valid Value", result);
    }


    @Test
    public void testPassword_Short() {
        WebElement passwordField = browser.findElement(By.name("characters"));
        passwordField.clear();
        passwordField.sendKeys("Lilian");

        browser.findElement(By.name("validate")).click();

        WebElement messageField = browser.findElement(By.name("validation_message"));
        String result = messageField.getAttribute("value");

        Assert.assertEquals("Invalid Value", result);
    }


    @Test
    public void testPassword_Long() {
        WebElement passwordField = browser.findElement(By.name("characters"));
        passwordField.clear();
        passwordField.sendKeys("Radia123");

        browser.findElement(By.name("validate")).click();

        WebElement messageField = browser.findElement(By.name("validation_message"));
        String result = messageField.getAttribute("value");

        Assert.assertEquals("Invalid Value", result);
    }


    @Test
    public void testPassword_InvalidCharacter() {
        WebElement passwordField = browser.findElement(By.name("characters"));
        passwordField.clear();
        passwordField.sendKeys("Lili12@");

        browser.findElement(By.name("validate")).click();

        WebElement messageField = browser.findElement(By.name("validation_message"));
        String result = messageField.getAttribute("value");

        Assert.assertEquals("Invalid Value", result);
    }

    @Test
    public void testPassword_WithStar() {
        WebElement passwordField = browser.findElement(By.name("characters"));
        passwordField.clear();
        passwordField.sendKeys("Lili12*");

        browser.findElement(By.name("validate")).click();

        WebElement messageField = browser.findElement(By.name("validation_message"));
        String result = messageField.getAttribute("value");

        Assert.assertEquals("Valid Value", result);
    }


    @After
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }
}
