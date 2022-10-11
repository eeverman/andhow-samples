package net.spacebase;

import org.junit.jupiter.api.Test;
import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;

import static org.junit.jupiter.api.Assertions.*;

@KillAndHowBeforeEachTest
public class PrivatePlanetTest {
	

	/**
	 * Test of main method, of class SpaceBaseApplication.
	 */
	@Test
	public void testUsingProductionPropertiesFile() {
		PrivatePlanet pp = new PrivatePlanet();
		assertEquals("TOP_SECRET_MAIN", pp.getSecret());
	}

	@Test
	public void testUsingTestPropertiesFile() {


		AndHow.findConfig().setClasspathPropFilePath("/test_andhow.properties");
		
		PrivatePlanet pp = new PrivatePlanet();
		assertEquals("TOP_SECRET_TEST", pp.getSecret());
	}
	

}
