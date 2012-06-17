package org.dyndns.warenix.hkunits.units.mass;

/**
 * 磅
 * 
 * @author warenix
 * 
 */
public class Pounds extends Mass implements Kilogramable {

	public Pounds(double value) {
		super(value);
	}

	@Override
	public Kilogram toKilogram() {
		return new Kilogram(mValue * getUnitKilogram());
	}

	public Kilogramable fromKilogram(Kilogram kg) {
		return new Pounds(kg.getValue() / getUnitKilogram());
	}

	@Override
	public String getUnit() {
		return "鎊";
	}

	@Override
	public double getUnitKilogram() {
		return 0.4536;
	}

}
