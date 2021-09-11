package org.simple;

import org.yarnandtail.andhow.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;
import org.yarnandtail.andhow.junit5.RestoreSysPropsAfterThisTest;

/**
 * Simple testing example.
 * 
 * The AndHowTestBase can be used to simplify testing by killing the AndHow
 * instance before each test so that each test reinitializes the AndHow framework,
 * making it easy to test under multiple configuration scenarios.
 * 
 */
@KillAndHowBeforeEachTest //AndHow provided Junit extension that allows each test to re-initialize AndHow
public class SimpleStringArgsTest {
	
	/**
	 * Simple test
	 */
	@Test
	public void setPropertiesWithMainStringArgs() {

		String[] StrArgs = {
			"org.simple.SimpleStringArgs.COUNT_DOWN_START=4",
			"org.simple.SimpleStringArgs.LAUNCH_CMD=Goo"
		};
		
		
		SimpleStringArgs.main(StrArgs);	//forces AndHow initiation
		
		SimpleStringArgs gs = new SimpleStringArgs();
		
		assertEquals(Integer.valueOf(4), SimpleStringArgs.COUNT_DOWN_START.getValue());
		assertEquals("4...3...2...1...Goo", gs.launch());
		assertFalse(gs.isNewsNotified());	//set false via a fixed value
	}
	
	@Test
	public void tryToSetNOTIFY_NEWSViaMainStringArgs() {

		String[] StrArgs = {
			"org.simple.SimpleStringArgs.NOTIFY_NEWS=true"
		};
				
		SimpleStringArgs.main(StrArgs);	//forces AndHow initiation
		
		SimpleStringArgs gs = new SimpleStringArgs();
		
		assertFalse(gs.isNewsNotified());	//still false b/c its fixed in the main method
	}
	
	@Test
	@RestoreSysPropsAfterThisTest //AndHow provided Junit extension to erase System.property changes
	public void buildWithoutMainMethodAndLetDefaultNOTIFY_NEWSComeThru() {

		//using sys props to set prop values
		System.setProperty("org.simple.SimpleStringArgs.COUNT_DOWN_START", "1");
		System.setProperty("org.simple.SimpleStringArgs.LAUNCH_CMD", "Go!Go!Go!");
		//System.setProperty("org.simple.SimpleStringArgs.NOTIFY_NEWS", "true");
		
		SimpleStringArgs gs = new SimpleStringArgs();
		
		//AndHow initiation happens as soon as a property value is read
		assertEquals(Integer.valueOf(1), SimpleStringArgs.COUNT_DOWN_START.getValue());
		assertEquals("1...Go!Go!Go!", gs.launch());
		assertTrue(gs.isNewsNotified());	//This is the default value coming thru
	}
	
	@Test
	@RestoreSysPropsAfterThisTest //AndHow provided Junit extension to erase System.property changes
	public void buildWithoutMainMethodAndSetNOTIFY_NEWS() {

		//using sys props to set prop values
		System.setProperty("org.simple.SimpleStringArgs.COUNT_DOWN_START", "1");
		System.setProperty("org.simple.SimpleStringArgs.LAUNCH_CMD", "Go!Go!Go!");
		System.setProperty("org.simple.SimpleStringArgs.NOTIFY_NEWS", "false");
		
		SimpleStringArgs gs = new SimpleStringArgs();
		
		//AndHow initiation happens as soon as a property value is read
		assertEquals(Integer.valueOf(1), SimpleStringArgs.COUNT_DOWN_START.getValue());
		assertEquals("1...Go!Go!Go!", gs.launch());
		assertFalse(gs.isNewsNotified());	//Now reads this value from a sys prop
	}
	
}
