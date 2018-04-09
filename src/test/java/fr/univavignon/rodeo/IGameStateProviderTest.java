package fr.univavignon.rodeo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.univavignon.rodeo.api.IEnvironmentProvider;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;
import fr.univavignon.rodeo.api.ISpecie;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

public class IGameStateProviderTest {

	@Mock
	private IGameStateProvider gameStateProvider,gameStateProviderNull;
	private IGameState gameState;

	@Before
	public void init(){
		gameStateProvider = mock(IGameStateProvider.class);
		gameState = mock(IGameState.class);
		when(gameStateProvider.get("name")).thenReturn(gameState);

		gameStateProviderNull = mock(IGameStateProvider.class);
		when(gameStateProviderNull.get(null)).thenThrow(new IllegalArgumentException());
	}

	// je ne sais pas comment la tester
//	@Test
//	public void testSave() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGet() {
		assertEquals(gameStateProvider.get("name"), gameState);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getTestNull() {
		gameStateProviderNull.get(null);
	}

}
