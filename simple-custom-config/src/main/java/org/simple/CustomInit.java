package org.simple;

import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.property.StrProp;

/** This class will be found at runtime and used to initiate AndHow */
public class CustomInit implements AndHowInit {
	public static final StrProp PROP_FILE_ON_FILESYSTEM = StrProp.builder()
			.desc("Path to a properties file on the filesystem, "
				+ "in form appropriate to the local system. "
				+ "If specified, it must exist.").build();

	@Override
	public AndHowConfiguration getConfiguration() {
		return  StdConfig.instance()
				.setClasspathPropFilePath("/my.properties")
				.setFilesystemPropFilePath(PROP_FILE_ON_FILESYSTEM);
	}
}
