import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration extends Data {
    private static final String HOME_PAGE_URL = "https://www.facebook.com/";
    private static WebDriver driver;


    private By buttonCreateNewAccount = By.xpath("//*[text() = 'Create new account']");
    private By inputFirstName = By.xpath("//input[@name='firstname']");
    private By inputLastName = By.xpath("//input[@name='lastname']");
    private By inputEmail = By.xpath("//input[@name='reg_email__']");
    private By confirmEmail = By.xpath("//input[@name='reg_email_confirmation__']");
    private By inputPassword = By.xpath("//input[@id='password_step_input']");
    private By gender = By.xpath("//*[text() = 'Male']");
    private By buttonSignUp = By.xpath("//button[@name='websubmit']");

    @BeforeAll
    public static void classSetup() {
        driver = ShareDriver.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }

    @Test
    public void signUpForm() throws Exception {
        driver.findElement(buttonCreateNewAccount).click();
        Thread.sleep(1000);
        Data getDate = new Data();
       driver.findElement(inputFirstName).sendKeys(getDate.firstName);
       driver.findElement(inputLastName).sendKeys(getDate.lastName);
        driver.findElement(inputEmail).sendKeys(getDate.email);
        driver.findElement(confirmEmail).sendKeys(getDate.email);
       driver.findElement(inputPassword).sendKeys(getDate.password);
       driver.findElement(gender).click();
       driver.findElement(buttonSignUp).click();
    }

}
