package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.EdujiraBagPage;

import java.time.Duration;

public class EdujiraBagStep extends EdujiraBagPage {
    @Step("Создание бага")
    public void createBag(String enterTopic, String enterDescription) {
        createTask.shouldBe(Condition.visible).click();
        changeTask.shouldBe(Condition.visible).click();
        changeTask.shouldBe(Condition.visible).sendKeys("Ошибка");
        topic1.shouldBe(Condition.visible).click();
        topic1.shouldBe(Condition.visible).sendKeys(enterTopic);
        addDescription.shouldBe(Condition.visible).click();
        addDescription.shouldBe(Condition.visible).sendKeys(enterDescription);
        clickOnVersion.shouldBe(Condition.visible).click();
        clickOnTags.shouldBe(Condition.visible).click();
        confirmCreateTask.shouldBe(Condition.visible).click();
        Assertions.assertTrue(testSelenium.exists(), "Текст не найден на странице!");
    }

    @Step("Изменение статуса с 'В работе' на 'Готово' ")
    public void changeStatus() {
        reportedByMe.shouldBe(Condition.visible).click();
        clickOnTest.shouldBe(Condition.visible).click();
        businessProcess.shouldBe(Condition.visible).click();
        doComplited.shouldBe(Condition.visible).click();
        taskStatus.shouldBe(Condition.visible, Duration.ofSeconds(60));
        Assertions.assertTrue(taskStatus.exists());
    }
}
