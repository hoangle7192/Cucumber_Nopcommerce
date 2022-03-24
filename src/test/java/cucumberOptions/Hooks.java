package cucumberOptions;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import commons.GlobalConstants;
import commons.urlList;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.UnreachableBrowserException;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    // Run for many thread
    private static WebDriver driver;
    private static ChromeOptions options = new ChromeOptions();
    private static final Logger log = Logger.getLogger(Hooks.class.getName());

    @Before // synchronized = handle đồng bộ
    public synchronized static WebDriver openAndQuitBrowser() {
        // Run by Maven command line
        String browser = System.getProperty("BROWSER");
        System.out.println("Browser name run by command line = " + browser);

        // Check driver đã được khởi tạo hay chưa?
        if (driver == null) {

            // Happy path case
            try {
                // Kiem tra BROWSER = null -> gan = chrome/ firefox (browser default for project)
                if (browser == null) {
                    // Get browser name from Environment Variable in OS
                    browser = System.getenv("BROWSER");
                    if (browser == null) {
                        // Set default browser
                        browser = "chrome";
                    }
                }

                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        options.addExtensions(new File(GlobalConstants.U_BLOCK_EXTENSION_OF_CHROME));
                        driver = new ChromeDriver(options);
                        break;
                    case "hchrome":
                        WebDriverManager.chromedriver().setup();
                        options.addArguments("headless");
                        options.addArguments("window-size=1920x1080");
                        options.addExtensions(new File(GlobalConstants.U_BLOCK_EXTENSION_OF_CHROME));
                        driver = new ChromeDriver(options);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                        FirefoxOptions firefoxoptions = new FirefoxOptions();
                        FirefoxProfile profile = new FirefoxProfile();
                        profile.addExtension(new File(GlobalConstants.AD_BLOCK_EXTENSION_OF_FIREFOX));
                        driver = new FirefoxDriver(firefoxoptions);
                        break;
                    case "hfirefox":
                        WebDriverManager.firefoxdriver().setup();
                        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setHeadless(true);
                        driver = new FirefoxDriver(firefoxOptions);
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    default:
                        throw new IllegalArgumentException("This Browser Is Not Support");
                }
                // Browser crash/ stop
            } catch (UnreachableBrowserException e) {
                driver = new ChromeDriver();
                // Driver crash
            } catch (WebDriverException e) {
                driver = new ChromeDriver();
            }
            // Code này luôn luôn được chạy dù pass hay fail
            finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }

            driver.get(GlobalConstants.USER_URL);
            driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            log.info("------------- Started the browser -------------");
        }
        return driver;
    }

    public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
                log.info("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Can not close the browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

    public static int generateNumber() {
        Random random = new Random();
        return random.nextInt(999999);
    }

}