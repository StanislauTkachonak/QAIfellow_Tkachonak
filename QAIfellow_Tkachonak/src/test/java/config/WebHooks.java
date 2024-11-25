package config;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class WebHooks {

    @BeforeEach
    public void initBrowser() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/test.properties");
        properties.load(fis);
        String chromeDriverPath129 = properties.getProperty("chrome.driver.version.129");
        String chromeDriverPath131 = properties.getProperty("chrome.driver.version.131");
        String chromeVersion = properties.getProperty("webdriverVersion");
        if ("129".equals(chromeVersion)) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath129);
        } else if ("131".equals(chromeVersion)) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath131);
        } else {
            throw new IllegalArgumentException("Unsupported Chrome version: " + chromeVersion);
        }
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open("https://edujira.ifellow.ru/");
    }

    @AfterEach
    public void closeDriver() {
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}
