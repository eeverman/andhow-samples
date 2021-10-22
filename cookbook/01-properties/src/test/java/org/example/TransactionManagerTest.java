package org.example;

import org.junit.jupiter.api.Test;
import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeThisTest;

import static org.example.TransactionManager.Connection.*;

import static org.junit.jupiter.api.Assertions.*;

class TransactionManagerTest {

	@Test
	public void happyPathTest() {
		assertEquals("http://service.net/", BASE_URL.getValue());
	}

	@Test
	@KillAndHowBeforeThisTest
	public void invalidPropertyValueThrowsRuntime() {
		AndHow.findConfig().setClasspathPropFilePath("/bad.properties");

		assertThrows(RuntimeException.class, () -> BASE_URL.getValue());
	}
}