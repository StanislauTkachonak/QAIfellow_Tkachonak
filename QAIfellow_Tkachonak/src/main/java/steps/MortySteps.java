package steps;

import api.steps.MortyApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.http.HttpStatus;

import java.util.logging.Logger;

import static utils.Configuration.getConfigurationValue;


public class MortySteps {
    private static final MortyApi mortyApi = new MortyApi();
    private static final Logger log = Logger.getLogger(MortySteps.class.getName());

    public String getInfoMorty(String url) {
        return mortyApi.getInfo(url)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .asString();
    }

    @Когда("Получаем последний эпизод, где появлялся Морти")
    public String getLastMortyEpisode() {

        String mortyResponse = getInfoMorty(getConfigurationValue("morty.character.url") + "character/2");
        JsonObject mortyObject = JsonParser.parseString(mortyResponse).getAsJsonObject();
        JsonArray episodes = mortyObject.getAsJsonArray("episode");
        String lastEpisode = episodes.get(episodes.size() - 1).getAsString();
        log.info("Последний эпизод, где появлялся Морти: " + lastEpisode);
        return lastEpisode;
    }

    @И("Находим данные последнего персонажа в последнем эпизоде")
    public JsonObject getLastCharacter() {
        String response = getInfoMorty(getConfigurationValue("morty.character.url") + "episode");
        JsonObject responseObject = JsonParser.parseString(response).getAsJsonObject();
        JsonArray episodes = responseObject.getAsJsonArray("results");
        JsonObject lastEpisode = episodes.get(episodes.size() - 1).getAsJsonObject();
        JsonArray characters = lastEpisode.getAsJsonArray("characters");
        String lastCharacterUrl = characters.get(characters.size() - 1).getAsString();
        String characterResponse = getInfoMorty(lastCharacterUrl);
        return JsonParser.parseString(characterResponse).getAsJsonObject();
    }

    @И("Получаем данные последнего персонажа из последнего эпизода")
    public String getLastCharacterName() {
        JsonObject characterObject = getLastCharacter();
        String characterName = characterObject.get("name").getAsString();
        log.info("Последний персонаж в последнем эпизоде:" + characterName);
        return characterName;
    }

    @И("Получаем местоположение последнего персонажа из последнего эпизода")
    public String getLastCharacterLocation() {
        JsonObject characterObject = getLastCharacter();
        String characterLocation = characterObject.getAsJsonObject("location").get("name").getAsString();
        log.info("Местоположение: " + characterLocation);
        return characterLocation;
    }

    @И("Получаем расу последнего персонажа из последнего эпизода")
    public String getLastCharacterSpecies() {
        JsonObject characterObject = getLastCharacter();
        String characterSpecies = characterObject.get("species").getAsString();
        log.info("Раса: " + characterSpecies);
        return characterSpecies;
    }

    @И("Получаем информацию о местонахождении Морти")
    public String getMortyLocation() {
        String mortyResponse = getInfoMorty(getConfigurationValue("morty.character.url") + "character/2");
        JsonObject mortyObject = JsonParser.parseString(mortyResponse).getAsJsonObject();
        String mortyLocation = mortyObject.getAsJsonObject("location").get("name").getAsString();
        log.info("Местоположение: " + mortyLocation);
        return mortyLocation;
    }

    @Тогда("Получаем информацию о расе Морти")
    public String getMortySpecies() {
        String mortyResponse = getInfoMorty(getConfigurationValue("morty.character.url") + "character/2");
        JsonObject mortyObject = JsonParser.parseString(mortyResponse).getAsJsonObject();
        String mortySpecies = mortyObject.get("species").getAsString();
        log.info("Раса: " + mortySpecies);
        return mortySpecies;
    }
}
