package model;

public abstract class Animal {
	
	private final String species;
	private double reproductionRate;
	private int initialPopulation;
	
	
	public Animal(String species, double reproductionRate, int initialPopulation) {
		this.species = species;
		this.reproductionRate = reproductionRate;
		this.initialPopulation = initialPopulation;
	}
	
	abstract double populationDelta();


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


	public String getSpecies() {
		return species;
	}
	
	
	
}
