package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraStartPage {
    public final static SelenideElement login = $x("//input[@name='os_username']").as("Поле логин");
    public final static SelenideElement password = $x("//input[@name='os_password']").as("Поле пароль");
    public final static SelenideElement buttonEnter = $x("//input[@name=\"login\"]").as("Кнопка ввод");
}
