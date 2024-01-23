//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package webdriver;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Topic_05_Run_More_Browser {
    WebDriver driver;
    String osName = System.getProperty("os.name");

    public Topic_05_Run_More_Browser() {
    }

    @Test
    public void TC01_Run_On_Firefox_With_WebDriverManager() {
        this.driver = new FirefoxDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
        this.driver.manage().window().maximize();
        this.driver.get("https://www.facebook.com/");
        this.driver.quit();
    }

    @Test
    public void TC02_Run_On_Chrome_With_WebDriverManager() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
        this.driver.manage().window().maximize();
        this.driver.get("https://www.facebook.com/");
        this.driver.close();
    }

    @Test
    public void TC_03_Run_On_Edge_With_WebDriverManager() {
        this.driver = new EdgeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
        this.driver.manage().window().maximize();
        this.driver.get("https://www.facebook.com/");
        this.driver.quit();
    }

    @Test
    public void TC_04_Run_On_Safari_With_WebDriverManager() {
        if (this.osName.contains("Mac")) {
            this.driver = new SafariDriver();
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
            this.driver.manage().window().maximize();
            this.driver.get("https://www.facebook.com/");
            this.driver.quit();
        }

    }
}
