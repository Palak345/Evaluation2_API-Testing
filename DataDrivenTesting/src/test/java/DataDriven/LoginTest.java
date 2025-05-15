package DataDriven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) throws IOException {
        Object[][] credentials = ExcelReader.getTestData("C:\\Users\\Lenovo\\eclipse-workspace\\DataDrivenTesting\\Test Data.xlsx");

        WebDriver driver = new ChromeDriver();

        for (Object[] user : credentials) {
            String email = user[0].toString();
            String password = user[1].toString();

            driver.get("https://practicetestautomation.com/practice-test-login/");

            driver.findElement(By.id("username")).sendKeys(email);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("submit")).click();

         boolean isLoggedIn = driver.getPageSource().contains("Logged In Successfully");


            driver.manage().deleteAllCookies(); 
        }

        driver.quit();
    }
}
