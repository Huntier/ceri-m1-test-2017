package fr.univavignon.rodeo.implementation;

import java.util.*;

import fr.univavignon.rodeo.api.*;

/**
 * Implementation of IEnvironmentProvider
 *
 * @author rg
 *
 */

public class EnvironmentProvider implements IEnvironmentProvider {


	private Map<String, Boolean> availableEnvironments;

    EnvironmentProvider() {
        availableEnvironments = new HashMap<>();
        int count = 0;
        for (Iterator<IEnvironment> iterator = environments.iterator(); iterator.hasNext(); ) {
            IEnvironment env = iterator.next();
            boolean available = false;
            if (count++ == 0)
                available = true;
            availableEnvironments.put(env.getName(), available);
        }
    }
    private List<IEnvironment> environments = Arrays.asList(
            new Environment("Savannah", 1, Arrays.asList(
                    new Specie("Buffalo", 1, Arrays.asList(
                            new Animal("Forest Buffalo", 1, false, false, false), 		//normal
                            new Animal("Diabuffalo", 3, true, false, false), 			//secret
                            new Animal("Buff the Magic Dragon", 30, false, true, false) //endangered
                    )),
                    new Specie("Zebras", 1, Arrays.asList(
                            new Animal("Zebra", 0, false, false, false),				//normal
                            new Animal("Trojan Zebra", 25, true, false, false),			//secret
                            new Animal("Zegasus", 30, false, true, false)				//endangered
                    )),
                    new Specie("Elephants", 1, Arrays.asList(
                            new Animal("African Elephant", 0, false, false, false), 	//normal
                            new Animal("Skelephant", 30, false, false, true) 			//boss
                    )),
                    new Specie("Ostriches", 2, Arrays.asList(
                            new Animal("Ostrich", 0, false, false, false),				//normal
                            new Animal("Bosstrich", 30, false, false, true)				//boss
                    )),
                    new Specie("Giraffes", 3, Arrays.asList(
                            new Animal("Giraffe", 0, false, false, false),				//normal
                            new Animal("Giraffemas Tree", 30, false, false, true)					//boss
                    )),
                    new Specie("Vultures", 4, Arrays.asList(
                            new Animal("Viva Las Vulture", 1, false, false, false), 	//normal
                            new Animal("Vulture-on", 5, true, false, false), 			//secret
                            new Animal("Volture", 30, false, true, false) 				//endangered
                    )),
                    new Specie("Lions", 5, Arrays.asList(
                            new Animal("Sabretooth Lion", 1, false, false, false), 			//normal
                            new Animal("Le'Ion Chef", 5, true, false, false), 			//secret
                            new Animal("Nian Monster ", 30, false, true, false) 		//endangered
                    ))
            )),
            new Environment("Jungle", 2, Arrays.asList( //pour tester
                    new Specie("Boar", 1, Arrays.asList(
                            new Animal("Boar1", 1, false, false, false), 		//normal
                            new Animal("Boar2", 3, true, false, false), 		//secret
                            new Animal("Boar3", 30, false, true, false) 		//endangered
                    ))
            ))
    );

    @Override
	public List<String> getAvailableEnvironments() {
		Vector<String> result = new Vector<>();
        availableEnvironments.forEach((key, value) -> {
            if (value)
                result.add(key);
        });

		return result;
	}

    @Override
    public IEnvironment getEnvironment(String name) throws IllegalArgumentException {
        assert name != null : "getEnvironment(String name) -> null argument";

        return environments.stream().filter(oEnv -> oEnv.getName().equals(name)).findFirst().orElse(null);
    }

	//todo : rajouter pour les test imp
	public List<IEnvironment> getEnvironments() {
		return this.environments;
	}

    public void unlockNextEnvironment() {
        for (Iterator<Map.Entry<String, Boolean>> iterator = availableEnvironments.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Boolean> entry = iterator.next();
            if (!entry.getValue()) {
                entry.setValue(true);
                break;
            }
        }
    }

    public boolean stillAreaToExplore() {
        return this.getAvailableEnvironments().size() != environments.size();
    }
}