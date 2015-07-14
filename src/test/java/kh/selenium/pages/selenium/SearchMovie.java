package kh.selenium.pages.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class SearchMovie extends kh.selenium.pages.TestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();



    @Test
    public void search() throws Exception {
        login();
        WebElement searchField = driver.findElement(By.xpath("//div[@class='searchbox']/input[1]"));
        searchField.clear();
        searchField.sendKeys("test" + Keys.RETURN);
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='movie_cover']/div[@title ='movie43']")));
        assertTrue(isElementPresent(By.xpath("//div[@class='movie_cover']/div[@title ='movie43']")));
        driver.findElement(By.xpath("//div[@class='movie_cover']/div[@title ='movie43']")).click(); //тут проверим что на элемент можно кликнуть. А значит от ТОЧНО появился.
        //ниже сделаем проверку, что хотя бы один элемент с таким именем найден(первый)


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
