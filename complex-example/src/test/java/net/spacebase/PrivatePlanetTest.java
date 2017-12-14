/*
 */
package net.spacebase;

import org.junit.Test;
import org.yarnandtail.andhow.*;

import static org.junit.Assert.*;

/**
 *
 * @author ericeverman
 */
public class PrivatePlanetTest extends AndHowTestBase {
	

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
