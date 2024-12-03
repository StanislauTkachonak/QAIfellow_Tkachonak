package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static com.codeborne.selenide.Selenide.$x;


public class EdujiraStartStep {

    public final static SelenideElement login = $x("//input[@name='os_username']");
    public final static SelenideElement password = $x("//input[@name='os_password']");
    public final static SelenideElement buttonEnter = $x("//input[@name=\"login\"]");
    public final static SelenideElement chekText = $x("//h1[text()='System Dashboard']");

    @Когда("^Ввод логина и пароля '(.*)', '(.*)'")
    public void setUserLogin(String userLogin, String userPassword) {
        login.shouldBe(Condition.visible).setValue(userLogin);
        password.shouldBe(Condition.visible).setValue(userPassword);
        buttonEnter.shouldBe(Condition.visible).click();
    }

    @Тогда("^Открывается главная страница сайта c заголовком '(.*)'")
    public void openMainPage(String expectedText) {
        chekText.shouldBe(Condition.visible)
                .shouldHave(Condition.text(expectedText));
    }
}

