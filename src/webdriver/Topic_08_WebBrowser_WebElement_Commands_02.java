package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_08_WebBrowser_WebElement_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    /*************************WEB BROWSER*********************************/

    @Test
    public void Part_I_WebBrowser_TC_01_Page_Url() {
        //Step 01 - Truy cập vào trang: http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        //Step 02 - Click MY ACCOUNT link tại footer
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(3);

        //Step 03 - Verify url của Login Page = http://live.techpanda.org/index.php/customer/account/login/
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "http://live.techpanda.org/index.php/customer/account/login/"
        );

        //Step 04 - Click CREATE AN ACCOUNT button
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSeconds(3);

        //Step 05 - Verify url của Register Page = http://live.techpanda.org/index.php/customer/account/create/
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "http://live.techpanda.org/index.php/customer/account/create/"
        );
    }

    @Test
    public void Part_I_WebBrowser_TC_02_Page_Title() {
        //Step 01 - Truy cập vào trang: http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        //Step 02 - Click MY ACCOUNT link tại footer
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(3);

        //Step 03 - Verify title của Login Page = Customer Login
        Assert.assertEquals(
                driver.getTitle(),
                "Customer Login"
        );

        //Step 04 - Click CREATE AN ACCOUNT button
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSeconds(3);

        //Step 05 - Verify title của Register Page = Create New Customer Account
        Assert.assertEquals(
                driver.getTitle(),
                "Create New Customer Account"
        );
    }

    @Test
    public void Part_I_WebBrowser_TC_03_Page_Navigation() {
        //Step 01 - Truy cập vào trang: http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        //Step 02 - Click MY ACCOUNT link tại footer
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(3);

        //Step 03 - Click CREATE AN ACCOUNT button
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSeconds(3);

        //Step 04 - Verify url của Register Page = http://live.techpanda.org/index.php/customer/account/create/
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "http://live.techpanda.org/index.php/customer/account/create/"
        );

        //Step 05 - Back lại trang Login Page
        driver.navigate().back();

        //Step 06 - Verify url của Login Page = http://live.techpanda.org/index.php/customer/account/login/
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "http://live.techpanda.org/index.php/customer/account/login/"
        );

        //Step 07 - Forward tới trang Register Page
        driver.navigate().forward();

        //Step 08 - Verify title của Register Page = Create New Customer Account
        Assert.assertEquals(
                driver.getTitle(),
                "Create New Customer Account"
        );
    }

    @Test
    public void Part_I_WebBrowser_TC_04_Page_Source() {
        //Step 01 - Truy cập vào trang: http://live.techpanda.org/
        driver.get("http://live.techpanda.org/index.php/");

        //Step 02 - Click MY ACCOUNT link tại footer
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(3);

        //Step 03 - Verify Login Page chứa text: Login or Create an Account
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        //Step 04 - Click CREATE AN ACCOUNT button
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSeconds(3);

        //Step 05 - Verify Register Page chứa text: Create an Account
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
    }

    /*************************WEB ELEMENT*********************************/

    @Test
    public void Part_II_WebElement_TC_01_Displayed() {
        //Locator Display
        String email_txt_xp = "//input[@id='mail']";
        String age_under_18_rtn_xp = "//input[@id='over_18']";
        String education_txt_xp = "//textarea[@id='edu']";

        //Step 01 - Truy cập vào trang: https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");

        System.out.println("Step 02 - Kiểm tra các phần tử sau hiển thị trên trang");
        //Step 02.1 - Kiểm tra các phần tử sau hiển thị trên trang: Email
        if(driver.findElement(By.xpath(email_txt_xp)).isDisplayed()){
            driver.findElement(By.xpath(email_txt_xp)).sendKeys("Automation Testing");
            System.out.println("[Email Textbox] is displayed");
        }else{
            System.out.println("[Email Textbox] is not displayed");
        }

        //Step 02.2 - Kiểm tra các phần tử sau hiển thị trên trang: Age (Under 18)
        if(driver.findElement(By.xpath(age_under_18_rtn_xp)).isDisplayed()){
            driver.findElement(By.xpath(age_under_18_rtn_xp)).click();
            System.out.println("[Age - Under 18 Radio button] is displayed");
        }else{
            System.out.println("[Age - Under 18 Radio button] is not displayed");
        }

        //Step 02.3 - Kiểm tra các phần tử sau hiển thị trên trang: Education
        if(driver.findElement(By.xpath(education_txt_xp)).isDisplayed()){
            driver.findElement(By.xpath(education_txt_xp)).sendKeys("Automation Testing");
            System.out.println("[Education TextArea] is displayed");
        }else{
            System.out.println("E[Education TextArea] is not displayed");
        }

        System.out.println("Step 03 - Kiểm tra phần tử sau không hiển thị trên trang");
        //Step 03 - Kiểm tra phần tử sau không hiển thị trên trang
        if(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            System.out.println("[Name User5 Textbox] is displayed");
        }else{
            System.out.println("[Name User5 Textbox] is not displayed");
        }

        /**
         * Note - Nếu có hiển thị thì nhập giá trị
         *          Automation Testing vào 2 field Email/ Education
         *          Click Chọn Age = Under 18
         *          In ra màn hình là phần tử đó có hiển thị ở trên trang hay ko
         *              Có: Element is displayed
         *              Không: Element is not displayed
         */
    }

    @Test
    public void Part_II_WebElement_TC_02_Enabled() {
        //Locator Enable
        String email_txt_xp = "//input[@id='mail']";
        String age_under_18_rtn_xp = "//input[@id='over_18']";
        String education_txt_xp = "//textarea[@id='edu']";
        String job_role1_drb_xp = "//select[@id='job1']";
        String job_role2_drb_xp = "//select[@id='job2']";
        //String interests_development_cbx_xp = "//label[contains(text(), 'Interests:')]/following-sibling::input[@id='development']";
        String interests_development_cbx_xp = "//input[@id='development']";
        String slider1_txt_xp = "//input[@id='slider-1']";
        //String language_java_cbx_xp = "//label[contains(text(), 'Languagues')]/following-sibling::input[@id='java']";
        String language_java_cbx_xp = "//input[@id='java']";

        //Locator Disable
        String password_txt_xp = "//input[@id='disable_password']";
        String age_disable_rtn_xp = "//input[@id='radio-disabled']";
        String biography_txt_xp = "//textarea[@id='bio']";
        String job_role3_drb_xp = "//select[@id='job3']";
        //String interests_check_disable_cbx_xp = "//label[contains(text(), 'Interests:')]/following-sibling::input[@id='check-disbaled']";
        String interests_check_disable_cbx_xp = "//input[@id='check-disbaled']";
        String slider2_txt_xp = "//input[@id='slider-2']";

        //Step 01 - Truy cập vào trang: https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");

        System.out.println("Step 02 - Kiểm tra các phần tử sau enable trên trang");
        //Step 02.1 - Kiểm tra các phần tử sau enable trên trang: Email
        if (driver.findElement(By.xpath(email_txt_xp)).isEnabled()) {
            System.out.println("[Email Textbox] is enabled");
        } else {
            System.out.println("[Email Textbox] is disabled");
        }

        //Step 02.2 - Kiểm tra các phần tử sau enable trên trang: Age (Under 18)
        if (driver.findElement(By.xpath(age_under_18_rtn_xp)).isEnabled()) {
            System.out.println("[Age Under 18 Radio ] is enabled");
        } else {
            System.out.println("[Age Under 18 Radio Button] is disabled");
        }

        //Step 02.3 - Kiểm tra các phần tử sau enable trên trang: Education
        if (driver.findElement(By.xpath(education_txt_xp)).isEnabled()) {
            System.out.println("[Education Textarea] is enabled");
        } else {
            System.out.println("[Education Textarea] is disabled");
        }

        //Step 02.4 - Kiểm tra các phần tử sau enable trên trang: Job Role 01/ Job Role 02
        if (driver.findElement(By.xpath(job_role1_drb_xp)).isEnabled()) {
            System.out.println("[Job Role 1 Slider] is enabled");
        } else {
            System.out.println("[Job Role 1 Slider] is disabled");
        }

        //Step 02.5 - Kiểm tra các phần tử sau enable trên trang: Interests (Development) Checkbox
        if (driver.findElement(By.xpath(interests_development_cbx_xp)).isEnabled()) {
            System.out.println("[Interests] - Develop Checkbox is enabled");
        } else {
            System.out.println("[Interests] - Develop Checkbox is disabled");
        }

        //Step 02.6 - Kiểm tra các phần tử sau enable trên trang: Slider 01
        if (driver.findElement(By.xpath(slider1_txt_xp)).isEnabled()) {
            System.out.println("[Slider 01 Slider] is enabled");
        } else {
            System.out.println("[Slider 01 Slider] is disabled");
        }

        System.out.println("Step 03 - Kiểm tra các phần tử sau disable trên trang");
        //Step 03.1 - Kiểm tra các phần tử sau disable trên trang: Password
        if (driver.findElement(By.xpath(password_txt_xp)).isDisplayed()) {
            System.out.println("[Password Textbox] is disabled");
        } else {
            System.out.println("[Password Textbox] is enabled");
        }

        //Step 03.2 - Kiểm tra các phần tử sau disable trên trang: Age (Radiobutton is disabled)
        if (driver.findElement(By.xpath(age_disable_rtn_xp)).isDisplayed()) {
            System.out.println("[Age - Radio button is disabled] is disabled");
        } else {
            System.out.println("[Age - Radio button is disabled] is enabled");
        }

        //Step 03.3 - Kiểm tra các phần tử sau disable trên trang: Biography
        if (driver.findElement(By.xpath(biography_txt_xp)).isDisplayed()) {
            System.out.println("[Biography Textarea] is disabled");
        } else {
            System.out.println("[Biography Textarea] is enabled");
        }

        //Step 03.4 - Kiểm tra các phần tử sau disable trên trang: Job Role 03
        if (driver.findElement(By.xpath(job_role3_drb_xp)).isDisplayed()) {
            System.out.println("[Job Role 03 - Disable Dropdown] is disabled");
        } else {
            System.out.println("[Job Role 03 - Disable Dropdown] is enabled");
        }

        //Step 03.5 - Kiểm tra các phần tử sau disable trên trang: Interests (Checkbox is disabled)
        if (driver.findElement(By.xpath(interests_check_disable_cbx_xp)).isDisplayed()) {
            System.out.println("[Interests - Checkbox is disable] is disabled");
        } else {
            System.out.println("'[Interests - Checkbox is disable] is enabled");
        }

        //Step 03.6 - Kiểm tra các phần tử sau disable trên trang: Slider 02 (Disabled)
        if (driver.findElement(By.xpath(slider2_txt_xp)).isDisplayed()) {
            System.out.println("[Slider 02 Slider] is disabled");
        } else {
            System.out.println("[Slider 02 Slider] is enabled");
        }

    }

    @Test
    public void Part_II_WebElement_TC_03_Selected() {
        String age_under_18_rtn_xp = "//input[@id='over_18']";
        String language_java_cbx_xp = "//input[@id='java']";

        //Step 01 - Truy cập vào trang: https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //Step 02.1 - Click chọn: Age (Under 18) radio button
        driver.findElement(By.xpath(age_under_18_rtn_xp)).click();

        //Step 02.2 - Click chọn: "Languagues: Java" checkbox
        driver.findElement(By.xpath(language_java_cbx_xp)).click();

        sleepInSeconds(2);

        //Step 03 - Kiểm tra các phần tử tại Step 02 đã được chọn
        Assert.assertTrue(driver.findElement(By.xpath(age_under_18_rtn_xp)).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath(language_java_cbx_xp)).isSelected());

        //Step 04 - Click để bỏ chọn "Languagues: Java" checkbox
        driver.findElement(By.xpath(language_java_cbx_xp)).click();

        //Step 05 - Kiểm tra các phần tử "Languagues: Java" đã được bỏ chọn
        Assert.assertFalse(driver.findElement(By.xpath(language_java_cbx_xp)).isSelected());
    }

    @Test
    public void Part_II_WebElement_TC_04_MailChimp() {
        String email_txt_xp = "//input[@id='email']";
        String username_txt_xp = "//input[@id='new_username']";
        String password_txt_xp = "//input[@id='new_password']";
        String register_btn_xp = "//button[@id='create-account-enabled']";

        //Success Password  Mgs locator
        String success_mgs_pw_valid_one_lowercase_char_span_css = "li.lowercase-char.completed";
        String success_mgs_pw_valid_one_uppercase_char_span_css = "li.uppercase-char.completed";
        String success_mgs_pw_valid_one_number_char_span_css = "li.number-char.completed";
        String success_mgs_pw_valid_one_special_char_span_css = "li.special-char.completed";
        String success_mgs_pw_valid_8_char_minimum_span_css = "li[class='8-char completed']";
        String success_mgs_pw_valid_contain_username_span_css = "li.username-check.completed";

        //Success Password  Mgs locator
        String error_mgs_pw_missing_one_lowercase_char_span_css = "li.lowercase-char.not-completed";
        String error_mgs_pw_missing_one_uppercase_char_span_css = "li.uppercase-char.not-completed";
        String error_mgs_pw_missing_one_number_char_span_css = "li.number-char.not-completed";
        String error_mgs_pw_missing_one_special_char_span_css = "li.special-char.not-completed";
        String error_mgs_pw_minimum_8_char_span_css = "li[class='8-char not-completed']";
        String error_mgs_pw_contain_username_span_css = "li.username-check.not-completed";

        //Step 01 - Truy cập vào trang: https://login.mailchimp.com/signup/
        driver.get("https://login.mailchimp.com/signup/");

        //Step 02 - Nhập dữ liệu hợp lệ vào trường: Email (trường Username tự động lấy dữ liệu từ Email truyền qua)
        driver.findElement(By.xpath(email_txt_xp)).sendKeys("automationfc@gmail.com");

        //Step 03 - Nhập dữ liệu với các tiêu chí khác nhau để kiểm tra cách validate của trường Password
        WebElement ePassword = driver.findElement(By.xpath(password_txt_xp));

        // Case 1 - Number
        ePassword.click();
        ePassword.clear();
        ePassword.sendKeys("123456");
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_number_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_contain_username_span_css)).isDisplayed());

        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_lowercase_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_uppercase_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_special_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_minimum_8_char_span_css)).isDisplayed());
        System.out.println("Verify Password is Pass: Case 1 - Number");

        // Case 2 - LowerCase
        ePassword.clear();
        ePassword.sendKeys("auto");
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_lowercase_char_span_css)).isDisplayed());

        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_number_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_uppercase_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_special_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_minimum_8_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_contain_username_span_css)).isDisplayed());
        System.out.println("Verify Password is Pass: Case 2 - LowerCase");

        // Case 3 - UpperCase
        ePassword.clear();
        ePassword.sendKeys("AUTO");
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_uppercase_char_span_css)).isDisplayed());

        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_number_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_lowercase_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_special_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_minimum_8_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_contain_username_span_css)).isDisplayed());
        System.out.println("Verify Password is Pass: Case 3 - UpperCase");

        // Case 4 - Special Chars
        ePassword.clear();
        ePassword.sendKeys("!@#$");
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_special_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_contain_username_span_css)).isDisplayed());

        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_lowercase_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_uppercase_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_missing_one_number_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_minimum_8_char_span_css)).isDisplayed());
        System.out.println("Verify Password is Pass: Case 4 - Special Chars");

        // Case 5 - Max Length
        ePassword.clear();
        ePassword.sendKeys("Ab@123");
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_lowercase_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_uppercase_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_special_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_number_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_contain_username_span_css)).isDisplayed());

        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_minimum_8_char_span_css)).isDisplayed());
        System.out.println("Verify Password is Pass: Case 5 - Max Length");

        // Case 6 - Empty
        ePassword.clear();

        WebElement signUpButton = driver.findElement(By.xpath(register_btn_xp));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUpButton);
        sleepInSeconds(2);
        signUpButton.click();
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_lowercase_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_uppercase_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_lowercase_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_special_char_span_css)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(success_mgs_pw_valid_contain_username_span_css)).isDisplayed());

        Assert.assertTrue(driver.findElement(By.cssSelector(error_mgs_pw_minimum_8_char_span_css)).isDisplayed());
        System.out.println("Verify Password is Pass: Case 6 - Empty");

        // Case 7 - Valid
        ePassword.click();
        ePassword.clear();
        ePassword.sendKeys("Qa@123456");
        sleepInSeconds(2);

        Assert.assertFalse(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_lowercase_char_span_css)).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_uppercase_char_span_css)).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_lowercase_char_span_css)).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector(success_mgs_pw_valid_one_special_char_span_css)).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector(success_mgs_pw_valid_8_char_minimum_span_css)).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector(success_mgs_pw_valid_contain_username_span_css)).isDisplayed());
        System.out.println("Verify Password is Pass: Case 7 - Valid");
    }

    /*************************LOGIN PAGE*********************************/

    @Test
    public void Part_III_TC_01_Login_With_Empty_Email_And_Password(){
        // Step 01 - Truy cập vào trang: http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        // Step 02 - Click vào link "My Account" để tới trang đăng nhập
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(2);

        // Step 03 - Để trống Username/ Password
        driver.findElement(By.xpath("//input[@id='email']")).clear();

        driver.findElement(By.xpath("//input[@id='pass']")).clear();

        // Step 04 - Click Login button
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(2);

        // Step 05 - Verify error message xuất hiện tại 2 field:  This is a required field.
        Assert.assertEquals(
                driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText()
                , "This is a required field."
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText()
                , "This is a required field."
        );

    }


    @Test
    public void Part_III_TC_02_Login_With_Invalid_Email(){
        // Step 01 - Truy cập vào trang: http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        // Step 02 - Click vào link "My Account" để tới trang đăng nhập
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(2);

        // Step 03 - Nhập email invalid: 123434234@12312.123123/ password valid: 123456
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");

        driver.findElement(By.xpath("//input[@id='pass']")).clear();
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");

        // Step 04 - Click Login button
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(2);

        // Step 05 - Verify error message xuất hiện: Please enter a valid email address. For example johndoe@domain.com.
        Assert.assertEquals(
                driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText()
                , "Please enter a valid email address. For example johndoe@domain.com."
        );

    }


    @Test
    public void Part_III_TC_03_Login_With_Password_Less_than_6_Charactor(){
        // Step 01 - Truy cập vào trang: http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        // Step 02 - Click vào link "My Account" để tới trang đăng nhập
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(2);

        // Step 03 - Nhập email correct and password invalid: automation@gmail.com/ 123
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");

        driver.findElement(By.xpath("//input[@id='pass']")).clear();
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");

        // Step 04 - Click Login button
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(2);

        // Step 05 - Verify error message xuất hiện: Please enter 6 or more characters without leading or trailing spaces.

        Assert.assertEquals(
                driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText()
                , "Please enter 6 or more characters without leading or trailing spaces."
        );
    }


    @Test
    public void Part_III_TC_04_Login_With_Incorrect_Email_And_Password(){
        // Step 01 - Truy cập vào trang: http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        // Step 02 - Click vào link "My Account" để tới trang đăng nhập
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(2);

        // Step 03 - Nhập email correct and password incorrect: automation@gmail.com/ 123123123
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");

        driver.findElement(By.xpath("//input[@id='pass']")).clear();
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");

        // Step 04 - Click Login button
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(2);

        // Step 05 - Verify error message xuất hiện: Invalid login or password.
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");

    }

    /**************************************************************/

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
