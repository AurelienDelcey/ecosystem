package model;

public abstract class Animal {
	
	private final String species;
	private double reproductionRate;
	private double mortalityRate;
	private int initialPopulation;
	private int currentPopulation;
	
	
	public Animal(String species, double reproductionRate, double mortalityRate, int initialPopulation) {
		this.species = species;
		this.mortalityRate = mortalityRate;
		this.reproductionRate = reproductionRate;
		this.initialPopulation = initialPopulation;
		this.currentPopulation = initialPopulation;
	}
	
	abstract double populationDelta(int modifyer);


	public double getReproductionRate() {
		return reproductionRate;
	}

	public void setReproductionRate(double reproductionRate) {
		this.reproductionRate = reproductionRate;
	}

	public int getInitialPopulation() {
		return initialPopulation;
	}

	public void setInitialPopulation(int initialPopulation) {
		this.initialPopulation = initialPopulation;
	}
	
	public int getCurrentPopulation() {
		return currentPopulation;
	}

	public void setCurrentPopulation(int currentPopulation) {
		this.currentPopulation = currentPopulation;
	}

	public String getSpecies() {
		return species;
	}

	public double getMortalityRate() {
		return mortalityRate;
	}

	public void setMortalityRate(double mortalityRate) {
		this.mortalityRate = mortalityRate;
	}	
	
	
}
