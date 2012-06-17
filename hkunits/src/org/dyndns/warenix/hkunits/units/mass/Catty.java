package org.dyndns.warenix.hkunits.units.mass;

/**
 * 斤
 * 
 * @author warenix
 * 
 */
public class Catty extends Mass implements Kilogramable {

	public Catty(double value) {
		super(value);
	}

	@Override
	public Kilogram toKilogram() {
		return new Kilogram(mValue * getUnitKilogram());
	}

	public Kilogramable fromKilogram(Kilogram kg) {
		return new Catty(kg.getValue() / getUnitKilogram());
	}

	@Override
	public String getUnit() {
		return "斤";
	}

	@Override
	public double getUnitKilogram() {
		return 0.6048;
	}
}
