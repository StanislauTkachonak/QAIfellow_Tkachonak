package steps;

import api.apiSteps.MortyApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.qameta.allure.Step;
import org.apache.http.HttpStatus;

public class MortySteps {
    private static final MortyApi mortyApi = new MortyApi();

    public String getInfoMorty(Integer id) {
        String morty = mortyApi.getMortyInfo(id)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .asString();
        return morty;
    }

    public String getEpisode() {
        String episode = mortyApi.getEpisode()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .asString();
        return episode;
    }

    public String getCharacterByUrl(String url) {
        String characterUrl = mortyApi.getCharacterByUrl(url)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .asString();
        return characterUrl;
    }

    @Step("Получаем последний эпизод, где появлялся Морти")
    public String getLastMortyEpisode() {
        String mortyResponse = getInfoMorty(2);
        JsonObject mortyObject = JsonParser.parseString(mortyResponse).getAsJsonObject();
        JsonArray episodes = mortyObject.getAsJsonArray("episode");
        String lastEpisode = episodes.get(episodes.size() - 1).getAsString();
        return lastEpisode;
    }

    @Step("Находим данные последнего персонажа в последнем эпизоде")
    public JsonObject getLastCharacter() {
        String response = getEpisode();
        JsonObject responseObject = JsonParser.parseString(response).getAsJsonObject();
        JsonArray episodes = responseObject.getAsJsonArray("results");
        JsonObject lastEpisode = episodes.get(episodes.size() - 1).getAsJsonObject();
        JsonArray characters = lastEpisode.getAsJsonArray("characters");
        String lastCharacterUrl = characters.get(characters.size() - 1).getAsString();
        String characterResponse = getCharacterByUrl(lastCharacterUrl);
        JsonObject characterObject = JsonParser.parseString(characterResponse).getAsJsonObject();
        return characterObject;
    }

    @Step("Получаем данные последнего персонажа из последнего эпизода")
    public String getLastCharacterName() {
        JsonObject characterObject = getLastCharacter();
        String characterName = characterObject.get("name").getAsString();
        return characterName;
    }

    @Step("Получаем местоположение последнего персонажа из последнего эпизода")
    public String getLastCharacterLocation() {
        JsonObject characterObject = getLastCharacter();
        String characterLocation = characterObject.getAsJsonObject("location").get("name").getAsString();
        return characterLocation;
    }

    @Step("Получаем расу последнего персонажа из последнего эпизода")
    public String getLastCharacterSpecies() {
        JsonObject characterObject = getLastCharacter();
        String characterSpecies = characterObject.get("species").getAsString();
        return characterSpecies;
    }

    @Step("Получаем информацию о местонахождении Морти")
    public String getMortyLocation() {
        String mortyResponse = getInfoMorty(2);
        JsonObject mortyObject = JsonParser.parseString(mortyResponse).getAsJsonObject();
        String mortyLocation = mortyObject.getAsJsonObject("location").get("name").getAsString();
        return mortyLocation;
    }

    @Step("Получаем информацию о расе Морти")
    public String getMortySpecies() {
        String mortyResponse = getInfoMorty(2);
        JsonObject mortyObject = JsonParser.parseString(mortyResponse).getAsJsonObject();
        String mortySpecies = mortyObject.get("species").getAsString();
        return mortySpecies;
    }
}
