package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraProjectPage {
    public final static SelenideElement projects = $x("//a[@title=\"Просмотр недавних проектов или списка всех проектов\"]");
    public final static SelenideElement test = $x("(//a[@class='aui-icon-container']//img)[1]");
    public final static SelenideElement countTasks = $x("//span[contains(text(),'1 из')]");
    public final static SelenideElement createTask = $x("//a[@title=\"Создать новую задачу ( Нажмите 'c' )\"]");
    public final static SelenideElement topic = $x("//div//input[@name=\"summary\"]");
    public final static SelenideElement clickOnVersion = $x("(//optgroup[@label='Невыпущенные версии']//option[contains(text(),'Version 2.0')])[1]");
    public final static SelenideElement confirmCreateTask = $x("//input[@name=\"Edit\"]");
}
