package kh.selenium.pages.selenium;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class AddMovieWithReqField extends kh.selenium.pages.TestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Test
    public void add() throws Exception {
        login();
        driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
        WebElement addTitle = driver.findElement(By.name("name")); //requirement field
        addTitle.clear();
        addTitle.sendKeys("Test movie");
        WebElement addYear = driver.findElement(By.name("year")); //requirement field
        addYear.clear();
        addYear.sendKeys("2015");
        WebElement addNotes = driver.findElement(By.name("notes"));
        addNotes.clear();
        addNotes.sendKeys("test");
        WebElement addTaglines = driver.findElement(By.name("taglines"));
        addTaglines.clear();
        addTaglines.sendKeys("test");
        WebElement addVideo = driver.findElement(By.name("video"));
        addVideo.clear();
        addVideo.sendKeys("test");
        driver.findElement(By.id("submit")).click();
        WebElement deleteMovie = driver.findElement(By.xpath("//img[@alt='Remove']"));
        deleteMovie.click();
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
        logout();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
