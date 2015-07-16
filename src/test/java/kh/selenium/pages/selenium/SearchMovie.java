package kh.selenium.pages.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchMovie extends kh.selenium.pages.TestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();



    @Test
    public void search() throws Exception {
        login();
        WebElement searchField = driver.findElement(By.xpath("//div[@class='searchbox']/input[1]"));
        searchField.clear();

        List<WebElement> moviesBefore = driver.findElements(By.xpath(".//*[@id='results']/a")); //считаем общее к-во фильмов до посика
        System.out.println("Amount of movies before search: " + moviesBefore.size());

        searchField.sendKeys("movie43" + Keys.RETURN);
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        List<WebElement> moviesAfter = driver.findElements(By.xpath(".//*[@id='results']/a")); //считаем к-во фильмов после поиска
        System.out.println("Amount of movies after search: "+ moviesAfter.size());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='movie_cover']/div[@title ='movie43']")));
        //ниже сделаем проверку, что хотя бы один элемент с таким именем найден(первый)
        assertTrue(isElementPresent(By.xpath("//div[@class='movie_cover']/div[@title ='movie43']")));




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
