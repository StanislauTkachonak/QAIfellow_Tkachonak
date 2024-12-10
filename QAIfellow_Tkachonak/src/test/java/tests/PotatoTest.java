package tests;

import api.apiSteps.PotatoApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class PotatoTest {
    private static final PotatoApi potatoApi = new PotatoApi();

    @Test
    @DisplayName("Создание пользователя и проверка данных")
    public void createUser() throws FileNotFoundException {
        Response response = potatoApi.createNewUserFromFile();
        String actualName = response.jsonPath().getString("name");
        String actualJob = response.jsonPath().getString("job");
        Assertions.assertEquals("Tomato", actualName, "Имя в ответе не совпадает");
        Assertions.assertEquals("Eat maket", actualJob, "Работа в ответе не совпадает");
    }
}
