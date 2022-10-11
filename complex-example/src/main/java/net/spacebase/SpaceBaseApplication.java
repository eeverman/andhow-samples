package net.spacebase;

import java.time.LocalDateTime;
import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.property.*;

/**
 * A ficticious space themed application.
 * 
 * @author eeverman
 */
public class SpaceBaseApplication {
	
	//To similate how a larger application would run, this is a singleton.
	//In a web application, this might be a main 'run on startup' servlet,
	//In a desktop app, this would probably something similar to this.
	public static SpaceBaseApplication singleton;
	
	public SpaceBaseApplication() {

	}
	
	/**
	 * A central entry point.
	 * @param args 
	 */
	public static void main(String[] args) {
		
		//Calling findConfig()...build() is optional for AndHow - it would startup
		//just fine the first time a Property is accessed.
		//However, to insert command line arguments into what is parsed to read
		//property values, this is the way to do it.
		//
		//findConfig() will find the AndHowInit implementation that will be used
		//to initiate AndHow.  That could be the default imlementation or,
		//if the project has a custom one on the classpath, it will use that one.
		//This application *does* have a custom one called 'SpaceBaseInit'.
		//
		//Also, if there is an AndHowTestInit class is on the test classpath,
		//it will be used during testing.
		AndHow.findConfig().setCmdLineArgs(args);

		System.out.println("Spacebase App is started!");
		singleton = new SpaceBaseApplication();
		
		System.out.println("App name is: " + singleton.getAppName());
		System.out.println("The PrivatePlanet secret is: " + new PrivatePlanet().getSecret());
		System.out.println("The PublicPlanet broadcast url is: " + new PublicPlanet().getBroadcastUrl());
		System.out.println("The ReallyOldSatelliteService timeout is: " + new ReallyOldSatelliteService().getTimeout());
	}
	
	public static SpaceBaseApplication instance() {
		return singleton;
	}
	
	
	public String getAppName() {
		return AppInfo.APP_NAME.getValue();
	}
	
	public String getAppUrl() {
		return AppInfo.APP_PUBLIC_URL.getValue();
	}
	
	public LocalDateTime getInceptionDate() {
		return AppInfo.INCEPTION_DATE.getValue();
	}
	
	
	//
	// Here are two configuration groups that are added to AndHow, above.
	// Normally these would be in separate files, or even better, in files
	// within the modules they configure.  
	
	@GroupInfo(name="Application Information", desc="Basic app info for display in the UI")
	public interface AppInfo {
		StrProp APP_NAME = StrProp.builder().notNull().defaultValue("Space Base").aliasIn("APP_NAME").build();
		StrProp APP_PUBLIC_URL = StrProp.builder().notNull().startsWith("http://").defaultValue("http://spacebase.net").build();
		LocalDateTimeProp INCEPTION_DATE = 
				LocalDateTimeProp.builder().notNull().defaultValue(LocalDateTime.parse("2017-10-01T00:00")).build();
	}
	
}
