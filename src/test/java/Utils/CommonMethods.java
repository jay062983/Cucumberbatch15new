package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class CommonMethods {
    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication() {
ConfigReader.readProperties();

       String broweserType = ConfigReader.getPropertyValue("browserType");
        switch (broweserType) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;


        }
            driver.manage().window().maximize();

            driver.get(ConfigReader.getPropertyValue("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));

        }
        public static void closeBrowser(){
        driver.close();
        }
    }
