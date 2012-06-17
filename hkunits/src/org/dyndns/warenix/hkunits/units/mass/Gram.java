package org.dyndns.warenix.hkunits.units.mass;

/**
 * 克
 * 
 * @author warenix
 * 
 */
public class Gram extends Mass implements Kilogramable {

	public Gram(double value) {
		super(value);
	}

	@Override
	public String getUnit() {
		return "克";
	}

	@Override
	public Kilogram toKilogram() {
		return new Kilogram(mValue * getUnitKilogram());
	}

	@Override
	public Kilogramable fromKilogram(Kilogram kg) {
		return new Gram(kg.getValue() / getUnitKilogram());
	}

	@Override
	public double getUnitKilogram() {
		return 1 / 1000.0;
	}

}
