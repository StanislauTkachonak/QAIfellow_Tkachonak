package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.EdujiraTestSeleniumATHomeworkPage;

public class EdujiraTestSeleniumATHomeworkStep extends EdujiraTestSeleniumATHomeworkPage {

    @Step("Клик на задачу TestSelenium")
    public void clickOnTestSelenium(String text) {
        search.shouldBe(Condition.visible).setValue(text);
        search.sendKeys(Keys.ENTER);
        searchTestSeleniumATHomework.shouldBe(Condition.visible).click();
        String status = statusTestSeleniumATHomework.shouldBe(Condition.visible).getText();
        Assertions.assertEquals("СДЕЛАТЬ",status,"Фактический статус не соответствует статусу 'Сделать'");
        String version = versionTestSeleniumATHomework.shouldBe(Condition.visible).getText();
        Assertions.assertEquals("Version 2.0",version,"Фактическая версия не соответствует версии 'Version 2.0'");
    }
}
