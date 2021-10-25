package org.example;

import org.example.ReportGenerator.Filter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeAllTests;
import static org.junit.jupiter.api.Assertions.assertTrue;

@KillAndHowBeforeAllTests
class TransactionManager_WestSharedTest {

	@BeforeAll
	public static void setup() {
		AndHow.findConfig()
			.setClasspathPropFilePath("/west_region.properties");
		AndHow.instance();  // Optional, but prevents tests from modifying
	}

	@Test
	public void testEastRegionWithWideMargins() {
		assertTrue("West".equalsIgnoreCase(Filter.REGION.getValue()));
	}

	// Other tests will also share the same AndHow instance
}