package org.example;

import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.load.PropFileOnClasspathLoader;
import org.yarnandtail.andhow.load.std.*;

/** This class will be found at runtime and used to initiate AndHow */
public class InsertLoader implements AndHowInit {
	@Override public AndHowConfiguration getConfiguration() {
		PropFileOnClasspathLoader pfl = new PropFileOnClasspathLoader();
		pfl.setFilePath("/my.properties");
		
		return  StdConfig.instance()
				.insertLoaderBefore(StdJndiLoader.class, pfl);
	}
}
