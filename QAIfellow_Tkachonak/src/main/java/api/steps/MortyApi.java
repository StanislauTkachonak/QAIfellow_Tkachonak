package api.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class MortyApi {

    @Step("Работа с документацией  по АPI по сериалу Рик и Морти")
    public ValidatableResponse getInfo(String url) {
        return given()
                .when()
                .get(url)
                .then();
    }
}
