package api.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class MortyApi {

    @Step("Получение информации по сериалу Рик и Морти")
    public ValidatableResponse getInfo(String url) {
        return given()
                .when()
                .get(url)
                .then();
    }

    public String getInfoMorty(String url) {
        return getInfo(url)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .asString();
    }
}
