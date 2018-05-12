package fr.univavignon.rodeo.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import fr.univavignon.rodeo.api.IAnimal;

public class IAnimalTest {

	@Mock
	private IAnimal animal;

	@Before
	public void init() {
		animal = mock(IAnimal.class);
		when(animal.getXP()).thenReturn(42);
		when(animal.isSecret()).thenReturn(true, false);
		when(animal.isEndangered()).thenReturn(true, false);
		when(animal.isBoss()).thenReturn(true, false);
	}


	@Test
	public void testGetXp() {
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
}
