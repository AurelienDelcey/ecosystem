package controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.*;

public class simulation {
	
	private AnimalsManager animalsList;
	
	public simulation(AnimalsManager animalsList) {
		this.animalsList = animalsList;
	}
	
	public void advanceOneStep() {
		Map<Animal, Integer> snapShot = new HashMap<>();
		animalsList.getListOf(Animal.class).stream()
		.forEach(i->{
			snapShot.put(i,(int)Math.round(i.getCurrentPopulation()+i.populationDelta(getPopulationInfluence(i))));	
		});
		applySimulationStep(snapShot);
	}
	
	public void applySimulationStep(Map<Animal, Integer>animals) {
		for(Animal i:animals.keySet()) {
			i.setCurrentPopulation(animals.get(i));
		}
	}
	
	private int getPopulationInfluence(Animal animal) {
		if(animal instanceof predator) {
			return getCountOf(herbivore.class);
		}
		if( animal instanceof herbivore) {
			return getCountOf(predator.class);
		}
		return 0;
	}
	
	private <T extends Animal> int getCountOf(Class<T> type){
		return animalsList.getTotalPopulationOf(type);
	}
}
