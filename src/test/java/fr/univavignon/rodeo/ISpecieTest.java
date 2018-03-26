package fr.univavignon.rodeo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ISpecieTest {

	@Mock
	private ISpecie specie;
	private static  List<IAnimal> listAnimaux;

	@Before
	public void init() {
		specie = mock(ISpecie.class);
		when(specie.getArea()).thenReturn(42);

//		IAnimal animal = mock(IAnimal.class);
//		IAnimal animal2 = mock(IAnimal.class);

		listAnimaux.add(IAnimalTest.getAnimal1());
		listAnimaux.add(IAnimalTest.getAnimal2());

		when(specie.getAnimals()).thenReturn(listAnimaux);
	}

	@Test
	public void testGetArea() {
		assertEquals(specie.getArea(),42);
	}

	@Test
	public void testGetAnimals() {

		assertEquals(specie.getAnimals(),listAnimaux);
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
}
