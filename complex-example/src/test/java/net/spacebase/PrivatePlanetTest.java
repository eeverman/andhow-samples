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

		//Not calling AndHow.findConfig() here because we don't care what config
		//was going to be used - creating and using a custom one.
		
		//Initiate AndHow using a complete custom AndHowConfiguration
		StdConfig.instance().setClasspathPropFilePath("/test_andhow.properties").build();
		
		PrivatePlanet pp = new PrivatePlanet();
		assertEquals("TOP_SECRET_TEST", pp.getSecret());
	}
	

}
