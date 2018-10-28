package net.spacebase;

/**
 * This is an example of an old legacy class that perhaps you cannot modify to
 * use AndHow.  It relies on system properties for its configuration.
 * 
 * Likely its hard to get a complete list of its configuration properties or find
 * complete documentation for them.  On top of that, they are all passed
 * and read as Strings, so they fragile and difficult to validate.
 * 
 * See how this is handled by AndHow in the SatelliteServiceConfig interface.
 * 
 * @author ericeverman
 */
public class ReallyOldSatelliteService {
	
	//
	//Some old code you cannot change that reads configuration from Sys props:
	public String getQueryUrl() {
		return System.getProperty("sat.svs") + System.getProperty("sat.query");
	}
	
	public String getItemUrl() {
		return System.getProperty("sat.svs") + System.getProperty("sat.item");
	}
	
	public int getTimeout() {
		//Yikes!  What happens if the "sat.to" sys prop is null or not an int??
		//AndHow fixes this - see the SatelliteServiceConfig class
		return Integer.parseInt(System.getProperty("sat.to"));
	}

}
