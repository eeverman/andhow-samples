package org.simple;

import org.yarnandtail.andhow.service.AbstractPropertyRegistrar;
import org.yarnandtail.andhow.service.PropertyRegistrationList;

/*
Java9 places 'Generated' in a module that needs to be separate included in a build
or brought in as a dependency.  As a result, just using a comment instead.
@javax.annotation.Generated(
	value="org.yarnandtail.andhow.compile.AndHowCompileProcessor",
	date="2017-12-11T10:02:48.032-0600",
	comments="Proxy for org.simple.GettingStarted registered as a service provider in META-INF/services/org.yarnandtail.andhow.service.PropertyRegistrar") */
public class $GettingStarted_AndHowProps extends AbstractPropertyRegistrar {

	@Override
	public String getRootCanonicalName() { return "org.simple.GettingStarted"; }

	@Override
	public void addPropertyRegistrations(PropertyRegistrationList list) {
		list.add("COUNT_DOWN_START");
		list.add("LAUNCH_CMD");

	}

}

