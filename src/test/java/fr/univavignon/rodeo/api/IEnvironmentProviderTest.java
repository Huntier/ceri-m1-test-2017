package fr.univavignon.rodeo.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

public class IEnvironmentProviderTest {

	@Mock
	private IEnvironmentProvider environmentProvider, environmentProviderNull;
	private IEnvironment environment;
	private static List<String> listEnvironnementProvider = Arrays.asList("sands", "forest", "ice");

	@Before
	public void init() {
		environmentProvider = mock(IEnvironmentProvider.class);
		environmentProviderNull = mock(IEnvironmentProvider.class);
		when(environmentProviderNull.getEnvironment(null)).thenThrow(new IllegalArgumentException());

		environment = mock(IEnvironment.class);
		when(environment.getName()).thenReturn("sands");
		when(environmentProvider.getAvailableEnvironments()).thenReturn(listEnvironnementProvider);
		when(environmentProvider.getEnvironment("sands")).thenReturn(environment);
	}

	@Test
	public void testGetAvailableEnvironments() {
		assertEquals(environmentProvider.getAvailableEnvironments(), listEnvironnementProvider);
	}

	@Test
	public void testGetEnvironment() {
		assertEquals(environmentProvider.getEnvironment("sands"), environment);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetEnvironmentNull() {
		assertEquals(environmentProviderNull.getEnvironment(null), new IllegalArgumentException());
	}

}
