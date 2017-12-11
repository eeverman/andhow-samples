package net.spacebase;

import org.yarnandtail.andhow.service.AbstractPropertyRegistrar;
import org.yarnandtail.andhow.service.PropertyRegistrationList;

/*
Java9 places 'Generated' in a module that needs to be separate included in a build
or brought in as a dependency.  As a result, just using a comment instead.
@javax.annotation.Generated(
	value="org.yarnandtail.andhow.compile.AndHowCompileProcessor",
	date="2017-12-11T10:02:44.876-0600",
	comments="Proxy for net.spacebase.SatelliteServiceConfig registered as a service provider in META-INF/services/org.yarnandtail.andhow.service.PropertyRegistrar") */
public class $SatelliteServiceConfig_AndHowProps extends AbstractPropertyRegistrar {

	@Override
	public String getRootCanonicalName() { return "net.spacebase.SatelliteServiceConfig"; }

	@Override
	public void addPropertyRegistrations(PropertyRegistrationList list) {
		list.add("ITEM_ENDPOINT");
		list.add("QUERY_ENDPOINT");
		list.add("SERVICE_URL");
		list.add("TIMEOUT");

	}

}

