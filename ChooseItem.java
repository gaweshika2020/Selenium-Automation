package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static com.sun.org.apache.bcel.internal.Const.getItemName;

public class ChooseItem extends BaseTest {
    WebElement firstSearchItem;

    @Test(priority = 2)
    public void searchMobilePhone() {
        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
        categoryDropdown.click();
        WebElement cellPhonesCategory = driver.findElement(By.xpath("//option[text()='Cell Phones & Accessories']"));
        cellPhonesCategory.click();
    }

    @Test(priority = 3)
    public void searchMob() {
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Mobile phone");
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();
    }

    @Test(priority = 4)
    public void selectBrand() {
        WebElement appleBrandCheckbox = driver.findElement(By.xpath("//input[@aria-label='Apple']"));
        appleBrandCheckbox.click();
    }

    @Test(priority = 5)
    public void firstSearchItem() {
        WebElement firstSearchItem = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div"));
        firstSearchItem.click();
    }

    @Test(priority = 6)
    public void navigateToNewWindow() throws InterruptedException {
        String mainWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        Thread.sleep(5000);
    }

}
