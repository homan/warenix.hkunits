package org.dyndns.warenix.hkunits.units.mass;

/**
 * 克
 * 
 * @author warenix
 * 
 */
public class Ounce extends Mass implements Kilogramable {

	public Ounce(double value) {
		super(value);
	}

	@Override
	public String getUnit() {
		return "安士";
	}

	@Override
	public Kilogram toKilogram() {
		return new Kilogram(mValue * getUnitKilogram());
	}

	@Override
	public Kilogramable fromKilogram(Kilogram kg) {
		return new Ounce(kg.getValue() / getUnitKilogram());
	}

	@Override
	public double getUnitKilogram() {
		return 0.0283495231;
	}

}
