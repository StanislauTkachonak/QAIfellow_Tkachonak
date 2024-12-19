package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.UserSteps;

import java.io.IOException;

public class UserTest {

    @Test
    @DisplayName("Создание пользователя и проверка данных")
    public void checkUser() throws IOException {
        UserSteps userSteps = new UserSteps();
        String actualName = userSteps.createUserName();
        Assertions.assertEquals("Tomato", actualName, "Имя в ответе не совпадает");
        String actualJob = userSteps.createUserJob();
        Assertions.assertEquals("Eat maket", actualJob, "Работа в ответе не совпадает");
    }
}
