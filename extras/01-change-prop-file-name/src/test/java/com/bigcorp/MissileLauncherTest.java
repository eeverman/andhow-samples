package com.bigcorp;

import org.hamcrest.number.BigDecimalCloseTo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;

class MissileLauncherTest {

	@BeforeEach
	void setUp() {
	}

	@Test
	public void happyPath() {
		MissileLauncher ml = new MissileLauncher();


		// A 3x4x5 right triangle
		assertThat(
				ml.setTarget(BigDecimal.valueOf(48L), BigDecimal.valueOf(-94L)),
				BigDecimalCloseTo.closeTo(BigDecimal.valueOf(5L), BigDecimal.ZERO));
	}
}