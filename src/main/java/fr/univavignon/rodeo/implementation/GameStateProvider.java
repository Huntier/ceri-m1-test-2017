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

	GameStateProvider() {
		this.states = new LinkedList<>();
	}

	public IGameState get(String name) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException();
		} else {
			LinkedList<IGameState> states1 = this.states;
			for (int i = 0, states1Size = states1.size(); i < states1Size; i++) {
				IGameState iGameState = states1.get(i);
				if (iGameState.getName().equals(name))
					return iGameState;
			}
			IGameState state = new GameState("state");
			this.states.add(state);
			return state;
		}
	}

	@Override
	public void save(IGameState gameState) {
		// TODO Auto-generated method stub

	}

}