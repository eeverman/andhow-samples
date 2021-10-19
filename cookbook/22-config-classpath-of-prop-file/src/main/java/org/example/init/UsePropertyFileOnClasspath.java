package org.example.init;

import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.property.StrProp;

/** 
 * This class would be found at runtime and used to initiate {@code AndHowInit}
 * <br>
 * This example adds a String Property named {@code MY_PROP_FILE_ON_CLASSPATH}
 * (the name is arbitrary)
 * which is used to tell {@code AndHow} where to find a properties file
 * on the classpath.  When {@code AndHow} initializes, the
 * {@code StdPropFileOnClasspathLoader} checks to see if a value has been loaded
 * for {@code MY_PROP_FILE_ON_CLASSPATH} by a prior loader.  If a value is present,
 * the loader tries to load from the configured classpath.  If no value is
 * configured, a default classpath of {@code /andhow.properties} is assumed.
 * <br>
 * Adding a {@code Property} to enable a custom classpath properties file can be useful
 * for testing or common deployment profiles.  For instance, a system property
 * could specify that {@code /test.properties} be used during testing,
 * {@code /qa_mode.properties} on a QA server and {@code /production.properties} on
 * a production server.
 * 
 * <h2>NOTE</h2>
 * <em>This class and the others in this package cannot be used
 * in the same application together.  Each example class in this package
 * implements {@code AndHowInit}, which is intended to be a unique initiation
 * point for an application.  Having multiple {@code AndHowInit}'s in an
 * application would cause an error at startup.
 * </em>
 * <p>
 * To use this example, copy this class to your own application.
 */
public class UsePropertyFileOnClasspath implements AndHowInit {
	public static final StrProp MY_CLASSPATH = StrProp.builder()
			.desc("Path to a properties file on the classpath. "
				+ "If the file is not present, it is not considered an error.").build();

	@Override
	public AndHowConfiguration getConfiguration() {
		return  AndHow.findConfig()
				.setClasspathPropFilePath(MY_CLASSPATH);
	}
}
