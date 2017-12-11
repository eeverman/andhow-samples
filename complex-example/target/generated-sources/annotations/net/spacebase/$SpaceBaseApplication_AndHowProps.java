package net.spacebase;

import org.yarnandtail.andhow.service.AbstractPropertyRegistrar;
import org.yarnandtail.andhow.service.PropertyRegistrationList;

/*
Java9 places 'Generated' in a module that needs to be separate included in a build
or brought in as a dependency.  As a result, just using a comment instead.
@javax.annotation.Generated(
	value="org.yarnandtail.andhow.compile.AndHowCompileProcessor",
	date="2017-12-10T21:37:54.064-0600",
	comments="Proxy for net.spacebase.SpaceBaseApplication registered as a service provider in META-INF/services/org.yarnandtail.andhow.service.PropertyRegistrar") */
public class $SpaceBaseApplication_AndHowProps extends AbstractPropertyRegistrar {

	@Override
	public String getRootCanonicalName() { return "net.spacebase.SpaceBaseApplication"; }

	@Override
	public void addPropertyRegistrations(PropertyRegistrationList list) {
		list.add("APP_NAME", "AppInfo");
		list.add("APP_PUBLIC_URL");
		list.add("INCEPTION_DATE");

	}

}

