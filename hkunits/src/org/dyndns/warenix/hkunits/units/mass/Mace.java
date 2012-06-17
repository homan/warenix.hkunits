package org.dyndns.warenix.hkunits.units.mass;

/**
 * 錢
 * 
 * @author warenix
 * 
 */
public class Mace extends Mass implements Kilogramable {

	public Mace(double value) {
		super(value);
	}

	@Override
	public Kilogram toKilogram() {
		return new Kilogram(mValue * getUnitKilogram());
	}

	public Kilogramable fromKilogram(Kilogram kg) {
		return new Mace(kg.getValue() / getUnitKilogram());
	}

	@Override
	public String getUnit() {
		return "錢";
	}

	@Override
	public double getUnitKilogram() {
		return 0.00377994;
	}
}
