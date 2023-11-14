package JustForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro1 {
    public static void main(String[] args) {
        //webDriver manager is a class that has a
        // different browser
        //FOR EVERY SELENIUM PROJECT THAT
        //EXECUTES TEST ON CHROME BROWSER
        //SHOULD SETUP CHROMEDRIVER AT LEAST 1 TIME
        WebDriverManager.chromedriver().setup();

        // WebDriver is a Selenium interface
        //that represents all browser drivers.
        //implementations are
        //ChromeDriver();
        //SafariDriver();
        //IEDriver();
        //FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        //get method is a method  that directs
        // your browser to a specfic webpage.
        driver.get("https://www.google.com/");

        driver.quit();

    }
}
