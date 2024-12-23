package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.EdujiraProjectPage;


public class EdujiraProjectStep extends EdujiraProjectPage {

    @Step("Клик на раздел Проекты, проверка количества задач")
    public int clickOnProjects() {
        projects.shouldBe(Condition.visible).click();
        test.shouldBe(Condition.visible).click();
        Assertions.assertTrue(countTasks.exists(), "Текст не найден на странице!");
        return Integer.parseInt(countTasks.shouldBe(Condition.visible).getText().substring(4).trim());
    }

    @Step("Поиск задачи")
    public void searchTask(String enterTopic, int count) {
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
        Assertions.assertEquals(count + 1, newCount, "Количество задач не соответствует ожидаемому");
    }
}
