package org.example;

import org.example.ReportGenerator.Filter;
import org.junit.jupiter.api.*;
import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@KillAndHowBeforeEachTest
class TransactionManager_WestSeparateTest {

	@BeforeEach
	public void setup() {
		AndHow.findConfig()
			.setClasspathPropFilePath("/west_region.properties");
	}

	@Test
	public void happyPath() {
		assertEquals("west", Filter.REGION.getValue().toLowerCase());
		// ... and do some actual app testing
	}

	@Test
	public void zipCode90212() {
		AndHow.findConfig()
			.addFixedValue(Filter.ZIP, "90212");

		assertEquals("90212", Filter.ZIP.getValue());
		// ... and do some actual app testing
	}

	// Other tests will also share the same AndHow instance
}