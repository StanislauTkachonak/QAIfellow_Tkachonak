package api.apiSteps;

import api.Specifications;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PotatoApi {

    public Response createNewUserFromFile() throws IOException {
        RestAssured.requestSpecification = Specifications.baseRequestSpec();
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
