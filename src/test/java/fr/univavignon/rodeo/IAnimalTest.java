package fr.univavignon.rodeo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.*;

import fr.univavignon.rodeo.api.IAnimal;

public class IAnimalTest {
	
	@Mock
	private IAnimal animal;
	private IAnimal animalFalse;


	/* création de deux objets pour faire une table de vérité pour couvrir tout les cas possible*/
	@Before
	public void init() {
		animal = mock(IAnimal.class);
		when(animal.getXP()).thenReturn(42);
		when(animal.isSecret()).thenReturn(true);
		when(animal.isEndangered()).thenReturn(true);
		when(animal.isBoss()).thenReturn(true);

		animalFalse = mock(IAnimal.class);
		when(animalFalse.isSecret()).thenReturn(false);
		when(animalFalse.isEndangered()).thenReturn(false);
		when(animalFalse.isBoss()).thenReturn(false);
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
	public void testGetXP() {
		assertEquals(42, animal.getXP());
	}

	@Test
	public void testIsSecret() {
		assertTrue(animal.isSecret());
		assertFalse(animalFalse.isSecret());
	}

	@Test
	public void testIsEndangered() {
		assertTrue(animal.isEndangered());
		assertFalse(animalFalse.isEndangered());
	}

	@Test
	public void testIsBoss() {
		assertTrue(animal.isBoss());
		assertFalse(animalFalse.isBoss());
	}

}
