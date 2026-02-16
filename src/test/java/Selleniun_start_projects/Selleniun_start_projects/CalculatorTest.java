package Selleniun_start_projects.Selleniun_start_projects;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalculatorTest {

    static WebDriver browser;

    @Before
    public void setUp() {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\lilia\\OneDrive\\Desktop\\geckodriver.exe");
            browser = new FirefoxDriver();
            browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            browser.get("https://testpages.eviltester.com/styled/apps/calculator.html");
        }


    @Test
    public void testAddition_1_plus_2() {
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button02")).click();
        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("3", result);
    }

    @Test
    public void testAddition_7_plus_3() {
        browser.findElement(By.id("button07")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button03")).click();
        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("10", result);
    }

    @Test
    public void testSubtraction_6_minus_4() {
        browser.findElement(By.id("button06")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button04")).click();
        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("2", result);
    }

    @Test
    public void testSubtraction_8_minus_8() {
        browser.findElement(By.id("button08")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button08")).click();
        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("0", result);
    }

    @Test
    public void testMultiplication_4_times_2() {
        browser.findElement(By.id("button04")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button02")).click();
        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("8", result);
    }

    @Test
    public void testMultiplication_9_times_0() {
        browser.findElement(By.id("button09")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button00")).click();
        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        Assert.assertEquals("0", result);
    }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }
}