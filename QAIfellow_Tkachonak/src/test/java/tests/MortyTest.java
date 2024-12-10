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
        System.out.println("Последний эпизод, где появлялся Морти: " + lastEpisode);
    }

    @Test
    @DisplayName("Находим данные последнего персонажа в последнем эпизоде ")
    public void getLastCharacter() {
        String characterName = mortySteps.getLastCharacterName();
        System.out.println("Последний персонаж в последнем эпизоде:");
        System.out.println("Имя: " + characterName);
        Assertions.assertEquals("Taddy Mason", characterName, "Имя не совпадает");
    }

    @Test
    @DisplayName("Находим местоположение и расу последнего персонажа")
    public void checkLocationAndSpecies() {
        String characterLocation = mortySteps.getLastCharacterLocation();
        System.out.println("Местоположение: " + characterLocation);
        String characterSpecies = mortySteps.getLastCharacterSpecies();
        System.out.println("Раса: " + characterSpecies);
        Assertions.assertEquals("Earth (Replacement Dimension)", characterLocation, "Местонахождение не совпадает");
    }

    @Test
    @DisplayName("Cравниваем данные Морти и последнего персонажа")
    public void compareInfo() {
        String characterLocation = mortySteps.getLastCharacterLocation();
        System.out.println("Местоположение: " + characterLocation);
        String characterSpecies = mortySteps.getLastCharacterSpecies();
        System.out.println("Раса: " + characterSpecies);
        String mortyLocation = mortySteps.getMortyLocation();
        System.out.println("Местоположение: " + mortyLocation);
        String mortySpecies = mortySteps.getMortySpecies();
        System.out.println("Раса: " + mortySpecies);
        Assertions.assertNotEquals(characterLocation, mortyLocation, "Местонахождение Морти и последнего персонажа совпадают");
        Assertions.assertEquals(characterSpecies, mortySpecies, "Раса Морти и последнего персонажа не совпадают");
    }
}



