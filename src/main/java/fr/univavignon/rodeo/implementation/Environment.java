package fr.univavignon.rodeo.implementation;

import java.util.LinkedList;
import java.util.List;

import fr.univavignon.rodeo.api.*;

/**
 * Implementation of IEnvironment.
 * @author rg
 *
 */

public class Environment extends NamedObject implements IEnvironment{

	private int areas;
	private List<ISpecie> species;

	public Environment(String name, int areas, List<ISpecie> species) {
		super(name);
		this.species = new LinkedList<ISpecie>();
		this.areas = areas;
		this.species.addAll(species);
	}

	public int getAreas() {
		return this.areas;
	}

	public List<ISpecie> getSpecies() {
		return this.species;
	}

}