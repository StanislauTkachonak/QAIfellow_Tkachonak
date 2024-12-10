package api.apiSteps;

import io.restassured.response.ValidatableResponse;

import static constants.Constants.MORTYCHARACTER_URL;
import static io.restassured.RestAssured.given;

public class MortyApi {

    public ValidatableResponse getMortyInfo(Integer id) {
        return given()
                .when()
                .get(MORTYCHARACTER_URL + "character/" + id)
                .then();
    }

    public ValidatableResponse getEpisode() {
        return given()
                .when()
                .get(MORTYCHARACTER_URL + "episode")
                .then();
    }

    public ValidatableResponse getCharacterByUrl(String url) {
        return given()
                .when()
                .get(url)
                .then();
    }
}
