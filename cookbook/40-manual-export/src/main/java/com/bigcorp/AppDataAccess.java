package com.bigcorp;

import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.api.Exporter;
import org.yarnandtail.andhow.export.ExportCollector;
import org.yarnandtail.andhow.export.ManualExportAllowed;
import org.yarnandtail.andhow.export.ManualExportNotAllowed;
import org.yarnandtail.andhow.property.IntProp;
import org.yarnandtail.andhow.property.StrProp;

import java.util.Properties;

/**
 * A hypothetical class that configures the ORM framework Hibernate using AndHow Properties.
 * <p>
 * Of course, this isn't a complete application, but it shows how this might be done.
 */
@ManualExportAllowed(
		useCanonicalName=Exporter.EXPORT_CANONICAL_NAME.NEVER)
public class AppDataAccess {

	// Properties to config Hibernate (a data access framework)
	private interface HibernateConfig {
		StrProp USER = StrProp.builder()
				.aliasInAndOut("hibernate.connection.username")
				.notNull().build();
		StrProp PWD = StrProp.builder()
				.aliasInAndOut("hibernate.connection.password")
				.notNull().build();
		IntProp POOL_SIZE = IntProp.builder()
				.aliasInAndOut("hibernate.connection.pool_size")
				.defaultValue(20).lessThan(200).build();
	}

	/**
	 * Convenience method to test export properties
	 *
	 * @return
	 * @throws IllegalAccessException
	 */
	public Properties getHibernateProperties() throws IllegalAccessException {
		return AndHow.instance().export(AppDataAccess.class)
				.collect(ExportCollector.stringProperties(""));
	}

	// This 'secret' can be exported by any code that can see the AppDataAccess class due
	// to the @ManualExportAllowed annotation.
	private static final StrProp SECRET_PIN = StrProp.builder()
			.aliasInAndOut("pin")
			.notNull().matches("[0-9]{4}").build();

	@ManualExportNotAllowed	//Block export for the props in these properties
	private interface OTHER_CONFIG {
		StrProp PWD = StrProp.builder().build();
	}


}
