package fr.univavignon.rodeo.implementation;

import fr.univavignon.rodeo.api.*;

/**
 * Implementation of IAnimal.
 * 
 * @author rg
 */

public class Animal extends NamedObject implements IAnimal{

	private boolean boss, endangered ,secret;
	private int xp;
	
	public Animal(String name, int xp,boolean boss, boolean endangered, boolean secret) {
		super(name);
		this.xp = xp;
		this.boss = boss;
		this.endangered = endangered;
		this.secret = secret;
	}
	

	public int getXP() {
		return this.xp;
	}

	public boolean isSecret() {
		return this.secret;
	}

	public boolean isEndangered() {
		return this.endangered;
	}

	public boolean isBoss() {
		return this.boss;
	}

}