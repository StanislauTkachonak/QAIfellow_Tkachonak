package steps;

import api.steps.UserApi;
import io.cucumber.java.ru.Дано;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.logging.Logger;

import static utils.Configuration.getConfigurationValue;

public class UserSteps {
    private static final UserApi userApi = new UserApi();
    private static final Logger log = Logger.getLogger(UserSteps.class.getName());

    @Дано("Проверяем имя пользователя")
    public String createUserName() throws IOException {
        Response response = userApi.createNewUserFromFile(getConfigurationValue("user.url"));
        String actualName = response.jsonPath().getString("name");
        log.info("Имя нового пользователя: " + actualName);
        return actualName;
    }

    @Дано("Проверяем работу пользователя")
    public String createUserJob() throws IOException {
        Response response = userApi.createNewUserFromFile(getConfigurationValue("user.url"));
        String actualJob = response.jsonPath().getString("job");
        log.info("Работа нового пользователя: " + actualJob);
        return actualJob;
    }
}
