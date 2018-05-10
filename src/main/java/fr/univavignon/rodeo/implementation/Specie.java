package fr.univavignon.rodeo.implementation;

import java.util.LinkedList;
import java.util.List;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;

/**
 * Implementation of ISpecie.
 * 
 * @author rg
 *
 */

public class Specie extends NamedObject implements ISpecie {

	private List<IAnimal> animals;
	private int area;

	public Specie(String name, int area, List<IAnimal> animals) {
		super(name);
		this.animals = new LinkedList<IAnimal>();
		this.area = area;
		animals.addAll(animals);
	}

	public int getArea() {
		return this.area;
	}

	public List<IAnimal> getAnimals() {
		return this.animals;
	}

}