/*
 */
package org.simple;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.AndHowTestBase;

import static org.junit.Assert.*;

/**
 *
 * @author ericeverman
 */
public class CustomInitTest extends AndHowTestBase {

	public static final String CLASSPATH_OF_PROPS = "/copy_me_to_filesystem.properties";

	File tempPropFile;

	public CustomInitTest() {
	}

	@Before
	public void setupTestFile() throws IOException {

		//copy a properties file to a temp location
		URL inputUrl = getClass().getResource(CLASSPATH_OF_PROPS);
		tempPropFile = File.createTempFile("andhow_test", ".properties");
		tempPropFile.deleteOnExit();
		FileUtils.copyURLToFile(inputUrl, tempPropFile);
	}

	@After
	public void teardownTestFile() throws IOException {
		tempPropFile.delete();
	}

	@Test
	public void testConfigWithoutSpecifyingAFileSystemPathSoUsingSimplePropFile()
			throws IOException {

		//We could explicitly initiate AndHow, but implicity init will do the same thing
		//AndHow.findConfig().build();
		SimpleStringArgs ssa = new SimpleStringArgs();

		//These values found in /my.properties file
		//By default AndHow reads from /andhow.properties, but CustomInit changed the name
		assertEquals(Integer.valueOf(3), SimpleStringArgs.COUNT_DOWN_START.getValue());
		assertEquals("3...2...1...GoClasspath!", ssa.launch());
	}

	@Test
	public void testConfigFromFilesystem() throws IOException {
		AndHow.findConfig()
				.addFixedValue(CustomInit.PROP_FILE_ON_FILESYSTEM, tempPropFile.getCanonicalPath())
				.build();

		SimpleStringArgs ssa = new SimpleStringArgs();

		//These values loaded from a file on the file system that was copied from
		// /copy_me_to_filesystem.properties
		assertEquals(Integer.valueOf(4), SimpleStringArgs.COUNT_DOWN_START.getValue());
		assertEquals("4...3...2...1...GoFilesystem!", ssa.launch());
	}

}
