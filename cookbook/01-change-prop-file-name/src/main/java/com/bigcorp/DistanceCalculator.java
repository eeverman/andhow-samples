package com.bigcorp;

import org.yarnandtail.andhow.property.BigDecProp;
import org.yarnandtail.andhow.property.BolProp;
import org.yarnandtail.andhow.property.IntProp;

import java.math.BigDecimal;
import java.math.MathContext;

public class DistanceCalculator {

	private static interface Config {
		BigDecProp LATITUDE = BigDecProp.builder().mustBeNonNull().
				mustBeGreaterThanOrEqualTo(BigDecimal.valueOf(-90L)).
				mustBeLessThanOrEqualTo(BigDecimal.valueOf(90L)).
				desc("Latitude in decimal degrees of missile base.").build();

		BigDecProp LONGITUDE = BigDecProp.builder().mustBeNonNull().
				mustBeGreaterThanOrEqualTo(BigDecimal.valueOf(-180L)).
				mustBeLessThanOrEqualTo(BigDecimal.valueOf(180L)).
				desc("Latitude in decimal degrees of missile base.").build();
	}

	public BigDecimal getBaseLatitude() {
		return Config.LATITUDE.getValue();
	}

	public BigDecimal getBaseLongitude() {
		return Config.LONGITUDE.getValue();
	}

	/**
	 * Calculate the degree distance between the base and the passed lat-long.
	 *
	 * (Please don't copy - The calculation is not fully correct!!)
	 *
	 * @param latitude
	 * @param longitude
	 * @return A degree distance
	 */
	public BigDecimal calcDistanceTo(BigDecimal latitude, BigDecimal longitude) {
		BigDecimal latDist = getBaseLatitude().subtract(latitude).abs();
		BigDecimal longDist = getBaseLongitude().subtract(longitude).abs();

		return latDist.pow(2).add( longDist.pow(2) ).sqrt(MathContext.DECIMAL32);
	}
}
