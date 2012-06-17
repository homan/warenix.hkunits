package org.dyndns.warenix.hkunits.units.mass;

/**
 * 厘
 * 
 * @author warenix
 * 
 */
public class Cash extends Mass implements Kilogramable {

	public Cash(double value) {
		super(value);
	}

	@Override
	public String getUnit() {
		return "厘";
	}

	@Override
	public Kilogram toKilogram() {
		return new Kilogram(mValue * getUnitKilogram());
	}

	@Override
	public Kilogramable fromKilogram(Kilogram kg) {
		return new Cash(kg.getValue() / getUnitKilogram());
	}

	@Override
	public double getUnitKilogram() {
		return 3.68543801e-5;
	}

}
