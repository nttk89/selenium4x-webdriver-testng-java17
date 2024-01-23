package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

public class Topic_04_XPath_02 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    //Locator
    String FULLNAME_TXT_XP = "//input[@id='txtFirstname']";
    String EMAIL_TXT_XP = "//input[@id='txtEmail']";
    String CONFIRM_EMAIL_TXT_XP = "//input[@id='txtCEmail']";
    String PASSWORD_TXT_XP = "//input[@id='txtPassword']";
    String CONFIRM_PASSWORD_TXT_XP = "//input[@id='txtCPassword']";
    String PHONE_TXT_XP = "//input[@id='txtPhone']";
    String POLICY_TXT_XP = "//input[@id='chkRight']";
    String REGISTER_BTN_XP = "//button[text()='ĐĂNG KÝ' and @type='submit']";
    String FULLNAME_LBL_XP = "//label[@id='txtFirstname-error']";
    String EMAIL_LBL_XP = "//label[@id='txtEmail-error']";
    String CONFIRM_EMAIL_LBL_XP = "//label[@id='txtCEmail-error']";
    String PASSWORD_LBL_XP = "//label[@id='txtPassword-error']";
    String CONFIRM_PASSWORD_LBL_XP = "//label[@id='txtCPassword-error']";
    String PHONE_LBL_XP = "//label[@id='txtPhone-error']";
//String POLICY_TXT_XP = "//label[@id='chkRight-error']";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void Register_01_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.xpath(REGISTER_BTN_XP)).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.xpath(FULLNAME_LBL_XP)).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.xpath(EMAIL_LBL_XP )).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.xpath(CONFIRM_EMAIL_LBL_XP)).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.xpath(PASSWORD_LBL_XP )).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.xpath(CONFIRM_PASSWORD_LBL_XP )).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.xpath(PHONE_LBL_XP )).getText(), "Vui lòng nhập số điện thoại.");
    }

    @Test
    public void Register_02_Invalid_Email_Address() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.xpath(FULLNAME_TXT_XP )).sendKeys("Automation Testing");
        driver.findElement(By.xpath(EMAIL_TXT_XP )).sendKeys("123@123@123");
        driver.findElement(By.xpath(CONFIRM_EMAIL_TXT_XP )).sendKeys("123@123@123");
        driver.findElement(By.xpath(PASSWORD_TXT_XP )).sendKeys("123456");
        driver.findElement(By.xpath(CONFIRM_PASSWORD_TXT_XP )).sendKeys("123456");
        driver.findElement(By.xpath(PHONE_TXT_XP )).sendKeys("0987654321");
        driver.findElement(By.xpath(REGISTER_BTN_XP)).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.xpath(EMAIL_LBL_XP )).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.xpath(CONFIRM_EMAIL_LBL_XP)).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.xpath(FULLNAME_TXT_XP )).sendKeys("Automation Testing");
        driver.findElement(By.xpath(EMAIL_TXT_XP )).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath(CONFIRM_EMAIL_TXT_XP )).sendKeys("automation@hotmail.com");
        driver.findElement(By.xpath(PASSWORD_TXT_XP )).sendKeys("123456");
        driver.findElement(By.xpath(CONFIRM_PASSWORD_TXT_XP )).sendKeys("123456");
        driver.findElement(By.xpath(PHONE_TXT_XP )).sendKeys("0987654321");
        driver.findElement(By.xpath(REGISTER_BTN_XP)).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.xpath(CONFIRM_EMAIL_LBL_XP)).getText(), "Email nhập lại không đúng");

    }

    @Test
    public void Register_04_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.xpath(FULLNAME_TXT_XP )).sendKeys("Automation Testing");
        driver.findElement(By.xpath(EMAIL_TXT_XP )).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath(CONFIRM_EMAIL_TXT_XP )).sendKeys("automation@hotmail.com");
        driver.findElement(By.xpath(PASSWORD_TXT_XP )).sendKeys("12345");
        driver.findElement(By.xpath(CONFIRM_PASSWORD_TXT_XP )).sendKeys("12345");
        driver.findElement(By.xpath(PHONE_TXT_XP )).sendKeys("0987654321");
        driver.findElement(By.xpath(REGISTER_BTN_XP)).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.xpath(PASSWORD_LBL_XP )).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.xpath(CONFIRM_PASSWORD_LBL_XP )).getText(), "Mật khẩu phải có ít nhất 6 ký tự");

    }

    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.xpath(FULLNAME_TXT_XP )).sendKeys("Automation Testing");
        driver.findElement(By.xpath(EMAIL_TXT_XP )).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath(CONFIRM_EMAIL_TXT_XP )).sendKeys("automation@hotmail.com");
        driver.findElement(By.xpath(PASSWORD_TXT_XP )).sendKeys("123456");
        driver.findElement(By.xpath(CONFIRM_PASSWORD_TXT_XP )).sendKeys("123457");
        driver.findElement(By.xpath(PHONE_TXT_XP )).sendKeys("0987654321");
        driver.findElement(By.xpath(REGISTER_BTN_XP)).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.xpath(CONFIRM_PASSWORD_LBL_XP )).getText(), "Mật khẩu bạn nhập không khớp");

    }

    @Test
    public void Register_06_Invalid_Phone_Number() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Phone less than 10 chars
        driver.findElement(By.xpath(FULLNAME_TXT_XP )).sendKeys("Automation Testing");
        driver.findElement(By.xpath(EMAIL_TXT_XP )).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath(CONFIRM_EMAIL_TXT_XP )).sendKeys("automation@hotmail.com");
        driver.findElement(By.xpath(PASSWORD_TXT_XP )).sendKeys("123456");
        driver.findElement(By.xpath(CONFIRM_PASSWORD_TXT_XP )).sendKeys("123457");
        driver.findElement(By.xpath(PHONE_TXT_XP )).sendKeys("098765432");
        driver.findElement(By.xpath(REGISTER_BTN_XP)).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        // Phone more than 11 chars
        driver.findElement(By.xpath(PHONE_TXT_XP )).clear();
        driver.findElement(By.xpath(PHONE_TXT_XP )).sendKeys("098765432123");
        driver.findElement(By.xpath(REGISTER_BTN_XP)).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        // Phone # Phone Center number
        driver.findElement(By.xpath(PHONE_TXT_XP )).clear();
        driver.findElement(By.xpath(PHONE_TXT_XP )).sendKeys("12345678910");
        driver.findElement(By.xpath(REGISTER_BTN_XP)).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}