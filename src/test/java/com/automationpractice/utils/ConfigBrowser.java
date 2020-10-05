package com.automationpractice.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.concurrent.TimeUnit;


public class ConfigBrowser implements DriverSource {
    private static final long SELENIUM_IMPLICIT_WAIT_MILLI = 2000;
    private PropertyReader baseConfiguration = new PropertyReader();
    private Proxy seleniumProxy;

    @Override
    public WebDriver newDriver() {
        WebBrowsers browserType = WebBrowsers.valueOf(baseConfiguration.getProperty("browser"));

        WebDriver driver = null;

        switch (browserType) {
            case IE:
                WebDriverManager.iedriver().setup();
                break;
            case PHANTOMJS:
                WebDriverManager.phantomjs().setup();
                driver = new PhantomJSDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case CHROME_HEADLESS:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeHeadlessOptions = new ChromeOptions();
                chromeHeadlessOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeHeadlessOptions);
                break;

            case FIREFOX_HEADLESS:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options.addArguments("--headless"));
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                break;
        }

        driver.manage().timeouts().implicitlyWait(SELENIUM_IMPLICIT_WAIT_MILLI, TimeUnit.MILLISECONDS);
        return driver;
    }


    @Override
    public boolean takesScreenshots() {
        return true;
    }

    public enum WebBrowsers {
        IE, CHROME, CHROME_HEADLESS, FIREFOX, FIREFOX_HEADLESS, PHANTOMJS
    }

}
