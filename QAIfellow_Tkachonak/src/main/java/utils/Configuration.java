package utils;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream("test.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("test.properties файл не найден в пути к классам");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Не удается прочитать test.properties файл", e);
        }
    }

    public static String getConfigurationValue(String key) {
        return (System.getProperty(key) == null) ? properties.getProperty(key) : System.getProperty(key);
    }

    @BeforeAll
    public static void allureSubThreadParallel() {
        String listenerName = "AllureSelenide";

        if (!SelenideLogger.hasListener(listenerName))
            SelenideLogger.addListener(listenerName,
                    new AllureSelenide()
                            .screenshots(true)
                            .savePageSource(false));
    }
}
