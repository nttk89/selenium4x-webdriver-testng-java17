package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Main {
    static String projectPath = System.getProperty("user.dir");
    static String osName = System.getProperty("os.name");

    public static void main(String... args) {
        // Press Ctrl+1 with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Alt+Shift+X or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Alt+Shift+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+Shift+B.
            System.out.println("i = " + i);
        }

        WebDriver driverChrome = openChromeDriver();
        driverChrome.get("https://www.google.com/");
        sleepInSecond(3);

        WebDriver driverFirefox = openFirefoxDriver();
        driverFirefox.get("https://www.google.com/");
        sleepInSecond(3);
    }

    public static WebDriver openChromeDriver(){
        return new ChromeDriver();
    }

    public static WebDriver openFirefoxDriver(){
        return new FirefoxDriver();
    }

    public static WebDriver openEdgeDriver(){
        return new EdgeDriver();
    }


    public static WebDriver openSafariDriver(){
        return new SafariDriver();
    }

    public static void sleepInSecond(long seconds){
        try{
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}