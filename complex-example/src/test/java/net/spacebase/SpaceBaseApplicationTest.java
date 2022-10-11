package net.spacebase;

import org.junit.jupiter.api.Test;
import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

@KillAndHowBeforeEachTest
public class SpaceBaseApplicationTest {
	
	public SpaceBaseApplicationTest() {
	}
	
	@BeforeEach
	public void setUp() {
		//Zap the example test class each time
		SpaceBaseApplication.singleton = null;
	}

	/**
	 * Test of main method, of class SpaceBaseApplication.
	 */
	@Test
	public void testMainMethodInitiationWithPropertiesProvidedInRootPropertiesFile() {
		
		//The main method invoked below uses the auto-discovered configuration
		//and adds the command line arguments to it.
		
		//Use the String args to specify the app_name parameter
		SpaceBaseApplication.main(new String[] {"app_name=Spacey Basey"});
		SpaceBaseApplication sba = SpaceBaseApplication.instance();
		
		//Try out the SpaceBaseApplication
		assertEquals("Spacey Basey", sba.getAppName());	//This value picked as an argument to main(String[])
		assertEquals("http://spacebase.net", sba.getAppUrl());	//This is the default value
		assertEquals(LocalDateTime.parse("1999-10-01T00:00"), sba.getInceptionDate());	//picked up from andhow.properties file
		
		
		//Try out the ReallyOldSatelliteService, WHICH ONLY READS SYSTEM PROPERTIES
		ReallyOldSatelliteService ross = new ReallyOldSatelliteService();
		assertEquals("http://satservice.com/item/", ross.getItemUrl());		//from andhow.properties file
		assertEquals("http://satservice.com/query/", ross.getQueryUrl());	//from andhow.properties file
		assertEquals(99, ross.getTimeout());	//from andhow.properties file
		
		//Try out the PublicPlanet, WHICH ONLY READS SYSTEM PROPERTIES
		PublicPlanet ps = new PublicPlanet();
		assertEquals("http://planetserice.org/", ps.getRemoteUrl());		//from andhow.properties file
		assertEquals(50, ps.getRemoteTimeout());	//from andhow.properties file
		
		//These three values are hard-coded in SpaceBaseTestInit as an example of
		//how common settings for tests might be specified
		assertEquals("http://test.logserver.com/ps/", ps.getBroadcastUrl());
		assertEquals(false, ps.isBroadcastEvents());
		assertEquals(false, ps.isCacheEnabled());
	}


	/**
	 * Test of main method, of class SpaceBaseApplication.
	 */
	@Test
	public void exampleOfUsingCustomConfigurationAndSpecifyingATestPropertiesFile() {

		AndHow.findConfig().setClasspathPropFilePath("/test_andhow.properties");
		AndHow.instance();
		
		//This now bypasses the main method configuration.
		SpaceBaseApplication sba = new SpaceBaseApplication();
		
		//Try out the SpaceBaseApplication
		assertEquals("Test Space Base", sba.getAppName());	//This value found in the test_andhow.properties file

		PublicPlanet ps = new PublicPlanet();
		
		//These values are overridden in the SpaceBaseTestInit
		assertEquals("http://test.logserver.com/ps/", ps.getBroadcastUrl());
		assertEquals(false, ps.isBroadcastEvents());
		assertEquals(false, ps.isCacheEnabled());
		

	}

}
