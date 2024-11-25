package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import pages.EdujiraStartPage;

import static org.junit.Assert.assertTrue;

public class EdujiraStartStep extends EdujiraStartPage {

    @Step("Авторизация в Edujira")
    public void authorization(String userLogin, String userPassword) {
        login.shouldBe(Condition.visible).setValue(userLogin);
        password.shouldBe(Condition.visible).setValue(userPassword);
        buttonEnter.shouldBe(Condition.visible).click();
        String currentUrl = WebDriverRunner.url();
        assertTrue("URL не содержит ожидаемый фрагмент.", currentUrl.contains("https://edujira.ifellow.ru/secure/Dashboard.jspa"));
    }
}
