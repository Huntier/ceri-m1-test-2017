package fr.univavignon.rodeo.implementation;

import fr.univavignon.rodeo.api.*;

/**
 * Implementation of IGameState.
 * 
 * @author rg
 *
 */

public class GameState extends NamedObject implements IGameState {

	private SpecieLevel level;
	private int progression;

	public GameState(String name) {
		super(name);
		this.level = null;
		this.progression = 1;
	}

	public void exploreArea() throws IllegalStateException {
		throw new IllegalStateException();
	}

	public void catchAnimal(IAnimal animal) throws IllegalArgumentException, IllegalStateException {
		try {
			throw new IllegalArgumentException();
		} catch (IllegalStateException e) {
			throw new IllegalStateException();
		}

	}

	public SpecieLevel getSpecieLevel(ISpecie specie) throws IllegalArgumentException {
		if (specie != null) {
			return this.level;
		}
		throw new IllegalArgumentException();

	}

	public int getProgression() {
		return this.progression;
	}

}