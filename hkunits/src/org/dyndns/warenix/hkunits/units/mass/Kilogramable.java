package org.dyndns.warenix.hkunits.units.mass;

public interface Kilogramable {
	/**
	 * convert 1 unit of the mass to kilograms
	 */
	public Kilogram toKilogram();

	public double getUnitKilogram();

	public Kilogramable fromKilogram(Kilogram kg);
}
