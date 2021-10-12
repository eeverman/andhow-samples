package com.bigcorp;

import static org.hamcrest.MatcherAssert.*;
import org.hamcrest.number.BigDecimalCloseTo;
import org.junit.jupiter.api.Test;
import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeThisTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

	//
	// There is no special AndHow configuration for this test, so AndHow finds /myapp.properties file
	// in the test resources.  The name '/myapp.properties' is used because of the configuration
	// in the MyAndHowInit class.
	@Test
	public void happyPath() {
		DistanceCalculator dc = new DistanceCalculator();

		assertThat(
				dc.getBaseLatitude(),
				BigDecimalCloseTo.closeTo(BigDecimal.valueOf(45L), BigDecimal.ZERO));

		assertThat(
				dc.getBaseLongitude(),
				BigDecimalCloseTo.closeTo(BigDecimal.valueOf(-90L), BigDecimal.ZERO));

		// A 3x4x5 right triangle
		assertThat(
				dc.calcDistanceTo(BigDecimal.valueOf(48L), BigDecimal.valueOf(-94L)),
				BigDecimalCloseTo.closeTo(BigDecimal.valueOf(5L), BigDecimal.ZERO));
	}


	//myapp-scenario2.properties

	//
	// For this test, override the path set in MyAndHowInit with the 'scenario2' one.
	// '@KillAndHowBeforeThisTest' pushes the AndHow state aside for this test,
	// then restores it when the test is complete.
	//
	// Note tha the MyAndHowInit class is still invoked and used.  The configuration in
	// this test just adds to or overrides what was done in that class.
	@Test
	@KillAndHowBeforeThisTest
	public void test0_0BaseLocation() {

		AndHow.findConfig().setClasspathPropFilePath("/myapp-scenario2.properties");

		DistanceCalculator dc = new DistanceCalculator();

		assertThat(
				dc.getBaseLatitude(),
				BigDecimalCloseTo.closeTo(BigDecimal.valueOf(0L), BigDecimal.ZERO));

		assertThat(
				dc.getBaseLongitude(),
				BigDecimalCloseTo.closeTo(BigDecimal.valueOf(0L), BigDecimal.ZERO));

		// A 3x4x5 right triangle
		assertThat(
				dc.calcDistanceTo(BigDecimal.valueOf(3L), BigDecimal.valueOf(4L)),
				BigDecimalCloseTo.closeTo(BigDecimal.valueOf(5L), BigDecimal.ZERO));
	}

}