package model;

import java.util.List;
import java.util.stream.Collectors;

public class AnimalsManager {
	private List<Animal> animalsList;

	public AnimalsManager(List<Animal> animalsList) {
		this.animalsList = animalsList;
	}
	
	public <T extends Animal> List<Animal> getListOf(Class<T> type){
		return this.animalsList.stream()
				.filter(type::isInstance)
				.collect(Collectors.toList());
	}
	
	public List<String> getAllSpecies(){
		return this.animalsList.stream()
				.map(Animal::getSpecies)
				.collect(Collectors.toList());
	}
	
	public Animal getOne(String species) {
		return this.animalsList.stream()
				.filter(i->i.getSpecies().equals(species))
				.findFirst()
				.orElseThrow(()-> new IllegalArgumentException("animal not found: " + species));
	}
	
	public void add(Animal animal) {
		this.animalsList.add(animal);
	}
	
	public double getReproductionRateOf(String name) { 
		return getOne(name).getReproductionRate();
	}
	
	public void setReproductionRateOf(String name, double newRate) { 
		getOne(name).setReproductionRate(newRate);
	}
	
	public double getMortalityRateOf(String name) {
		return getOne(name).getMortalityRate();
	}
	
	public void setMortalityRateOf(String name, double newRate) { 
		getOne(name).setMortalityRate(newRate);
	}
	
	public int getInitialPopulationOf(String name) {
		return getOne(name).getInitialPopulation();
	}
	
	public void setInitialPopulation(String name, int newInitialPopulation) {
		getOne(name).setInitialPopulation(newInitialPopulation);
	}
	
	public int getCurrentPopulationOf(String name) {
		return getOne(name).getCurrentPopulation();
	}
	
	public void setCurrentPopulation(String name, int newCurrentPopulation) {
		getOne(name).setCurrentPopulation(newCurrentPopulation);
	}
	
}
