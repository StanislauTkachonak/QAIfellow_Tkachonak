package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraBagStep {
    public final static SelenideElement createTask2 = $x("//a[@title=\"Создать новую задачу ( Нажмите 'c' )\"]");
    public final static SelenideElement changeTask2 = $x("//input[@id=\"issuetype-field\"]");
    public final static SelenideElement topic1 = $x("//div//input[@name=\"summary\"]");
    public final static SelenideElement addDescription = $x("//textarea[@name=\"description\"]");
    public final static SelenideElement clickOnVersion1 = $x("//optgroup[@label='Невыпущенные версии']//option[contains(text(),'Version 2.0')]");
    public final static SelenideElement clickOnTags = $x("//div[@class=\"jira-multi-select long-field\"]");
    public final static SelenideElement confirmCreateTask2 = $x("//input[@name = 'Edit']");
    public final static SelenideElement reportedByMe = $x("//a[@title=\"Сообщенные мной\"]");
    public final static SelenideElement clickOnTest = $x("(//div//*[@title=\"Ошибка - \"]//following::div//span[contains(text(),'TEST-')])[1]");
    public final static SelenideElement taskStatus = $x("(//div//strong[@title=\"Статус\"]//following::span//span)[1]");
    public final static SelenideElement businessProcess = $x("//span[text()='Бизнес-процесс']");
    public final static SelenideElement doComplited = $x("//span[text()='Выполнено']");
    public final static SelenideElement testSelenium = $x("//h1[text()='TestSeleniumATHomework']");

    @Когда("^Создание бага с указанием в поле тип: '(.*)'")
    public void createBag(String mistake) {
        createTask2.shouldBe(Condition.visible).click();
        changeTask2.shouldBe(Condition.visible).click();
        changeTask2.shouldBe(Condition.visible).sendKeys(mistake);
    }

    @И("^Ввод темы бага '(.*)'")
    public void enterTaskTopic(String enterTopic) {
        topic1.shouldBe(Condition.visible).click();
        topic1.shouldBe(Condition.visible).sendKeys(enterTopic);
    }

    @И("^Ввод описания бага '(.*)'")
    public void enterTaskDescription(String enterDescription) {
        addDescription.shouldBe(Condition.visible).click();
        addDescription.shouldBe(Condition.visible).sendKeys(enterDescription);
        clickOnVersion1.shouldBe(Condition.visible).click();
        clickOnTags.shouldBe(Condition.visible).click();
        confirmCreateTask2.shouldBe(Condition.visible).click();
    }

    @Тогда("Изменение статуса на Выполнено")
    public void changeStatus() {
        reportedByMe.shouldBe(Condition.visible).click();
        clickOnTest.shouldBe(Condition.visible).click();
        businessProcess.shouldBe(Condition.visible).click();
        doComplited.shouldBe(Condition.visible).click();
    }
}
