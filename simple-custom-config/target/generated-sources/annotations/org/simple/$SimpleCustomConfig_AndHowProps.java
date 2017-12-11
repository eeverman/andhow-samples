package org.simple;

import org.yarnandtail.andhow.service.AbstractPropertyRegistrar;
import org.yarnandtail.andhow.service.PropertyRegistrationList;

/*
Java9 places 'Generated' in a module that needs to be separate included in a build
or brought in as a dependency.  As a result, just using a comment instead.
@javax.annotation.Generated(
	value="org.yarnandtail.andhow.compile.AndHowCompileProcessor",
	date="2017-12-10T21:38:02.688-0600",
	comments="Proxy for org.simple.SimpleCustomConfig registered as a service provider in META-INF/services/org.yarnandtail.andhow.service.PropertyRegistrar") */
public class $SimpleCustomConfig_AndHowProps extends AbstractPropertyRegistrar {

	@Override
	public String getRootCanonicalName() { return "org.simple.SimpleCustomConfig"; }

	@Override
	public void addPropertyRegistrations(PropertyRegistrationList list) {
		list.add("COUNT_DOWN_START");
		list.add("LAUNCH_COMMAND");

	}

}

