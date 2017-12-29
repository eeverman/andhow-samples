package com.anyco.webapp.calc;

import org.yarnandtail.andhow.GroupInfo;
import org.yarnandtail.andhow.property.DblProp;

/**
 * Example calculation class w/ configuration consolidated in an interface.
 */
public class Calculator {
	
	public double doFooCalc(double input) {
		return input * CONFIG.FOO_COEF.getValue();
	}
	
	public double doBarCalc(double input) {
		return input * CONFIG.BAR_COEF.getValue();
	}

	@GroupInfo(name="Calc coeficients", desc="My description...")
	public static interface CONFIG {
		DblProp FOO_COEF = DblProp.builder()
				.desc("Values below 5 or over 10 are risky...")
				.mustBeGreaterThan(1d).mustBeLessThan(20d).mustBeNonNull().build();
		DblProp BAR_COEF = DblProp.builder()
				.desc("Values below zero are allowed, but check with engineering first.")
				.mustBeGreaterThan(-1d).mustBeLessThan(1d).mustBeNonNull().build();
	}
}
