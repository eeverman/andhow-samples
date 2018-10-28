package net.spacebase;

import org.yarnandtail.andhow.property.*;

/**
 * Simplest Property usage example in this application.
 * 
 * @author ericeverman
 */
public class PrivatePlanet {

	//Properties can be declared anywhere you can declare a static variables.
	//The MUST be static final.
	//As best practice, group Properties into interfaces as the other classes do.
	static final StrProp IM_PRIVATE = StrProp.builder().defaultValue("TOP_SECRET").build();


	public String getSecret() {
		return IM_PRIVATE.getValue();
	}

}
