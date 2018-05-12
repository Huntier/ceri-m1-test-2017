package fr.univavignon.rodeo.implementation;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import fr.univavignon.rodeo.api.*;

/**
 * Implementation of IEnvironment.
 * 
 * @author rg
 *
 */

public class Environment extends NamedObject implements IEnvironment {

	private int areas;
	private List<ISpecie> species;

	Environment(String name, int areas, List<ISpecie> species) {
		super(name);
		this.species = species;
		this.areas = areas;
	}

	public int getAreas() {
		return this.areas;
	}

	public List<ISpecie> getSpecies() {
		return this.species;
	}

	@Override
	public boolean equals(Object o) {
		Environment object = (Environment) o;
		List<ISpecie> speciesObject = object.getSpecies();

		return name.equals(object.getName()) && areas == object.getAreas() && species.size() == speciesObject.size()
				&& IntStream.range(0, species.size()).allMatch(i -> (species.get(i)).equals(speciesObject.get(i)));

	}
}