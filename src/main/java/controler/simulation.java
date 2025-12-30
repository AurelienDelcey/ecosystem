package controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.*;

public class simulation {
	
	private List<Animal> animalsList; //deviendra un DAO par la suite
	
	public simulation(List<Animal>animalsList) {
		this.animalsList = animalsList;
	}
	
	public void advanceOneStep() {
		Map<Animal, Integer> snapShot = new HashMap<>();
		animalsList.stream()
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
		return this.animalsList.stream()
				.filter(type::isInstance)
				.mapToInt(Animal::getCurrentPopulation)
				.sum();
	}
}
