package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class EdujiraTestSeleniumATHomeworkPage {
    public final static SelenideElement search = $x("//input[@title=\"Поиск ( Нажмите '/' )\"]");
    public final static SelenideElement searchTestSeleniumATHomework = $x("//a//span[text()='TestSeleniumATHomework']");
    public final static SelenideElement statusTestSeleniumATHomework = $x("//span[text()='Сделать']");
    public final static SelenideElement versionTestSeleniumATHomework = $x("//a[text() = 'Version 2.0']");
}
