package steps;

import api.apiSteps.MortyApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.qameta.allure.Step;
import org.apache.http.HttpStatus;

import java.util.logging.Logger;

import static config.Props.props;

public class MortySteps {
    private static final MortyApi mortyApi = new MortyApi();
    private static final Logger log = Logger.getLogger(MortySteps.class.getName());

    public String getInfoMorty(String url) {
        String value = mortyApi.getInfo(url)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .asString();
        return value;
    }

    @Step("Получаем последний эпизод, где появлялся Морти")
    public String getLastMortyEpisode() {
        String mortyResponse = getInfoMorty(props.mortyCharacterUrl() + "character/2");
        JsonObject mortyObject = JsonParser.parseString(mortyResponse).getAsJsonObject();
        JsonArray episodes = mortyObject.getAsJsonArray("episode");
        String lastEpisode = episodes.get(episodes.size() - 1).getAsString();
        log.info("Последний эпизод, где появлялся Морти: " + lastEpisode);
        return lastEpisode;
    }

    @Step("Находим данные последнего персонажа в последнем эпизоде")
    public JsonObject getLastCharacter() {
        String response = getInfoMorty(props.mortyCharacterUrl() + "episode");
        JsonObject responseObject = JsonParser.parseString(response).getAsJsonObject();
        JsonArray episodes = responseObject.getAsJsonArray("results");
        JsonObject lastEpisode = episodes.get(episodes.size() - 1).getAsJsonObject();
        JsonArray characters = lastEpisode.getAsJsonArray("characters");
        String lastCharacterUrl = characters.get(characters.size() - 1).getAsString();
        String characterResponse = getInfoMorty(lastCharacterUrl);
        JsonObject characterObject = JsonParser.parseString(characterResponse).getAsJsonObject();
        return characterObject;
    }

    @Step("Получаем данные последнего персонажа из последнего эпизода")
    public String getLastCharacterName() {
        JsonObject characterObject = getLastCharacter();
        String characterName = characterObject.get("name").getAsString();
        log.info("Последний персонаж в последнем эпизоде:" + characterName);
        return characterName;
    }

    @Step("Получаем местоположение последнего персонажа из последнего эпизода")
    public String getLastCharacterLocation() {
        JsonObject characterObject = getLastCharacter();
        String characterLocation = characterObject.getAsJsonObject("location").get("name").getAsString();
        log.info("Местоположение: " + characterLocation);
        return characterLocation;
    }

    @Step("Получаем расу последнего персонажа из последнего эпизода")
    public String getLastCharacterSpecies() {
        JsonObject characterObject = getLastCharacter();
        String characterSpecies = characterObject.get("species").getAsString();
        log.info("Раса: " + characterSpecies);
        return characterSpecies;
    }

    @Step("Получаем информацию о местонахождении Морти")
    public String getMortyLocation() {
        String mortyResponse = getInfoMorty(props.mortyCharacterUrl() + "character/2");
        JsonObject mortyObject = JsonParser.parseString(mortyResponse).getAsJsonObject();
        String mortyLocation = mortyObject.getAsJsonObject("location").get("name").getAsString();
        log.info("Местоположение: " + mortyLocation);
        return mortyLocation;
    }

    @Step("Получаем информацию о расе Морти")
    public String getMortySpecies() {
        String mortyResponse = getInfoMorty(props.mortyCharacterUrl() + "character/2");
        JsonObject mortyObject = JsonParser.parseString(mortyResponse).getAsJsonObject();
        String mortySpecies = mortyObject.get("species").getAsString();
        log.info("Раса: " + mortySpecies);
        return mortySpecies;
    }
}
