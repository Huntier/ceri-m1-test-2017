package fr.univavignon.rodeo.implementation;

import java.util.LinkedList;
import java.util.List;

import fr.univavignon.rodeo.api.*;

/**
 * Implementation of IEnvironmentProvider
 * 
 * @author rg
 *
 */

public class EnvironmentProvider implements IEnvironmentProvider {

	private LinkedList<IEnvironment> environments;

	public EnvironmentProvider(LinkedList<IEnvironment> environments) {
		this.environments = new LinkedList<IEnvironment>();
		this.environments = environments;
	}

	public List<String> getAvailableEnvironments() {
		List<String> availableEnvironments = new LinkedList<String>();

		for (IEnvironment environment : this.environments) {
			availableEnvironments.add(environment.getName());
		}
		return availableEnvironments;
	}

	public IEnvironment getEnvironment(String environmentName) throws IllegalArgumentException {
		IEnvironment result = null;
		try {
			for (IEnvironment environment : this.environments) {
				if (environment.getName().equals(environmentName)) {
					result = environment;
				}
			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return result;
	}
}