package com.bigcorp;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

	@Test
	public void happyPath() {
		DistanceCalculator dc = new DistanceCalculator();

		//For any location, the distance should be positive
		assertTrue(
			dc.calcDistanceTo(BigDecimal.ZERO, BigDecimal.ZERO).doubleValue() >= 0d);
	}

}