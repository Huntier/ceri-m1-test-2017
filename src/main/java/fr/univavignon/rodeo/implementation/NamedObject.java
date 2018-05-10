package fr.univavignon.rodeo.implementation;

import fr.univavignon.rodeo.api.INamedObject;

/**
 * Implementation of INamedObject.
 * 
 * @author rg
 */

public class NamedObject implements INamedObject {

	private String name;

	public NamedObject(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}