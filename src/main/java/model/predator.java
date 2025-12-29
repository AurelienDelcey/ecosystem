package model;

public class predator extends Animal{
	
	private double predationRate;
	

	public predator(String species, double reproductionRate, double mortalityRate, double predationRate, int initialPopulation) {
		super(species, reproductionRate, mortalityRate, initialPopulation);
		this.predationRate = predationRate;
		
	}

	@Override
	public double populationDelta(int aviablePrey) {
		return super.getCurrentPopulation()
				*(super.getReproductionRate()-super.getMortalityRate())
				*starvingImpact(aviablePrey);
	}
	
	private double starvingImpact(int aviablePrey) {
		if (super.getCurrentPopulation() <= 0 || this.predationRate <= 0) {
			return 0.0;
		}
		return Math.min(aviablePrey/(super.getCurrentPopulation()* this.predationRate),1.0);
	}
}
