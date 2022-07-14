import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DavikSiteTests {

    private static final String HOME_PAGE_URL = "https://daviktapes.com/";
    private static WebDriver driver;


    @BeforeAll
    public static void classSetup() {
        driver = ShareDriver.getWebDriver();
        driver.navigate().to(HOME_PAGE_URL);

    }

    @AfterEach
    public void testTeardown() {
        driver.get(HOME_PAGE_URL);
    }

    @AfterAll
    public static void classTearDown() {
        ShareDriver.closeDriver();
    }

    @Test
    public void homeMenuOptionTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Home']"))).click();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Advanced Adhesive Tape Manufacturer | DAVIK Tape";
        assertEquals(ExpectedTitle, ActualTitle);
    }

    @Test
    public void companyMenuOptionTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Company']"))).click();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[text()='Company']"));
        actions.moveToElement(element).build().perform();
        WebElement menu = driver.findElement(By.xpath("//*[contains(text(),'About us')]"));
        assertNotNull(menu);
    }

    @Test
    public void productsMenuOptionTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Products']")));
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[text()='Products']"));
        actions.moveToElement(element).build().perform();
        WebElement menu = driver.findElement(By.xpath("//*[contains(text(),'Carry Handle Tape')]"));
        assertNotNull(menu);

    }

    @Test
    public void industriesMenuOptionTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Industries']")));
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[text()='Industries']"));
        actions.moveToElement(element).build().perform();
        WebElement menu = driver.findElement(By.xpath("//*[contains(text(),'Non Woven')]"));
        assertNotNull(menu);

    }

    @Test
    public void knowledgeCenterMenuOptionTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Knowledge Center']")));
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[text()='Knowledge Center']"));
        actions.moveToElement(element).build().perform();
        WebElement menu = driver.findElement(By.xpath("//*[contains(text(),'Articles')]"));
        assertNotNull(menu);
        WebElement menu2 = driver.findElement(By.xpath("//*[contains(text(),'Events')]"));
        assertNotNull(menu2);

    }

    @Test
    public void bonusContactTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-item-4167']"))).click();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id='menu-item-4167']"));
        actions.moveToElement(element).build().perform();
        for (String str : driver.getWindowHandles()) {
            driver.switchTo().window(str);

        }
        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "https://daviktapes.com/contact-us-new/";
        assertEquals(ExpectedUrl, ActualUrl);
    }


}
