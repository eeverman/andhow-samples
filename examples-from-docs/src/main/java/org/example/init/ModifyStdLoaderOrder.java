package org.example.init;

import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.load.std.*;

/** This class will be found at runtime and used to initiate AndHow */
public class ModifyStdLoaderOrder implements AndHowInit {
	@Override public AndHowConfiguration getConfiguration() {
		return  StdConfig.instance()
				.setStandardLoaders(StdEnvVarLoader.class, StdJndiLoader.class);
	}
}
