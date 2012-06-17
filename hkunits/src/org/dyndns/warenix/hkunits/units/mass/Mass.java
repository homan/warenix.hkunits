package org.dyndns.warenix.hkunits.units.mass;

public abstract class Mass {
	protected double mValue;

	public Mass(double value) {
		mValue = value;
	}

	public double getValue() {
		return mValue;
	}

	public abstract String getUnit();

	public String toString() {
		return String.format("%f %s", mValue, getUnit());
	}
}
