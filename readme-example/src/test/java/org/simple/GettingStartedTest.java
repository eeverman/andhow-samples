package org.simple;

import org.junit.jupiter.api.Test;
import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;
import org.yarnandtail.andhow.junit5.RestoreSysPropsAfterThisTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple testing example.
 * 
 * The AndHowTestBase can be used to simplify testing by killing the AndHow
 * instance before each test so that each test reinitializes the AndHow framework,
 * making it easy to test under multiple configuration scenarios.
 * 
 */
@KillAndHowBeforeEachTest
public class GettingStartedTest {
	
	/**
	 * Simple test
	 */
	@Test
	@RestoreSysPropsAfterThisTest //AndHow provided Junit extension to erase System.property changes
	public void testLaunch1_SetPropertiesWithSystemProps() {

		//Set the LAUNCH_CMD via a system property
		System.setProperty("org.simple.GettingStarted.COUNT_DOWN_START", "1");
		System.setProperty("org.simple.GettingStarted.LAUNCH_CMD", "Go!Go!Go!");

		GettingStarted gs = new GettingStarted();
		
		//AndHow initiation happens automatically as soon as one of the properties is accessed.
		assertEquals(Integer.valueOf(1), GettingStarted.COUNT_DOWN_START.getValue());
		assertEquals("1...Go!Go!Go!", gs.launch());
	}
	
	@Test
	@RestoreSysPropsAfterThisTest //AndHow provided Junit extension to erase System.property changes
	public void testLaunch2_SetPropertyWithSystemPropsAndDefault() {

		//2 is the default for COUNT_DOWN_START, so let it be used
		System.setProperty("org.simple.GettingStarted.LAUNCH_CMD", "Gone!");

		GettingStarted gs = new GettingStarted();
		
		assertEquals(Integer.valueOf(3), GettingStarted.COUNT_DOWN_START.getValue());
		assertEquals("3...2...1...Gone!", gs.launch());
	}
	

	@Test
	public void testLaunch3_UsingCommandLineArguments() throws Exception {
		
		//findConfig() finds the configuration that would be used if AndHow
		//initiated on its own, auto-discovering any AndHowInit or AndHowTestInit
		//configuration providers to provide that configuration.
		//For this test there are no AndHowInit classes, so a StdConfig instance
		//is returned from findConfig().
		AndHow.findConfig().setCmdLineArgs(new String[] {
			"org.simple.GettingStarted.COUNT_DOWN_START=4",
			"org.simple.GettingStarted.LAUNCH_CMD=GoManGo!"
		});


		GettingStarted gs = new GettingStarted();
		
		assertEquals(Integer.valueOf(4), GettingStarted.COUNT_DOWN_START.getValue());
		assertEquals("4...3...2...1...GoManGo!", gs.launch());
	}
	
}
