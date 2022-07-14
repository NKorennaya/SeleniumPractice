import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSelemiumTest {

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
//

   @AfterEach
    public void testTeardown() {
        driver.get(HOME_PAGE_URL);
   }
//    }
//
    @Test
    public void homePageURLTest() {
        String actualURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, actualURL, "URLs do not match");
    }

    @Test
    public void findElementByAttributeTest() {
        //  WebElement element = driver.findElement(By.id("email"));
        // WebElement element = driver.findElement(By.name("email"));
        //  WebElement element = driver.findElement(By.linkText("Create a Page"));
        // WebElement element = driver.findElement(By.partialLinkText("a Page"));
        //  WebElement element = driver.findElement(By.cssSelector("#email"));
        //  WebElement element = driver.findElement(By.className("inputtext"));
        List<WebElement> element = driver.findElements(By.className("inputtext"));
        System.out.println(element.size());
        assertNotNull(element);
    }

    @Test
    public void findElementsByXpathTest() {
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);
        // WebElement forgotPassElement = driver.findElement(By.xpath("//a[text()='Forgot account?']"));
        // assertNotNull(forgotPassElement);
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text() = 'Create a Page']"));
        assertNotNull(createNewAccButton);
    }

    @Test
    public void loginScreenTest() {
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("lisa.krasa19@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("lisa.krasa19@gmail.com", emailValue);


        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("12345");
        String passValue = passwordElement.getAttribute("value");
        assertEquals("12345", passValue);

        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);

        loginButtonElement.click();


    }

    @Test
    public void signupTest() {
//    WebElement signUpButton = driver.findElement(By.xpath("//*[text() = 'Create new account']"));
//    signUpButton.click();
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
    }

    @Test
    public void genderTest() throws InterruptedException {
        String femaleXpath = "//*[@name = 'sex' and @value=1]";
        String maleXpath = "//*[@name = 'sex' and @value=2]";

        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));

        Thread.sleep(1000);

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

    }
    @Test
    public void errorMessageTest() throws InterruptedException {


        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@name = 'websubmit']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Mobile number or email']")).click();

        WebElement error = driver.findElement(By.xpath("//*[contains(text(),'to reset')]"));
        assertNotNull(error);

}
@Test
    public void yearTest() throws InterruptedException {
    driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
    assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
    Thread.sleep(1000);

    driver.findElement(By.xpath("//*[@title='Year']")).click();
    driver.findElement(By.xpath("//*[text() = '1990']")).click();
   String yearValue =  driver.findElement(By.xpath("//*[@title='Year']")).getAttribute("value");

   assertEquals("1990", yearValue);



}
    @ParameterizedTest
    @ValueSource(strings = {"1905", "1960", "2020"})
    public void yearTestParametrized(String yearInput) throws InterruptedException {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@title='Year']")).click();
        driver.findElement(By.xpath("//*[text() = '"+ yearInput +"']")).click();
        String yearValue =  driver.findElement(By.xpath("//*[@title='Year']")).getAttribute("value");

        assertEquals(yearInput, yearValue);

    }

@Test
    public void actionTest(){
        driver.get("https://www.daviktapes.com/");
        pause();
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Company']")));
        WebElement element = driver.findElement(By.xpath("//a[text()='Company']"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[text()='Company']")));
    Actions actions = new Actions(driver);
    actions.moveToElement(element).build().perform();
}
public void pause()  {
        try {


            Thread.sleep(5000);
        } catch (Exception err){
            System.out.println("Something wrong");
        }
}
    @Test
    public void waitAndClickTest(){
        driver.get("https://www.daviktapes.com/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Company']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Company']"))).click();
     //   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Company']"))).click();
        pause();

}}