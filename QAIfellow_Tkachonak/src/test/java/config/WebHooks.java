package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class WebHooks {
    @Before
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

    @After()
    public void after() {
        Selenide.closeWebDriver();
    }
}