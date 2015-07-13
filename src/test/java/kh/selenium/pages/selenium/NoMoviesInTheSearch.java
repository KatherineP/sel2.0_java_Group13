package kh.selenium.pages.selenium;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class NoMoviesInTheSearch extends kh.selenium.pages.TestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Test
    public void search() throws Exception {
        login();
        WebElement searchField = driver.findElement(By.xpath("//div[@class='searchbox']/input[1]"));
        searchField.clear();
        searchField.sendKeys("chroniki" + Keys.RETURN);
        //ниже сделаем проверку, что фильмы не найдены и появилась надпись "No movies where found."
        assert(isElementPresent(By.xpath(".//*[@id='results']/div[1]")));

    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            System.out.println("Фильм был найден");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Фильм не был найден");
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
