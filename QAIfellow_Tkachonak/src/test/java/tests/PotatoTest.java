package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.PotatoSteps;

import java.io.IOException;

public class PotatoTest {

    @Test
    @DisplayName("Создание пользователя и проверка данных")
    public void checkUser() throws IOException {
        PotatoSteps potatoSteps = new PotatoSteps();
        String actualName = potatoSteps.createUserName();
        Assertions.assertEquals("Tomato", actualName, "Имя в ответе не совпадает");
        String actualJob = potatoSteps.createUserJob();
        Assertions.assertEquals("Eat maket", actualJob, "Работа в ответе не совпадает");
    }
}
