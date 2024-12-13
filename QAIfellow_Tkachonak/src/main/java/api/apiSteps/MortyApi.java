package api.apiSteps;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class MortyApi {

    public ValidatableResponse getInfo(String url) {
        return given()
                .when()
                .get(url)
                .then();
    }
}
