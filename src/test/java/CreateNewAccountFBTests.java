import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class CreateNewAccountFBTests {

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

    @Test
    public void homePageURLTest() {
        String actualURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, actualURL, "URLs do not match");
    }

    @Test
    public void openCreateNewAccountForm()
            throws InterruptedException {
        WebElement buttonElement = driver.findElement(By.xpath("//*[text() = 'Create new account']"));
        buttonElement.click();
        Thread.sleep(1000);

        assertNotNull(buttonElement);

    }

    @Test
    public void SignUpPositiveTest() throws Exception {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys("Vasya");
        String firstNameFieldValue = firstNameField.getAttribute("value");
        assertEquals("Vasya", firstNameFieldValue);

        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys("Pupkin");
        String lastNameFieldValue = lastNameField.getAttribute("value");
        assertEquals("Pupkin", lastNameFieldValue);

        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys("vasya.pupkin@gmail.com");
        String mobNumberFieldValue = mobNumberField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", mobNumberFieldValue);

        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(confirmEmailField);
        confirmEmailField.sendKeys("vasya.pupkin@gmail.com");
        String confirmEmailFieldValue = confirmEmailField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", confirmEmailFieldValue);


        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys("12345");
        String newPasswordFieldValue = newPasswordField.getAttribute("value");
        assertEquals("12345", newPasswordFieldValue);

////    WebElement birthdayWrapper = driver.findElement(By.xpath("//input[@data-name='birthday_wrapper']"));
////    assertNotNull(birthdayWrapper);
////    birthdayWrapper.sendKeys("nextModule");
////    String birthdayWrapperValue = birthdayWrapper.getAttribute("value");
////    assertEquals("nextModule", birthdayWrapperValue);

        driver.findElement(By.xpath("//*[text() = 'Female']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }

    @Test
    public void SignUpSymbolFirstNameTest() throws Exception {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys("@#$%^&");
        String firstNameFieldValue = firstNameField.getAttribute("value");
        assertEquals("@#$%^&", firstNameFieldValue);

        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys("Pupkin");
        String lastNameFieldValue = lastNameField.getAttribute("value");
        assertEquals("Pupkin", lastNameFieldValue);

        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys("vasya.pupkin@gmail.com");
        String mobNumberFieldValue = mobNumberField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", mobNumberFieldValue);

        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(confirmEmailField);
        confirmEmailField.sendKeys("vasya.pupkin@gmail.com");
        String confirmEmailFieldValue = confirmEmailField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", confirmEmailFieldValue);


        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys("12345");
        String newPasswordFieldValue = newPasswordField.getAttribute("value");
        assertEquals("12345", newPasswordFieldValue);

        driver.findElement(By.xpath("//*[text() = 'Female']")).click();
        // driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }

    @Test
    public void SignUpSymbolLastNameTest() throws Exception {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys("Vasya");
        String firstNameFieldValue = firstNameField.getAttribute("value");
        assertEquals("Vasya", firstNameFieldValue);

        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys("!@#$%^");
        String lastNameFieldValue = lastNameField.getAttribute("value");
        assertEquals("!@#$%^", lastNameFieldValue);

        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys("vasya.pupkin@gmail.com");
        String mobNumberFieldValue = mobNumberField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", mobNumberFieldValue);

        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(confirmEmailField);
        confirmEmailField.sendKeys("vasya.pupkin@gmail.com");
        String confirmEmailFieldValue = confirmEmailField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", confirmEmailFieldValue);


        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys("12345");
        String newPasswordFieldValue = newPasswordField.getAttribute("value");
        assertEquals("12345", newPasswordFieldValue);

        driver.findElement(By.xpath("//*[text() = 'Female']")).click();
        // driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }

    @Test
    public void SignUpNumberFirstNameTest() throws Exception {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys("12345");
        String firstNameFieldValue = firstNameField.getAttribute("value");
        assertEquals("12345", firstNameFieldValue);

        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys("Pupkin");
        String lastNameFieldValue = lastNameField.getAttribute("value");
        assertEquals("Pupkin", lastNameFieldValue);

        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys("vasya.pupkin@gmail.com");
        String mobNumberFieldValue = mobNumberField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", mobNumberFieldValue);

        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(confirmEmailField);
        confirmEmailField.sendKeys("vasya.pupkin@gmail.com");
        String confirmEmailFieldValue = confirmEmailField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", confirmEmailFieldValue);


        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys("12345");
        String newPasswordFieldValue = newPasswordField.getAttribute("value");
        assertEquals("12345", newPasswordFieldValue);

        driver.findElement(By.xpath("//*[text() = 'Female']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }

    @Test
    public void SignUpNumberLastNameTest() throws Exception {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys("Vasya");
        String firstNameFieldValue = firstNameField.getAttribute("value");
        assertEquals("Vasya", firstNameFieldValue);

        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys("9876");
        String lastNameFieldValue = lastNameField.getAttribute("value");
        assertEquals("9876", lastNameFieldValue);

        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys("vasya.pupkin@gmail.com");
        String mobNumberFieldValue = mobNumberField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", mobNumberFieldValue);

        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(confirmEmailField);
        confirmEmailField.sendKeys("vasya.pupkin@gmail.com");
        String confirmEmailFieldValue = confirmEmailField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", confirmEmailFieldValue);


        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys("12345");
        String newPasswordFieldValue = newPasswordField.getAttribute("value");
        assertEquals("12345", newPasswordFieldValue);

        driver.findElement(By.xpath("//*[text() = 'Female']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }

    @Test
    public void SignUpNullFirstLastNameTest() throws Exception {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys("");
        String firstNameFieldValue = firstNameField.getAttribute("value");
        assertEquals("", firstNameFieldValue);

        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys("");
        String lastNameFieldValue = lastNameField.getAttribute("value");
        assertEquals("", lastNameFieldValue);

        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys("vasya.pupkin@gmail.com");
        String mobNumberFieldValue = mobNumberField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", mobNumberFieldValue);

        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(confirmEmailField);
        confirmEmailField.sendKeys("vasya.pupkin@gmail.com");
        String confirmEmailFieldValue = confirmEmailField.getAttribute("value");
        assertEquals("vasya.pupkin@gmail.com", confirmEmailFieldValue);


        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys("12345");
        String newPasswordFieldValue = newPasswordField.getAttribute("value");
        assertEquals("12345", newPasswordFieldValue);

        driver.findElement(By.xpath("//*[text() = 'Female']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }

    @Test
    public void SignUpWrongEmailFormatTest() throws Exception {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys("Vasya");

        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys("Pupkin");

        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys("vasya.pupkingmail.com");
        String mobNumberFieldValue = mobNumberField.getAttribute("value");
        assertEquals("vasya.pupkingmail.com", mobNumberFieldValue);

        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys("12345");
        String newPasswordFieldValue = newPasswordField.getAttribute("value");
        assertEquals("12345", newPasswordFieldValue);

        driver.findElement(By.xpath("//*[text() = 'Female']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }

    @Test
    public void SignUpDifferentEmailsTest() throws Exception {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys("Vasya");
        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys("Pupkin");

        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys("vasya.pupkin@gmail.com");

        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(confirmEmailField);
        confirmEmailField.sendKeys("vasia.pupkin@gmail.com");

        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys("12345");
        String newPasswordFieldValue = newPasswordField.getAttribute("value");
        assertEquals("12345", newPasswordFieldValue);

        driver.findElement(By.xpath("//*[text() = 'Female']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
    }

    @Test
    public void SignUpLongPasswordTest() throws Exception {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys("Vasya");
        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys("Pupkin");

        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys("vasya.pupkin@gmail.com");

        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(confirmEmailField);
        confirmEmailField.sendKeys("vasya.pupkin@gmail.com");

        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys("12345asdsghjkl;lk1234567890__)((*&&^gghhhhGTFYFYFIUFUYGOIUHPOOIJ{POKPOK}P{K}P{K}{PHGFFE%$%%^&");

        driver.findElement(By.xpath("//*[text() = 'Male']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
    }

    @Test
    public void SignUpNoPasswordTest() throws Exception {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys("Vasya");
        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys("Pupkin");

        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys("vasya.pupkin@gmail.com");

        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(confirmEmailField);
        confirmEmailField.sendKeys("vasya.pupkin@gmail.com");

        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys("");

        driver.findElement(By.xpath("//*[text() = 'Male']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
    }

    @Test
    public void SignUpShortPasswordTest() throws Exception {
        driver.findElement(By.xpath("//*[text() = 'Create new account']")).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys("Vasya");
        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys("Pupkin");

        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys("vasya.pupkin@gmail.com");

        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(confirmEmailField);
        confirmEmailField.sendKeys("vasya.pupkin@gmail.com");

        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys("a2");

        driver.findElement(By.xpath("//*[text() = 'Male']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Vasya", "Pupkin", "vasya.pupkin@gmail.com", "vasya.pupkin@gmail.com", "A1234!"),
                Arguments.of("", "Pupkin", "vasya.pupkin@gmail.com", "vasya.pupkin@gmail.com", "A1234!"),
                Arguments.of("Vasya", "", "vasya.pupkin@gmail.com", "vasya.pupkin@gmail.com", "A1234!"),
                Arguments.of("Vasya", "Pupkin", "vasya.pupkin@gmail.com", "vasia.pupkin@gmail.com", "A1234!"),
                Arguments.of("Vasya", "Pupkin", "vasya.pupkingmail.com", "vasya.pupkingmail.com", "A1234!"),
                Arguments.of("1234567", "Pupkin", "vasya.pupkin@gmail.com", "vasya.pupkin@gmail.com", "A1234!"),
                Arguments.of("Vasya", "@#$%^&", "vasya.pupkin@gmail.com", "vasya.pupkin@gmail.com", "A1234!"),
                Arguments.of("Vasya", "Pupkin", "vasya.pupkin@gmail.com", "vasya.pupkin@gmail.com", ""),
                Arguments.of("Vasya", "Pupkin", "vasya.pupkin@gmail.com", "vasya.pupkin@gmail.com", "A1234!"),
                Arguments.of("Vasya", "Pupkin", "", "", "A1234!")
        );
    }
//не пойму почему падают 3 теста, и, также, если араи expectedResult/actualResult правильно созданы и сравниваются.

    @ParameterizedTest

    @MethodSource("dataProvider")

    public void methodSourceTest(String firstName, String lastName, String email, String confirmEmail, String password)

            throws InterruptedException {
        WebElement buttonElement = driver.findElement(By.xpath("//*[text() = 'Create new account']"));
        buttonElement.click();
        Thread.sleep(1000);


        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameField);
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameField);
        lastNameField.sendKeys(lastName);
        WebElement mobNumberField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(mobNumberField);
        mobNumberField.sendKeys(email);
        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(confirmEmailField);
        confirmEmailField.sendKeys(confirmEmail);
        WebElement newPasswordField = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        assertNotNull(newPasswordField);
        newPasswordField.sendKeys(password);

        driver.findElement(By.xpath("//*[text() = 'Male']")).click();

        ArrayList<String> expectedResult = new ArrayList();
        expectedResult.add(firstName);
        expectedResult.add(lastName);
        expectedResult.add(email);
        expectedResult.add(confirmEmail);
        expectedResult.add(password);
       // System.out.println(expectedResult);

        ArrayList<String> actualResult = new ArrayList();
        actualResult.add(firstNameField.getAttribute("value"));
        actualResult.add(lastNameField.getAttribute("value"));
        actualResult.add(mobNumberField.getAttribute("value"));
        actualResult.add(confirmEmailField.getAttribute("value"));
        actualResult.add(newPasswordField.getAttribute("value"));
       // System.out.println(actualResult);

        assertEquals(expectedResult, actualResult);


//        driver.findElement(By.xpath("//*[text() = 'Male']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

//        ArrayList<String> expectedResult = new ArrayList();
//        expectedResult.add(firstName);
//        expectedResult.add(lastName);
//        expectedResult.add(email);
//        expectedResult.add(confirmEmail);
//        expectedResult.add(password);
//    System.out.println(expectedResult);
//
//        ArrayList<String> actualResult = new ArrayList();
//        actualResult.add(firstNameField.getAttribute("value"));
//        actualResult.add(lastNameField.getAttribute("value"));
//        actualResult.add(mobNumberField.getAttribute("value"));
//        actualResult.add(confirmEmailField.getAttribute("value"));
//        actualResult.add(newPasswordField.getAttribute("value"));
//    System.out.println(actualResult);
//
//        assertEquals(expectedResult, actualResult);

    }
}

//также, обратите внимание на бонусный класс Registration (наследует из Data). Там можно менять переменные в Data и будет супер :)