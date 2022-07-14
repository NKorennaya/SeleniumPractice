import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FacebooksSignupPageTest {

    private static final String HOME_PAGE_URL = "https://www.facebook.com/";
    private static WebDriver driver;

    @BeforeAll
    public static void classSetup() {
        driver = ShareDriver.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }

    @AfterAll
    public static void classTearDown() {
        ShareDriver.closeDriver();
    }



    @AfterEach
    public void testTeardown() {
        driver.get(HOME_PAGE_URL);
    }

    @BeforeEach
    public void signupTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
        Thread.sleep(1000);
    }

    @Test
    public void FirstNameErrorMessageTest() {
        driver.findElement(By.xpath("//*[@name = 'websubmit']")).click();

        WebElement error = driver.findElement(By.xpath("//*[contains(text(),'your name')]"));
        assertNotNull(error);
    }

    @Test
    public void LastNameErrorMessageTest() {
        driver.findElement(By.xpath("//*[@name = 'websubmit']")).click();
        driver.findElement(By.xpath("//*[@name = 'lastname']")).click();

        WebElement error = driver.findElement(By.xpath("//*[contains(text(),'your name')]"));
        assertNotNull(error);
    }

    @Test
    public void EmailErrorMessageTest() {
        driver.findElement(By.xpath("//*[@name = 'websubmit']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Mobile number or email']")).click();

        WebElement error = driver.findElement(By.xpath("//*[contains(text(),'to reset')]"));
        assertNotNull(error);

    }

    @Test
    public void PasswordErrorMessageTest() {
        driver.findElement(By.xpath("//*[@name = 'websubmit']")).click();
        driver.findElement(By.xpath("//*[@id='password_step_input']")).click();

        WebElement error = driver.findElement(By.xpath("//*[contains(text(),'six numbers')]"));
        assertNotNull(error);
    }

    @Test
    public void monthTest() {

        driver.findElement(By.xpath("//*[@title='Month']")).click();
        driver.findElement(By.xpath("//*[text() = 'May']")).click();
        String monthValue = driver.findElement(By.xpath("//*[@title='Month']")).getAttribute("value");

        assertEquals("5", monthValue);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1905", "1950", "2020"})
    public void yearTestParametrized(String yearInput) {

        driver.findElement(By.xpath("//*[@title='Year']")).click();
        driver.findElement(By.xpath("//*[text() = '" + yearInput + "']")).click();
        String yearValue = driver.findElement(By.xpath("//*[@title='Year']")).getAttribute("value");

        assertEquals(yearInput, yearValue);

    }

    @Test
    public void genderTest() {
        String femaleXpath = "//*[@name = 'sex' and @value=1]";
        String maleXpath = "//*[@name = 'sex' and @value=2]";
        String customXpath = "//*[@name = 'sex' and @value=-1]";

        //verify female gender is checked
        WebElement femaleButton = driver.findElement(By.xpath(femaleXpath));
        femaleButton.click();
        String isFemaleChecked = driver.findElement(By.xpath(femaleXpath)).getAttribute("checked");
        assertNotNull(isFemaleChecked);
        assertEquals("true", isFemaleChecked);

        //verify male gender is checked
        WebElement maleButton = driver.findElement(By.xpath(maleXpath));
        maleButton.click();
        String isMaleChecked = driver.findElement(By.xpath(maleXpath)).getAttribute("checked");
        assertNotNull(isMaleChecked);
        assertEquals("true", isMaleChecked);

        //verify custom gender is checked
        WebElement customButton = driver.findElement(By.xpath(customXpath));
        customButton.click();
        String isCustomChecked = driver.findElement(By.xpath(customXpath)).getAttribute("checked");
        assertNotNull(isCustomChecked);
        assertEquals("true", isCustomChecked);

    }

    @Test
    public void termsTest() {
        driver.findElement(By.xpath("//*[@id = 'terms-link']")).click();
        for (String str : driver.getWindowHandles()) {
            driver.switchTo().window(str);

        }
        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "https://www.facebook.com/legal/terms/update";
        assertEquals(ExpectedUrl, ActualUrl);
    }

    @Test
    public void DataPolicyTest() {
        driver.findElement(By.xpath("//*[@id = 'privacy-link']")).click();
        for (String str : driver.getWindowHandles()) {
            driver.switchTo().window(str);

        }
//        String ActualTitle = driver.getTitle();
//        String ExpectedTitle = "Meta Privacy Policy - How Meta collects and uses user data | Privacy Center";
//        assertEquals(ExpectedTitle, ActualTitle);

        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0";
        assertEquals(ExpectedUrl, ActualUrl);

    }
}

