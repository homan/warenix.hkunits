package org.dyndns.warenix.hkunits;

import org.dyndns.warenix.hkunits.units.mass.Kilogram;
import org.dyndns.warenix.hkunits.units.mass.Kilogramable;

public class MassConvertor {
	public static Kilogram convert(Kilogramable from, Kilogramable to) {
		Kilogram k1 = from.toKilogram();
		Kilogram k2 = to.toKilogram();
		return new Kilogram(k1.getValue() / k2.getValue()
				* to.getUnitKilogram());
	}
}
