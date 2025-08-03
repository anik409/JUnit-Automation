import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJUnit {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver(); //browser launch
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }


    @Test
    public void visitWebsite(){
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
    }


    @Test
    @DisplayName("Register New User – Required Fields Only")
    void registerNewUser() {

        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");


        driver.findElement(By.name("first_name")).sendKeys("Dean");
        driver.findElement(By.name("last_name")).sendKeys("John");
        driver.findElement(By.name("user_email")).sendKeys("john456.gul@example.com");
        driver.findElement(By.name("user_pass")).sendKeys("Pi@s450rd!");


        driver.findElement(By.id("radio_1665627729_Male")).click();


        driver.findElement(By.cssSelector("input[data-id='date_box_1665628538']")).sendKeys("1990-01-15");


        driver.findElement(By.id("input_box_1665629217")).sendKeys("Bangladeshi");


        WebElement phoneField = driver.findElement(By.id("phone_1665627880"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='1711234567';", phoneField);


        new Select(driver.findElement(By.id("country_1665629257")))
                .selectByVisibleText("Bangladesh");


        driver.findElement(By.id("privacy_policy_1665633140")).click();


        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //Assertions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("ur-submit-message-node")
                )
        );
        assertTrue(successMsg.isDisplayed(), "Success message should appear");
        assertEquals("User successfully registered.", successMsg.getText().trim());
    }






    @AfterAll
    public void teardown() {
        //driver.quit();
    }



}