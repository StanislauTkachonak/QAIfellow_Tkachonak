package test;

import config.WebHooks;
import org.junit.jupiter.api.Test;
import steps.*;

public class EdujiraSearchTest extends WebHooks {

    @Test
    public void authorizationTest(){
        new EdujiraStartStep().authorization("AT3", "Qwerty123");
    }

    @Test
    public void clickOnProjectsTest(){
        new EdujiraStartStep().authorization("AT3", "Qwerty123");
        new EdujiraProjectStep().clickOnProjects();
    }
    
    @Test
    public void searchTaskTest(){
        new EdujiraStartStep().authorization("AT3", "Qwerty123");
        int count = new EdujiraProjectStep().clickOnProjects();
        new EdujiraProjectStep().searchTask("HW3", count);
    }

    @Test
    public void clickOnTestSeleniumTest(){
        new EdujiraStartStep().authorization("AT3", "Qwerty123");
        int count = new EdujiraProjectStep().clickOnProjects();
        new EdujiraProjectStep().searchTask("HW3", count);
        new EdujiraTestSeleniumATHomeworkStep().clickOnTestSelenium("TestSeleniumATHomework");
    }

    @Test
    public void checkAllTasksTest() {
        new EdujiraStartStep().authorization("AT3", "Qwerty123");
        int count = new EdujiraProjectStep().clickOnProjects();
        new EdujiraProjectStep().searchTask("HW3", count);
        new EdujiraTestSeleniumATHomeworkStep().clickOnTestSelenium("TestSeleniumATHomework");
        new EdujiraBagStep().createBag("HW3",
                "Некорректное отображение текста на странице при использовании масштабирования");
    }
}
