package org.dyndns.warenix.hkunits.units.mass;

/**
 * 公斤
 * 
 * @author warenix
 * 
 */
public class Kilogram extends Mass implements Kilogramable {

	public Kilogram(double value) {
		super(value);
	}

	@Override
	public Kilogram toKilogram() {
		return new Kilogram(mValue * getUnitKilogram());
	}

	public Kilogramable fromKilogram(Kilogram kg) {
		return new Kilogram(kg.getValue() / getUnitKilogram());
	}

	@Override
	public String getUnit() {
		return "公斤";
	}

	@Override
	public double getUnitKilogram() {
		return 1.0;
	}
}
