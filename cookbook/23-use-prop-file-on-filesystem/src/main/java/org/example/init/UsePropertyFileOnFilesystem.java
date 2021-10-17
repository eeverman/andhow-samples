package org.example.init;

import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.property.StrProp;

/** 
 * This class would be found at runtime and used to initiate {@code AndHowInit}
 * <br>
 * This example adds a String Property named {@code MY_PROP_FILE_ON_FILESYSTEM}
 * (the name is arbitrary)
 * which is used to tell {@code AndHow} where to find a properties file
 * on the file system.  When {@code AndHow} initializes, the
 * {@code StdPropFileOnFilesystemLoader} checks to see if a value has been loaded
 * for {@code MY_PROP_FILE_ON_FILESYSTEM} by a prior loader.  If a value is present,
 * the loader tries to load from the configured path.
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
public class UsePropertyFileOnFilesystem implements AndHowInit {
	public static final StrProp MY_PROP_FILE_ON_FILESYSTEM = StrProp.builder()
			.desc("Path to a properties file on the filesystem, "
				+ "in form appropriate to the local system. "
				+ "If specified, it must exist.").build();

	@Override
	public AndHowConfiguration getConfiguration() {
		return  StdConfig.instance()
				.setFilesystemPropFilePath(MY_PROP_FILE_ON_FILESYSTEM);
	}
}
