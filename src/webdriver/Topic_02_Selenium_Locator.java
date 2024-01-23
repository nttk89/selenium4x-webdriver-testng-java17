package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import java.time.Duration;

public class Topic_02_Selenium_Locator {
    // Khai báo 1 biến để đại diện cho thư viện Selenium WebDriver
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        // Bước 1: Mở browser lên
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    /**
     * TestNG: Order testcase theo Alphabet (0-9 A-Z)
     * Firstname textbox - HTML Code
     * HTML Element: <tagname attribute_name_1='attribute_value' attribute_name_2='attribute_value' ...>
     * <input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
     */


    @Test
    public void TC_01_Summary() {
        // Bước 2: Nhập vào Url
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        // Bước 3: Click vào My Account để mở trang login ra

        /**HTML của element (Email Textbox)
         <input type="email" autocapitalize="none"
         autocorrect="off" spellcheck="false"
         name="login[username]" value=""
         id="email" class="input-text required-entry validate-email"
         title="Email Address">*/

        /**HTML của element (Email Textbox)
         input - thẻ của element này (tagname)
         attribute name - type autocapitalize  autocorrect spellcheck name value id class title
         attribute value - email none off ..
         */

        // Xpath Format
        //tagname[@attribute-name='attribute-value']

        //input[@name='login[username]']  -> *
        //input[@id='email']  -> *
        //input[@title='Email Address']   -> *

        // CSS Format:	tagname[attribute-name='attribute-value']

        // ID - Email Textbox
        driver.findElement(By.id("email"));

        // Class - New User form
        // 1 - Giá trị ko có khoảng trắng -> Lấy hết
        // 2 - Giá trị chứa khoảng trắng -> Lấy 1 phần
        driver.findElement(By.className("new-users"));

        // Name - Email Textbox
        driver.findElement(By.name("login[username]"));

        // Tagname - Tìm xem có bao nhiêu element/ page
        driver.findElements(By.tagName("a"));

        // LinkText (Link) - Text tuyệt đối
        driver.findElement(By.linkText("SEARCH TERMS"));

        // Partial LinkText (Link) - Text tương đối/ tuyệt đối
        driver.findElement(By.partialLinkText("SEARCH TERMS"));
        driver.findElement(By.partialLinkText("CH TER"));
        driver.findElement(By.partialLinkText("SEARCH"));
        driver.findElement(By.partialLinkText("TERMS"));

        // Css - Cover được hết cả 6 loại trên
        driver.findElement(By.cssSelector("input[name='login[username]']"));
        driver.findElement(By.cssSelector("input[id='email']"));
        driver.findElement(By.cssSelector("input[title='Email Address']"));

        // XPath
        driver.findElement(By.xpath("//input[@name='login[username]']"));
        driver.findElement(By.xpath("//input[@id='email']"));
    }

    @Test
    public void TC_01_ID() {
        // Mở trang register
        driver.get("https://demo.nopcommerce.com/register");

        driver.findElement(By.id("FirstName")).sendKeys("Automation");;
    }

    @Test
    public void TC_02_Class() {
        // Mở trang register
        driver.get("https://demo.nopcommerce.com/register");

        //<div class="search-box store-search-box">...</div>
        driver.findElement(By.className("store-search-box"));

    }

    @Test
    public void TC_03_Name() {
        // Mở trang register
        driver.get("https://demo.nopcommerce.com/register");

        //<select name="DateOfBirthDay"> ....</select>
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_Tagname() {
        // Mở trang register
        driver.get("https://demo.nopcommerce.com/register");

        driver.findElements(By.tagName("input"));
    }

    @Test
    public void TC_05_LinkText() {
        // Mở trang register
        driver.get("https://demo.nopcommerce.com/register");

        //<a href="/shipping-returns">Shipping & returns</a>
        // Độ chính xác cao = tuyệt đối = toàn bộ
        //Bắt buộc phải lấy toàn bộ text
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Partial_LinkText() {
        // Mở trang register
        driver.get("https://demo.nopcommerce.com/register");

        //<a href="/vendor/apply">Apply for vendor account</a>
        // Độ chính xác ko cao = tương đối = 1 phần (đầu/ giữa/ cuối)
        //Chỉ cần lấy 1 phần link text là được
        driver.findElement(By.partialLinkText("for vendor"));
        driver.findElement(By.partialLinkText("vendor account"));
        driver.findElement(By.partialLinkText("Apply for vendor"));
    }

    @Test
    public void TC_07_Css() {
        // Mở trang register
        driver.get("https://demo.nopcommerce.com/register");

        //<input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
        // Css vs ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        // Css vs Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        // Css vs Name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        // Css vs tagname
        driver.findElement(By.cssSelector("input"));

        // Css vs link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        // Css vs partial link
        driver.findElement(By.cssSelector("a[href*='addresses']"));
        // driver.findElement(By.cssSelector("a[href^='addresses']"));
        // driver.findElement(By.cssSelector("a[href$='addresses']"));
    }

    @Test
    public void TC_08_XPath() {
        // Mở trang register
        driver.get("https://demo.nopcommerce.com/register");

        //<input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
        // XPath vs ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // XPath vs Class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        // XPath vs Name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        // XPath vs tagname
        driver.findElement(By.xpath("//input"));

        // XPath vs link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));

        // Compile
        driver.findElement(By.xpath("//div[@id=\"pageFooterChildren\"]"));
        driver.findElement(By.xpath("//div[@id='pageFooterChildren']"));

        // XPath vs partial link
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}