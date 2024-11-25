package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraBagPage {
    public final static SelenideElement createTask2 = $x("//a[@title=\"Создать новую задачу ( Нажмите 'c' )\"]");
    public final static SelenideElement changeTask2 = $x("//input[@id=\"issuetype-field\"]");
    public final static SelenideElement topic1 = $x("//div//input[@name=\"summary\"]");
    public final static SelenideElement addDescription = $x("//textarea[@name=\"description\"]");
    public final static SelenideElement clickOnVersion1 = $x("//optgroup[@label='Невыпущенные версии']//option[contains(text(),'Version 2.0')]");
    public final static SelenideElement clickOnTags = $x("//div[@class=\"jira-multi-select long-field\"]");
    public final static SelenideElement confirmCreateTask2 = $x("//div[@class=\"jira-multi-select long-field\"]");
    public final static SelenideElement reportedByMe = $x("//a[@title=\"Сообщенные мной\"]");
    public final static SelenideElement clickOnTest = $x("(//div//*[@title=\"Ошибка - \"]//following::div//span[contains(text(),'TEST-')])[1]");
    public final static SelenideElement taskStatus = $x("(//div//strong[@title=\"Статус\"]//following::span//span)[1]");
    public final static SelenideElement businessProcess = $x("//span[text()='Бизнес-процесс']");
    public final static SelenideElement doComplited = $x("//span[text()='Выполнено']");
    public final static SelenideElement testSelenium = $x("//h1[text()='TestSeleniumATHomework']");
}
