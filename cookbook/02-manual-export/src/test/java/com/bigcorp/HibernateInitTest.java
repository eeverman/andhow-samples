package com.bigcorp;

import org.junit.jupiter.api.Test;
import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.export.ExportCollector;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import org.yarnandtail.andhow.Options;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;

/**
 * These simple tests don't do much - just show how it might be setup
 */
@KillAndHowBeforeEachTest
class HibernateInitTest {

	@Test
	void getHibernateProperties() throws IllegalAccessException {

		AppDataAccess dao = new AppDataAccess();

		Properties export = dao.getHibernateProperties();

		assertThat(export, hasEntry("hibernate.connection.url", "jdbc:myorasql://host:3306/mydb"));
		assertThat(export, hasEntry("hibernate.connection.username", "bob"));
		assertThat(export, hasEntry("hibernate.connection.password", "secret"));
		assertThat(export, hasEntry("hibernate.connection.pool_size", "2"));
		assertThat(export, hasEntry("pin", "1234"));
		assertEquals(5, export.size());
	}

	@Test
	void exportPropertiesAsMap() throws IllegalAccessException {
		Map<String, String> export = AndHow.instance().export(AppDataAccess.class)
				.collect(ExportCollector.stringMap());

		assertEquals(5, export.size());

	}


}