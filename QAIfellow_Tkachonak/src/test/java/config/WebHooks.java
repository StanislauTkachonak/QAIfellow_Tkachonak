package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class WebHooks {

    @BeforeAll
    public static void allureSubThreadParallel() {
        String listenerName = "AllureSelenide";

        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    new AllureSelenide().
                            screenshots(true).
                            savePageSource(false));
    }

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
        Selenide.closeWebDriver();
    }
}
