package fr.univavignon.rodeo.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

public class IEnvironmentTest {

	@Mock
	private IEnvironment environment;
	private List<ISpecie> listpecies = new ArrayList<>();

	@Before
	public void init() {
		environment = mock(IEnvironment.class);
		when(environment.getAreas()).thenReturn(3);

		ISpecie specie = mock(ISpecie.class);
		ISpecie specie2 = mock(ISpecie.class);
		ISpecie specie3 = mock(ISpecie.class);
		listpecies.add(specie);
		listpecies.add(specie2);
		listpecies.add(specie3);

		when(environment.getSpecies()).thenReturn(listpecies);
	}

	@Test
	public void testGetAreas() {
		assertEquals(environment.getAreas(), 3);
	}

	@Test
	public void testGetSpecies() {
		assertEquals(environment.getSpecies(), listpecies);
	}

}
