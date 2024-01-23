package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_XPath_02_Repeat01 {
    WebDriver driver;
    WebDriverWait wait;

    //Locator
    String FULLNAME_TXT_XP = "//input[@id='txtFirstname']";
    String EMAIL_TXT_XP = "//input[@id='txtEmail']";
    String CONFIRM_EMAIL_TXT_XP = "//input[@id='txtCEmail']";
    String PASSWORD_TXT_XP = "//input[@id='txtPassword']";
    String CONFIRM_PASSWORD_TXT_XP = "//input[@id='txtCPassword']";
    String PHONE_TXT_XP = "//input[@id='txtPhone']";
    String POLICY_TXT_XP = "//input[@id='chkRight']";
    String REGISTER_BTN_XP = "//button[text()='ĐĂNG KÝ' and @type='submit']";
    String FULLNAME_LBL_ERROR_XP = "//label[@id='txtFirstname-error']";
    String EMAIL_LBL_ERROR_XP = "//label[@id='txtEmail-error']";
    String CONFIRM_EMAIL_LBL_ERROR_XP = "//label[@id='txtCEmail-error']";
    String PASSWORD_LBL_ERROR_XP = "//label[@id='txtPassword-error']";
    String CONFIRM_PASSWORD_LBL_ERROR_XP = "//label[@id='txtCPassword-error']";
    String PHONE_LBL_ERROR_XP = "//label[@id='txtPhone-error']";
    //String POLICY_TXT_XP = "//label[@id='chkRight-error']";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void Register_01_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        sleepInSecond(1);

        // Action
        driver.findElement(By.xpath(REGISTER_BTN_XP)).click();

        // Verify
        Assert.assertEquals(getTextDisplayInElement(FULLNAME_LBL_ERROR_XP), "Vui lòng nhập họ tên");
        Assert.assertEquals(getTextDisplayInElement(EMAIL_LBL_ERROR_XP ), "Vui lòng nhập email");
        Assert.assertEquals(getTextDisplayInElement(CONFIRM_EMAIL_LBL_ERROR_XP), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(getTextDisplayInElement(PASSWORD_LBL_ERROR_XP ), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(getTextDisplayInElement(CONFIRM_PASSWORD_LBL_ERROR_XP ), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(getTextDisplayInElement(PHONE_LBL_ERROR_XP ), "Vui lòng nhập số điện thoại.");
    }

    @Test
    public void Register_02_Invalid_Email_Address() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        sleepInSecond(1);

        // Action
        sendKeyToElement(FULLNAME_TXT_XP,"Automation Testing");
        sendKeyToElement(EMAIL_TXT_XP,"automation@123@gmail.com");
        sendKeyToElement(CONFIRM_EMAIL_TXT_XP,"automation@123@gmail.com");
        sendKeyToElement(PASSWORD_TXT_XP,"123456");
        sendKeyToElement(CONFIRM_PASSWORD_TXT_XP ,"123456");
        sendKeyToElement(PHONE_TXT_XP,"0987654321");
        clickToElement(REGISTER_BTN_XP);

        // Verify
        Assert.assertEquals(getTextDisplayInElement(EMAIL_LBL_ERROR_XP ), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(getTextDisplayInElement(CONFIRM_EMAIL_LBL_ERROR_XP), "Email nhập lại không đúng");
    }

    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        sleepInSecond(1);

        // Action
        sendKeyToElement(FULLNAME_TXT_XP,"Automation Testing");
        sendKeyToElement(EMAIL_TXT_XP,"automation@gmail.com");
        sendKeyToElement(CONFIRM_EMAIL_TXT_XP,"automation@yahoo.com");
        sendKeyToElement(PASSWORD_TXT_XP,"123456");
        sendKeyToElement(CONFIRM_PASSWORD_TXT_XP ,"123456");
        sendKeyToElement(PHONE_TXT_XP,"0987654321");
        clickToElement(REGISTER_BTN_XP);

        // Verify
        Assert.assertEquals(getTextDisplayInElement(CONFIRM_EMAIL_LBL_ERROR_XP), "Email nhập lại không đúng");

    }

    @Test
    public void Register_04_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        sleepInSecond(1);

        // Action
        sendKeyToElement(FULLNAME_TXT_XP,"Automation Testing");
        sendKeyToElement(EMAIL_TXT_XP,"automation@gmail.com");
        sendKeyToElement(CONFIRM_EMAIL_TXT_XP,"automation@gmail.com");
        sendKeyToElement(PASSWORD_TXT_XP,"12345");
        sendKeyToElement(CONFIRM_PASSWORD_TXT_XP ,"12345");
        sendKeyToElement(PHONE_TXT_XP,"0987654321");
        clickToElement(REGISTER_BTN_XP);

        // Verify
        Assert.assertEquals(getTextDisplayInElement(PASSWORD_LBL_ERROR_XP ), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(getTextDisplayInElement(CONFIRM_PASSWORD_LBL_ERROR_XP ), "Mật khẩu phải có ít nhất 6 ký tự");

    }

    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        sleepInSecond(1);

        // Action
        sendKeyToElement(FULLNAME_TXT_XP,"Automation Testing");
        sendKeyToElement(EMAIL_TXT_XP,"automation@gmail.com");
        sendKeyToElement(CONFIRM_EMAIL_TXT_XP,"automation@gmail.com");
        sendKeyToElement(PASSWORD_TXT_XP,"123456");
        sendKeyToElement(CONFIRM_PASSWORD_TXT_XP ,"123457");
        sendKeyToElement(PHONE_TXT_XP,"0987654321");
        clickToElement(REGISTER_BTN_XP);

        // Verify
        Assert.assertEquals(getTextDisplayInElement(CONFIRM_PASSWORD_LBL_ERROR_XP), "Mật khẩu bạn nhập không khớp");

    }

    @Test
    public void Register_06_Invalid_Phone_Number() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        sleepInSecond(1);

        // Phone less than 10 chars
        sendKeyToElement(FULLNAME_TXT_XP,"Automation Testing");
        sendKeyToElement(EMAIL_TXT_XP,"automation@gmail.com");
        sendKeyToElement(CONFIRM_EMAIL_TXT_XP,"automation@gmail.com");
        sendKeyToElement(PASSWORD_TXT_XP,"123456");
        sendKeyToElement(CONFIRM_PASSWORD_TXT_XP ,"123456");
        sendKeyToElement(PHONE_TXT_XP,"098765432");
        clickToElement(REGISTER_BTN_XP);

        // Verify
        Assert.assertEquals(getTextDisplayInElement(PHONE_LBL_ERROR_XP), "Số điện thoại phải từ 10-11 số.");

        // Phone more than 11 chars
        sendKeyToElement(PHONE_TXT_XP,"098765432123");
        clickToElement(REGISTER_BTN_XP);

        // Verify
        Assert.assertEquals(getTextDisplayInElement(PHONE_LBL_ERROR_XP), "Số điện thoại phải từ 10-11 số.");

        // Phone # Phone Center number
        sendKeyToElement(PHONE_TXT_XP,"12345678910");
        clickToElement(REGISTER_BTN_XP);

        // Verify
        Assert.assertEquals(getTextDisplayInElement(PHONE_LBL_ERROR_XP), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long seconds){
        try{
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForDisplay(String xpLocator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpLocator)));
    }

    public void waitForToClick(String xpLocator){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpLocator)));
    }

    public WebElement getElement(String xpLocator){
        waitForDisplay(xpLocator);
        return driver.findElement(By.xpath(xpLocator));
    }

    public void sendKeyToElement(String xpLocator, String value){
        WebElement e = getElement(xpLocator);
        e.click();
        e.clear();
        e.sendKeys(value);
    }

    public void clickToElement(String xpLocator){
        waitForToClick(xpLocator);
        getElement(xpLocator).click();
    }

    public String getTextDisplayInElement(String xpLocator){
        return getElement(xpLocator).getText();
    }
}