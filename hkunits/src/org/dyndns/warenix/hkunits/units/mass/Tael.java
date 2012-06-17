package org.dyndns.warenix.hkunits.units.mass;

/**
 * 兩
 * 
 * @author warenix
 * 
 */
public class Tael extends Mass implements Kilogramable {

	public Tael(double value) {
		super(value);
	}

	@Override
	public Kilogram toKilogram() {
		return new Kilogram(mValue * getUnitKilogram());
	}

	@Override
	public Kilogramable fromKilogram(Kilogram kg) {
		return new Tael(kg.getValue() / getUnitKilogram());
	}

	@Override
	public String getUnit() {
		return "兩";
	}

	@Override
	public double getUnitKilogram() {
		return 0.0378;
	}
}
