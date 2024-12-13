package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.MortySteps;

public class MortyTest {

    private static final MortySteps mortySteps = new MortySteps();

    @Test
    @DisplayName("Находим последний эпизод, где появлялся Морти")
    public void getLastEpisodeMorty() {
        String lastEpisode = mortySteps.getLastMortyEpisode();
        Assertions.assertEquals("https://rickandmortyapi.com/api/episode/51", lastEpisode, "Эпизод не совпадает");
    }

    @Test
    @DisplayName("Находим данные последнего персонажа в последнем эпизоде ")
    public void getLastCharacter() {
        String characterName = mortySteps.getLastCharacterName();
        Assertions.assertEquals("Taddy Mason", characterName, "Имя не совпадает");
    }

    @Test
    @DisplayName("Находим местоположение и расу последнего персонажа")
    public void checkLocationAndSpecies() {
        String characterLocation = mortySteps.getLastCharacterLocation();
        String characterSpecies = mortySteps.getLastCharacterSpecies();
        Assertions.assertEquals("Earth (Replacement Dimension)", characterLocation, "Местонахождение не совпадает");
        Assertions.assertEquals("Human", characterSpecies, "Раса не совпадает");
    }

    @Test
    @DisplayName("Cравниваем данные Морти и последнего персонажа")
    public void compareInfo() {
        String characterLocation = mortySteps.getLastCharacterLocation();
        String characterSpecies = mortySteps.getLastCharacterSpecies();
        String mortyLocation = mortySteps.getMortyLocation();
        String mortySpecies = mortySteps.getMortySpecies();
        Assertions.assertNotEquals(characterLocation, mortyLocation, "Местонахождение Морти и последнего персонажа совпадают");
        Assertions.assertEquals(characterSpecies, mortySpecies, "Раса Морти и последнего персонажа не совпадают");
    }
}



