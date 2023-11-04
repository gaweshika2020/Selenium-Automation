package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;


public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public String baseUrl = "https://www.ebay.com/";

    @BeforeTest
    @Parameters({"browser", "url"})
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test(priority = 0)
    public void checkPageTitle() {
        driver.get("https://www.ebay.com/");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Electronics, Cars, Fashion, Collectibles & More | eBay");
    }

    @Test(priority = 1)
    public void testPage() {
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);
    }
}