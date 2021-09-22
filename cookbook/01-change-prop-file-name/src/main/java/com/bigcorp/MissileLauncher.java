package com.bigcorp;

import org.yarnandtail.andhow.property.*;

import java.math.BigDecimal;

public class MissileLauncher {

	private static interface Config {
		BolProp ENABLE = BolProp.builder().defaultValue(false).
				desc("Set true to enable missile launch. " +
						"Please set to false in TEST and QA environments!").build();
		IntProp COUNT_DOWN = IntProp.builder().defaultValue(3).mustBeGreaterThan(1).
				desc("Number of seconds to count down from").build();
	}

	public boolean isEnabled() {
		return Config.ENABLE.getValue();
	}

	public int getCountDown() {
		return Config.COUNT_DOWN.getValue();
	}

	public Double setTarget(Double lat, Double lng) {
		DistanceCalculator calc = new DistanceCalculator();

		BigDecimal dist = calc.calcDistanceTo(BigDecimal.valueOf(lat), BigDecimal.valueOf(lng));
		return dist.doubleValue();
	}

	public String launch() {
		String out = "";

		for (int i = getCountDown(); i >=0; i--) {
			out += out + i + "... ";
		}

		if (isEnabled()) {
			out += "Launch!";
		} else {
			out += "(just kidding)";
		}

		return out;
	}
}
