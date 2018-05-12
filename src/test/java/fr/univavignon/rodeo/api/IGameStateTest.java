package fr.univavignon.rodeo.api;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class IGameStateTest {

	@Mock
	private IGameState gameState;
	private IAnimal animal;
	public ISpecie specie, specie2;

	private int progression[] = { 1, 10, 15, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

	/*
	 * création de deux objets pour faire une table de vérité pour couvrir tout les
	 * cas possible
	 */
	@Before
	public void init() {
		gameState = mock(IGameState.class);
		when(gameState.getProgression()).thenReturn(progression[0], progression[1], progression[2], progression[3],
				progression[4], progression[5], progression[6], progression[7], progression[8], progression[9],
				progression[10], progression[11]);

		when(gameState.getSpecieLevel(null)).thenThrow(new IllegalArgumentException());
		specie = mock(ISpecie.class);
		specie2 = mock(ISpecie.class);
		doThrow(IllegalArgumentException.class).when(gameState).getSpecieLevel(specie);

		// // si l'objet animal est null
		doThrow(IllegalArgumentException.class).when(gameState).catchAnimal(null);
		animal = mock(IAnimal.class);
		// si objet animal est pas nul mais que ?
		doThrow(IllegalStateException.class).when(gameState).catchAnimal(animal);

		// // If the given animal can not be found in current areas.
		// when(gameState.catchAnimal()).thenThrow(new IllegalStateException());
		// doNothing().when(gameState.catchAnimal(animal));

	}

	@Test(expected = IllegalStateException.class)
	public void testCatchAnimal() {

		gameState.catchAnimal(animal);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCatchAnimalNull() {
		gameState.catchAnimal(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetSpecieLevelNull() {
		gameState.getSpecieLevel(null);
	}
	// @Test
	// public void testGetSpecieLevel() {
	// gameState.getSpecieLevel(specie2);
	// }

	/* The total game progression in percent. */
	@Test
	public void testGetProgression() {
		for (int aProgression : progression) {
			assertEquals(gameState.getProgression(), aProgression);
		}
	}

}
