package api.apiSteps;

import api.Specifications;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import constants.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class PotatoApi {

    public Response createNewUserFromFile() throws FileNotFoundException {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(Constants.USER_URL);
        FileReader reader = new FileReader("src/test/resources/potato.json");
        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        jsonObject.addProperty("name", "Tomato");
        jsonObject.addProperty("job", "Eat maket");
        String jsonString = jsonObject.toString();
        return given()
                .body(jsonString)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .extract().response();
    }
}
