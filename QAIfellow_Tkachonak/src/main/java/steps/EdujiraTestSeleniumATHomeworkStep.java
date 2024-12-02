package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Дано;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraTestSeleniumATHomeworkStep {
    public final static SelenideElement search = $x("//input[@title=\"Поиск ( Нажмите '/' )\"]");
    public final static SelenideElement searchTestSeleniumATHomework = $x("//a//span[text()='TestSeleniumATHomework']");
    public final static SelenideElement statusTestSeleniumATHomework = $x("//span[text()='Сделать']");
    public final static SelenideElement versionTestSeleniumATHomework = $x("//a[text() = 'Version 2.0']");

    @Дано("^Клик на задачу '(.*)'")
    public void clickOnTestSelenium(String text) {
        search.shouldBe(Condition.visible).setValue(text);
        search.sendKeys(Keys.ENTER);
        searchTestSeleniumATHomework.shouldBe(Condition.visible).click();
    }

    @Дано("^Проверка статуса: '(.*)'")
    public void chekStatus(String status) {
        statusTestSeleniumATHomework.shouldBe(Condition.visible)
                .shouldHave(Condition.text(status));
    }

    @Дано("^Проверка версии: '(.*)'")
    public void checkVersion(String version) {
        versionTestSeleniumATHomework.shouldBe(Condition.visible).
                shouldHave(Condition.text(version));
    }
}
