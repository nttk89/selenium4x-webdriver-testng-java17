//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package webdriver;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_WebElement_Commands_PII {
    WebDriver driver;

    public Topic_07_WebElement_Commands_PII() {
    }

    @BeforeClass
    public void beforeClass() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
    }

    @Test
    public void TC_01_Displayed() {
        this.driver.get("https://automationfc.github.io/basic-form/index.html");
        if (this.driver.findElement(By.cssSelector("input#mail")).isDisplayed()) {
            this.driver.findElement(By.cssSelector("input#mail")).sendKeys(new CharSequence[]{"Automation Testing"});
            System.out.println("Email Textbox is displayed");
        } else {
            System.out.println("Email Textbox is not displayed");
        }

        if (this.driver.findElement(By.cssSelector("input#under_18")).isDisplayed()) {
            this.driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("Under 18 Radio is displayed");
        } else {
            System.out.println("Under 18 Radio is not displayed");
        }

        if (this.driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()) {
            this.driver.findElement(By.cssSelector("textarea#edu")).sendKeys(new CharSequence[]{"Automation Testing"});
            System.out.println("Education TextArea is displayed");
        } else {
            System.out.println("Education TextArea is not displayed");
        }

        if (this.driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            System.out.println("Name User5 text is displayed");
        } else {
            System.out.println("Name User5 text is not displayed");
        }

    }

    @Test
    public void TC_02_Enabled() {
        this.driver.get("https://automationfc.github.io/basic-form/index.html");
        if (this.driver.findElement(By.cssSelector("input#mail")).isEnabled()) {
            System.out.println("Email Textbox is enabled");
        } else {
            System.out.println("Email Textbox is disabled");
        }

        if (this.driver.findElement(By.cssSelector("input#disable_password")).isEnabled()) {
            System.out.println("Password Textbox is enabled");
        } else {
            System.out.println("Password Textbox is disabled");
        }

        if (this.driver.findElement(By.cssSelector("input#check-disbaled")).isEnabled()) {
            System.out.println("Checkbox is enabled");
        } else {
            System.out.println("Checkbox is disabled");
        }

    }

    @Test
    public void TC_03_Selected() {
        this.driver.get("https://automationfc.github.io/basic-form/index.html");
        this.driver.findElement(By.cssSelector("input#under_18")).click();
        this.driver.findElement(By.cssSelector("input#java")).click();
        Assert.assertTrue(this.driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("input#java")).isSelected());
        this.driver.findElement(By.cssSelector("input#java")).click();
        this.sleepInSeconds(2L);
        Assert.assertTrue(this.driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertFalse(this.driver.findElement(By.cssSelector("input#java")).isSelected());
    }

    @Test
    public void TC_04_MailChimp() {
        this.driver.get("https://login.mailchimp.com/signup/");
        this.driver.findElement(By.cssSelector("input#email")).sendKeys(new CharSequence[]{"automationfc@gmail.com"});
        this.driver.findElement(By.cssSelector("input#new_password")).sendKeys(new CharSequence[]{"12345"});
        this.sleepInSeconds(2L);
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        this.driver.findElement(By.cssSelector("input#new_password")).clear();
        this.driver.findElement(By.cssSelector("input#new_password")).sendKeys(new CharSequence[]{"auto"});
        this.sleepInSeconds(2L);
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        this.driver.findElement(By.cssSelector("input#new_password")).clear();
        this.driver.findElement(By.cssSelector("input#new_password")).sendKeys(new CharSequence[]{"AUTO"});
        this.sleepInSeconds(2L);
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        this.driver.findElement(By.cssSelector("input#new_password")).clear();
        this.driver.findElement(By.cssSelector("input#new_password")).sendKeys(new CharSequence[]{"!@#$%"});
        this.sleepInSeconds(2L);
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        this.driver.findElement(By.cssSelector("input#new_password")).clear();
        this.driver.findElement(By.cssSelector("input#new_password")).sendKeys(new CharSequence[]{"12345678"});
        this.sleepInSeconds(2L);
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        this.driver.findElement(By.cssSelector("input#new_password")).clear();
        this.driver.findElement(By.cssSelector("input#new_password")).sendKeys(new CharSequence[]{"Auto123!@#"});
        this.sleepInSeconds(2L);
        Assert.assertFalse(this.driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(this.driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(this.driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(this.driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(this.driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        this.driver.findElement(By.cssSelector("input#new_password")).clear();
        WebElement signUpButton = this.driver.findElement(By.cssSelector("button#create-account-enabled"));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView(true);", new Object[]{signUpButton});
        this.sleepInSeconds(2L);
        signUpButton.click();
        this.sleepInSeconds(2L);
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000L);
        } catch (InterruptedException var4) {
            throw new RuntimeException(var4);
        }
    }
}
