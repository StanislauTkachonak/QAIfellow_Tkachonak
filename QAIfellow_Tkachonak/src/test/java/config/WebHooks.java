package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static config.Configuration.getConfigurationValue;

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
    public void initBrowser() {
        String webDriverLocation = getConfigurationValue("webdriverlocation");
        System.setProperty("webdriver.chrome.driver", webDriverLocation);
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open(getConfigurationValue("url"));
    }

    @AfterEach
    public void closeDriver() {
        Selenide.closeWebDriver();
    }
}
