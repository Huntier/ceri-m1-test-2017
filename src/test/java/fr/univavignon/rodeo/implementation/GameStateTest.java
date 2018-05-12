package fr.univavignon.rodeo.implementation;

import static org.junit.Assert.assertEquals;

import fr.univavignon.rodeo.api.*;
import org.junit.Before;
import org.junit.Test;

public class GameStateTest extends IGameStateTest {

    private GameState gameState;
    private IAnimal animal;

    @Before
    public void init() {
        gameState = new GameState("TestGameState");
        animal = new Animal("Buff the Magic Dragon", 30, false, true, false);

    }

    @Test (expected=IllegalStateException.class)
    public void testExploreAreaException() {
        gameState.exploreArea();
    }

    @Test
    public void testCatchAnimal() {
    }

    @Test (expected=IllegalArgumentException.class)
    public void testCatchAnimalNull() {
        gameState.catchAnimal(null);
    }

    @Test (expected=IllegalArgumentException.class)
    public void testCatchAnimalNotExist() {
        gameState.catchAnimal(new Animal("animal qui n'existe pas", 1, false, false, false));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testGetSpecieLevel() {
        assertEquals(SpecieLevel.NOVICE, gameState.getSpecieLevel(specie));
        gameState.catchAnimal(animal);
        assertEquals(SpecieLevel.WRANGLER, gameState.getSpecieLevel(specie));
        for (int i=0; i < 4; i++)
            gameState.catchAnimal(animal);
        assertEquals(SpecieLevel.CHAMPION, gameState.getSpecieLevel(specie));
        for (int i=0; i < 15; i++)
            gameState.catchAnimal(animal);
        assertEquals(SpecieLevel.MASTER, gameState.getSpecieLevel(specie));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testGetSpecieLevelNull() {
        gameState.getSpecieLevel(null);
    }

    @Test (expected=IllegalArgumentException.class)
    public void testGetSpecieNoviceLevel() {
        assertEquals(SpecieLevel.NOVICE, gameState.getSpecieLevel(specie));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testGetSpecieWranglerLevel() {
        gameState.catchAnimal(animal);
        assertEquals(SpecieLevel.WRANGLER, gameState.getSpecieLevel(specie));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testGetSpecieChampionLevel() {
        for (int i=0; i < 5; i++)
            gameState.catchAnimal(animal);
        assertEquals(SpecieLevel.CHAMPION, gameState.getSpecieLevel(specie));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testGetSpecieMasterLevel() {
        for (int i=0; i < 20; i++)
            gameState.catchAnimal(animal);
        assertEquals(SpecieLevel.MASTER, gameState.getSpecieLevel(specie));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testGetProgression() {
        assertEquals(1, gameState.getProgression());
        gameState.catchAnimal(animal);
        assertEquals(5, gameState.getProgression());
    }
}