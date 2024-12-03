package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Дано;

import static com.codeborne.selenide.Selenide.$x;


public class EdujiraProjectStep {
    public final static SelenideElement projects = $x("//a[@title=\"Просмотр недавних проектов или списка всех проектов\"]");
    public final static SelenideElement test = $x("(//a[@class='aui-icon-container']//img)[1]");
    public final static SelenideElement countTasks = $x("//span[contains(text(),'1 из')]");
    public final static SelenideElement createTask = $x("//a[@title=\"Создать новую задачу ( Нажмите 'c' )\"]");
    public final static SelenideElement topic = $x("//div//input[@name=\"summary\"]");
    public final static SelenideElement clickOnVersion = $x("(//optgroup[@label='Невыпущенные версии']//option[contains(text(),'Version 2.0')])[1]");
    public final static SelenideElement confirmCreateTask = $x("//input[@name=\"Edit\"]");

    @Дано("^Вход в раздел проекты, проверка количества задач, путем создания новой с темой - '(.*)'")
    public void clickOnProjects(String enterTopic) {
        projects.shouldBe(Condition.visible).click();
        test.shouldBe(Condition.visible).click();
        int count = Integer.parseInt(countTasks.shouldBe(Condition.visible).getText().substring(4).trim());
        createTask.shouldBe(Condition.visible).click();
        topic.shouldBe(Condition.visible).click();
        topic.shouldBe(Condition.visible).sendKeys(enterTopic);
        clickOnVersion.shouldBe(Condition.visible).scrollIntoView(true).click();
        confirmCreateTask.shouldBe(Condition.visible).scrollIntoView(true).click();
        int newCount = Integer.parseInt(countTasks.shouldBe(Condition.visible).getText().substring(4).trim());
        if (newCount == count) {
            for (int i = 0; i < 50; i++) {
                Selenide.refresh();
                newCount = Integer.parseInt(countTasks.shouldBe(Condition.visible).getText().substring(4).trim());
                if (newCount == count + 1) {
                    break;
                }
            }
        }
    }
}
