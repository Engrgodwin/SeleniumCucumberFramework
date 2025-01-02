package com.saucedemo.utils;

public class DriverFactoryBrowserOptions {
    private static WebDriver driver;
//
//    // Singleton pattern for WebDriver instance
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            String browser = ConfigReader.getProperty("browser"); // Read browser from config
//            switch (browser.toLowerCase()) {
//                case "chrome":
//                   // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    break;
//                case "firefox":
//                    //System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    break;
//                default:
//                    throw new RuntimeException("Unsupported browser: " + browser);
//            }
//
//            // Configure the WebDriver
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            driver.manage().window().maximize();
//        }
//        return driver;
//    }
//
//    // Quit driver
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }








}
