package model;

public class herbivore extends Animal{

	public herbivore(String species, double reproductionRate, double mortalityRate, int initialPopulation) {
		super(species, reproductionRate, mortalityRate, initialPopulation);
	}

	@Override
	public double populationDelta(int predatorPopulation) {
	    double delta = super.getCurrentPopulation() * (super.getReproductionRate() - super.getMortalityRate());
	    double predatorFactor = 1.0;
	    if (predatorPopulation > 0) {
	        predatorFactor = Math.min(1.0, (double) predatorPopulation / 
	        		(predatorPopulation + super.getCurrentPopulation()));
	    }

	    return delta * (1 - predatorFactor);
	}
}
