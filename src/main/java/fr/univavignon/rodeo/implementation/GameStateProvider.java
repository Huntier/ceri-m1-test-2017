package fr.univavignon.rodeo.implementation;

import java.util.LinkedList;

import fr.univavignon.rodeo.api.*;

/**
 * Implementation of IGameStateProvider.
 * 
 * @author rg
 *
 */

public class GameStateProvider implements IGameStateProvider {

	private LinkedList<IGameState> states;

	public GameStateProvider() {
		this.states = new LinkedList<IGameState>();
	}

	public IGameState get(String name) throws IllegalArgumentException {
		if (name != null) {
			for (IGameState iGameState : this.states) {
				if (iGameState.getName().equals(name))
					return iGameState;
			}

			IGameState state = new GameState("state");
			this.states.add(state);
			return state;

		} else {
			throw new IllegalArgumentException();
		}

	}

	@Override
	public void save(IGameState gameState) {
		// TODO Auto-generated method stub

	}

}