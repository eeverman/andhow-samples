package org.simple;

import org.junit.Test;
import org.yarnandtail.andhow.*;

import static org.junit.Assert.*;

/**
 * Simple testing example.
 * 
 * The AndHowTestBase can be used to simplify testing by killing the AndHow
 * instance before each test so that each test reinitializes the AndHow framework,
 * making it easy to test under multiple configuration scenarios.
 * 
 */
public class GettingStarted2Test extends AndHowTestBase {
	
	/**
	 * Simple test
	 */
	@Test
	public void testLaunch1_SetPropertiesWithSystemProps() {

		GettingStarted2.main(new String[] {
			"org.simple.GettingStarted2.COUNT_DOWN_START=4",
			"org.simple.GettingStarted2.LAUNCH_CMD=Goo"
		});
		
		GettingStarted2 gs = new GettingStarted2();
		
		//AndHow initiation happens automatically as soon as one of the properties
		//is accessed.
		assertEquals(Integer.valueOf(4), GettingStarted2.COUNT_DOWN_START.getValue());
		assertEquals("4...3...2...1...Goo", gs.launch());
	}
	
}
