package fr.univavignon.rodeo.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import fr.univavignon.rodeo.api.IGameStateProviderTest;
import org.junit.Before;
import org.junit.Test;

public class GameStateProviderTest extends IGameStateProviderTest {
    private GameStateProvider gameStateProvider;
    private GameState gameState,gameStateNull;

    @Before
    public void init() {
        gameStateProvider = new GameStateProvider();
        gameState = new GameState("unitTests");
        gameStateNull = new GameState(null);
    }

    @Test
    public void testSave() {
        assertNotNull(gameState);
        gameStateProvider.save(null);
    }

    @Test
    public void testSaveFileNotFoundException() {
        assertNotNull(gameState);
        gameStateProvider.save(gameState);
    }

    @Test
    public void testSaveEncodingException() {
        assertNotNull(gameState);
        gameStateProvider.save(gameState);
    }

    @Test
    public void testGet() {
        gameStateProvider.save(gameState);
        assertEquals(gameState, gameStateProvider.get("unitTests"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTestNull() {
        gameStateProvider.save(null);
        assertNull(gameStateProvider.get(null));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testGetIsNull() {
        gameStateProvider.get(null);
    }
}