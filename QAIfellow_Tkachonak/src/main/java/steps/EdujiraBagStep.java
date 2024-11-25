package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.EdujiraBagPage;

public class EdujiraBagStep extends EdujiraBagPage {
    @Step("Создание бага")
    public void createBag(String enterTopic, String enterDescription) {
        createTask2.shouldBe(Condition.visible).click();
        changeTask2.shouldBe(Condition.visible).click();
        changeTask2.shouldBe(Condition.visible).sendKeys("Ошибка");
        topic1.shouldBe(Condition.visible).click();
        topic1.shouldBe(Condition.visible).sendKeys(enterTopic);
        addDescription.shouldBe(Condition.visible).click();
        addDescription.shouldBe(Condition.visible).sendKeys(enterDescription);
        clickOnVersion1.shouldBe(Condition.visible).click();
        clickOnTags.shouldBe(Condition.visible).click();
        confirmCreateTask2.shouldBe(Condition.visible).click();
        Assertions.assertTrue(testSelenium.exists(), "Текст не найден на странице!");
    }

    @Step("Изменение статуса с 'В работе' на 'готово' ")
    public void changeStatus() {
        reportedByMe.shouldBe(Condition.visible).click();
        clickOnTest.shouldBe(Condition.visible).click();
        String status = taskStatus.shouldBe(Condition.visible).getText();
        Assertions.assertEquals("В работе", status, "Фактический статус не соответствует статусу 'В работе'");
        businessProcess.shouldBe(Condition.visible).click();
        doComplited.shouldBe(Condition.visible).click();
    }
}
