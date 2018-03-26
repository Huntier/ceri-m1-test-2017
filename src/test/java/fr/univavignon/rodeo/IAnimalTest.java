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

	@Before
	public void init() {
		animal = mock(IAnimal.class);
		when(animal.getXP()).thenReturn(42);
		when(animal.isSecret()).thenReturn(true,false);
		when(animal.isEndangered()).thenReturn(true,false);
		when(animal.isBoss()).thenReturn(true,false);
	}

	@Test
	public void testGetXP() {
		assertEquals(42, animal.getXP());
	}

	@Test
	public void testIsSecret() {
		assertTrue(animal.isSecret());
		assertFalse(animal.isSecret());
	}

	@Test
	public void testIsEndangered() {
		assertTrue(animal.isEndangered());
		assertFalse(animal.isEndangered());
	}

	@Test
	public void testIsBoss() {
		assertTrue(animal.isBoss());
		assertFalse(animal.isBoss());
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
