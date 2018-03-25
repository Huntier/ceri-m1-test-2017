package fr.univavignon.rodeo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

public class IGameStateTest {

	@Mock
	private IGameState gameState;
	private IAnimal animal;
	private ISpecie specie;

	private int progression[] = {1,10,15,20,30,40,50,60,70,80,90,100};


	/* création de deux objets pour faire une table de vérité pour couvrir tout les cas possible*/
	@Before
	public void init() {
		gameState = mock(IGameState.class);

		when(gameState.getProgression()).thenReturn(progression[0],
				progression[1],progression[2],
				progression[3],progression[4],
				progression[5],progression[6],
				progression[7],progression[8],progression[9],
				progression[10],progression[11]);
		animal = mock(IAnimal.class);
		specie = mock(ISpecie.class);
//		when(gameState.getSpecieLevel(specie)).thenReturn();

//		// si l'objet animal est null
//		when(gameState.catchAnimal(null)).thenThrow(new IllegalArgumentException());
//		// If the given animal can not be found in current areas.
//		when(gameState.catchAnimal()).thenThrow(new IllegalStateException());
//		doNothing().when(gameState.catchAnimal(animal));

	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExploreArea() {
		fail("Not yet implemented");
	}

	@Test
	public void testCatchAnimal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpecieLevel() {

	}

	/*The total game progression in percent.*/
	@Test
	public void testGetProgression() {

		for (int aProgression : progression) {
			if (gameState.getProgression() != aProgression) {

				fail(" pas de bonne progression");
			}
		}


	}

}
