package org.simple;

import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.property.StrProp;

// A class implementing AndHowInit will be found at runtime and used to
// initiate AndHow.  Only a single AndHowInit class is allowed on the classpath.
public class LoadFromFileSystem implements AndHowInit {

	//YOU... want to configuration your application with a prop file on the filesystem.
	//AndHow... wants to be configured so that it can know where to find that file.
	//Solution:  Create a Property to tell AndHow where to find the file.
	//This property can be configured via any loader loading prior to the Filesystem loader.
	//Load order:  https://sites.google.com/view/andhow/user-guide/value-loaders
	public static final StrProp MY_APP_PROP_FILE_PATH = StrProp.builder()
			.desc("Path to a properties file on the filesystem, in a form "
				+ "appropriate to the local system, eg: /path/config.properties "
				+ "or C:PATH\\config.properties.  If specified, the file must exist.").build();

	@Override
	public AndHowConfiguration getConfiguration() {

		//Catch AndHow at its initiation and tell it that MY_APP_PROP_FILE_PATH
		//is a special property to use for loading from the filesystem.
		return  StdConfig.instance()
				.setFilesystemPropFilePath(MY_APP_PROP_FILE_PATH);
	}
}
