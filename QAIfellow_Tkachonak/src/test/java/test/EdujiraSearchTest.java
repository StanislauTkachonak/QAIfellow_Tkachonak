package test;

import config.WebHooks;
import org.junit.jupiter.api.Test;
import steps.EdujiraBagStep;
import steps.EdujiraProjectStep;
import steps.EdujiraStartStep;
import steps.EdujiraTestSeleniumATHomeworkStep;

import static config.Configuration.getConfigurationValue;

public class EdujiraSearchTest extends WebHooks {

    EdujiraStartStep edujiraStartStep = new EdujiraStartStep();
    EdujiraProjectStep edujiraProjectStep = new EdujiraProjectStep();
    EdujiraTestSeleniumATHomeworkStep edujiraTestSeleniumATHomeworkStep = new EdujiraTestSeleniumATHomeworkStep();
    EdujiraBagStep edujiraBagStep = new EdujiraBagStep();

    @Test
    public void authorizationTest(){
        edujiraStartStep.authorization(getConfigurationValue("login"), getConfigurationValue("password"));
    }

    @Test
    public void clickOnProjectsTest(){
        edujiraStartStep.authorization(getConfigurationValue("login"), getConfigurationValue("password"));
        edujiraProjectStep.clickOnProjects();
    }

    @Test
    public void searchTaskTest(){
        edujiraStartStep.authorization(getConfigurationValue("login"), getConfigurationValue("password"));
        int count = edujiraProjectStep.clickOnProjects();
        edujiraProjectStep.searchTask("HW3", count);
    }

    @Test
    public void clickOnTestSeleniumTest(){
        edujiraStartStep.authorization(getConfigurationValue("login"), getConfigurationValue("password"));
        int count = edujiraProjectStep.clickOnProjects();
        edujiraProjectStep.searchTask("HW3", count);
        edujiraTestSeleniumATHomeworkStep.clickOnTestSelenium("TestSeleniumATHomework");
    }

    @Test
    public void checkAllTasksTest() {
        edujiraStartStep.authorization(getConfigurationValue("login"), getConfigurationValue("password"));
        int count = edujiraProjectStep.clickOnProjects();
        edujiraProjectStep.searchTask("HW3", count);
        edujiraTestSeleniumATHomeworkStep.clickOnTestSelenium("TestSeleniumATHomework");
        edujiraBagStep.createBag("HW3",
                "Некорректное отображение текста на странице при использовании масштабирования");
        edujiraBagStep.changeStatus();
    }
}
