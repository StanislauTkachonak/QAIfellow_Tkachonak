package steps;

import api.apiSteps.PotatoApi;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.logging.Logger;

public class PotatoSteps {
    private static final PotatoApi potatoApi = new PotatoApi();
    private static final Logger log = Logger.getLogger(PotatoSteps.class.getName());

    public String createUserName() throws IOException {
        Response response = potatoApi.createNewUserFromFile();
        String actualName = response.jsonPath().getString("name");
        log.info("Имя нового пользователя: " + actualName);
        return actualName;
    }

    public String createUserJob() throws IOException {
        Response response = potatoApi.createNewUserFromFile();
        String actualJob = response.jsonPath().getString("job");
        log.info("Работа нового пользователя: " + actualJob);
        return actualJob;
    }
}
