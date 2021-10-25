package org.example;

import org.junit.jupiter.api.Test;
import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeThisTest;
import org.example.ReportGenerator.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransactionManagerTest {

	// Properties are read from test classpath /andhow.properties
	@Test
	public void happyPathTest() {
		assertNull(Filter.REGION.getValue());
		assertEquals(BigDecimal.TEN, Filter.MIN_SALE.getValue());
	}

	@Test @KillAndHowBeforeThisTest
	public void test90210Zip() {
		AndHow.findConfig()
			.addFixedValue(Filter.ZIP, "90210")
			.addFixedValue(Filter.REGION, "west");

		assertTrue("west".equalsIgnoreCase(Filter.REGION.getValue()));
		assertEquals("90210", Filter.ZIP.getValue());
		// ... and do some actual app testing
	}

	@Test @KillAndHowBeforeThisTest
	public void testEastRegionReport() {
		AndHow.findConfig()
			.setClasspathPropFilePath("/east_region.properties");

		assertTrue("East".equalsIgnoreCase(Filter.REGION.getValue()));
		// ... and do some actual app testing
	}

	@Test @KillAndHowBeforeThisTest
	public void testEastRegionWithWideMargins() {
		AndHow.findConfig()
			.setClasspathPropFilePath("/east_region.properties")
			.addFixedValue(Format.MARGIN, 2.5);

		assertTrue("East".equalsIgnoreCase(Filter.REGION.getValue()));
		assertEquals(2.5, Format.MARGIN.getValue(), .00001);
	}
}