package fr.univavignon.rodeo.implementation;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.INamedObject;

import java.util.List;
import java.util.Objects;

/**
 * Implementation of INamedObject.
 * 
 * @author rg
 */

public class NamedObject implements INamedObject {

	protected String name;

	NamedObject(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}