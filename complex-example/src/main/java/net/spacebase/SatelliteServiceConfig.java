package net.spacebase;

import org.yarnandtail.andhow.GroupExport;
import org.yarnandtail.andhow.GroupInfo;
import org.yarnandtail.andhow.api.Exporter;
import org.yarnandtail.andhow.export.SysPropExporter;
import org.yarnandtail.andhow.property.IntProp;
import org.yarnandtail.andhow.property.StrProp;

/**
 * A standalone interface used to wrap the configuration for the legacy
 * ReallyOldSatelliteService (that you cannot modify).
 * 
 * Notice that we can provide full documentation for all the parameters and
 * make sure they end up assigned to the right sys props that ReallyOldSatelliteService
 * is expecting.
 * 
 * @author ericeverman
 */
@GroupExport(exporter = SysPropExporter.class,
		exportByCanonicalName = Exporter.EXPORT_CANONICAL_NAME.NEVER, 
		exportByOutAliases = Exporter.EXPORT_OUT_ALIASES.ALWAYS)
@GroupInfo(name = "Satellite Service Configuration for a legacy service",
		desc = "ReallyOldSatelliteSerive is a legacy/3rd party service that doesn't " +
				"use AndHow and is only configurable via system properties.  No Problem! " +
				"Create Properties for the configuration points and add aliases for " +
				"the System property names the legacy service is expecting.")
public interface SatelliteServiceConfig {

	/*
	Each Property includes an 'aliasInAndOut', which does two things:  Adds an
	alternate name recognized when loading the property, and adds a name to
	export the property to.  Here the alias names match the sys props expected
	in the ReallyOldSatelliteSerivce.
	
	The @GroupExport annotation on this interface tells AndHow to export all
	Properties defined here as system properties using their 'out' alias names.
	
	This lets us use the strong typing, early validation and rich documentation
	of AndHow, but still pass values thru to legacy systems that only use System
	properties for configuration.
	 */
	StrProp SERVICE_URL = StrProp.builder().endsWith("/").notNull().aliasInAndOut("sat.svs").build();
	IntProp TIMEOUT = IntProp.builder().defaultValue(20).notNull().aliasInAndOut("sat.to").build();
	StrProp QUERY_ENDPOINT = StrProp.builder().notNull().aliasInAndOut("sat.query").build();
	StrProp ITEM_ENDPOINT = StrProp.builder().notNull().aliasInAndOut("sat.item").build();

}
