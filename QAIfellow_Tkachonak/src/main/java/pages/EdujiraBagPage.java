package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraBagPage {
    public final static SelenideElement createTask = $x("//a[@title=\"Создать новую задачу ( Нажмите 'c' )\"]").as("Кнопка создание задачи");
    public final static SelenideElement changeTask = $x("//input[@id=\"issuetype-field\"]").as("Кнопка изменения задачи");
    public final static SelenideElement topic1 = $x("//div//input[@name=\"summary\"]").as("Поле тема ошибки");
    public final static SelenideElement addDescription = $x("//textarea[@name=\"description\"]").as("Поле описание ошибки");
    public final static SelenideElement clickOnVersion = $x("//optgroup[@label='Невыпущенные версии']//option[contains(text(),'Version 2.0')]").as("Поле версия ошибки");
    public final static SelenideElement clickOnTags = $x("//div[@class=\"jira-multi-select long-field\"]").as("Поле тег ошибки");
    public final static SelenideElement confirmCreateTask = $x("//input[@name = 'Edit']").as("Кнопка подтверждения создания задачи");
    public final static SelenideElement reportedByMe = $x("//a[@title=\"Сообщенные мной\"]").as("Кнопка сообщенные мной");
    public final static SelenideElement clickOnTest = $x("(//div//*[@title=\"Ошибка - \"]//following::div//span[contains(text(),'TEST-')])[1]").as("Кнопка тест");
    public final static SelenideElement taskStatus = $x("//span[text() = 'Готово']").as("Поле статус ошибки");
    public final static SelenideElement businessProcess = $x("//span[text()='Бизнес-процесс']").as("Кнопка бизнесс-процесс");
    public final static SelenideElement doComplited = $x("//span[text()='Выполнено']").as("Кнопка выполнено");
    public final static SelenideElement testSelenium = $x("//h1[text()='TestSeleniumATHomework']").as("Поле тест селениум");
}
