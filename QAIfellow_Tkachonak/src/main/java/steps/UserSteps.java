package steps;

import apiSteps.UserApi;
import io.cucumber.java.ru.Дано;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.logging.Logger;

public class UserSteps {
    private static final UserApi UserApi = new UserApi();
    private static final Logger log = Logger.getLogger(UserSteps.class.getName());

    @Дано("Проверка имени пользователя")
    public String createUserName() throws IOException {
        Response response = UserApi.createNewUserFromFile();
        String actualName = response.jsonPath().getString("name");
        log.info("Имя нового пользователя: " + actualName);
        return actualName;
    }

    @Дано("Проверка работы пользователя")
    public String createUserJob() throws IOException {
        Response response = UserApi.createNewUserFromFile();
        String actualJob = response.jsonPath().getString("job");
        log.info("Работа нового пользователя: " + actualJob);
        return actualJob;
    }
}
