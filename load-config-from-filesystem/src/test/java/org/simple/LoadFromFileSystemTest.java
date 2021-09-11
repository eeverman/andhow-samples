package org.simple;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;
import org.yarnandtail.andhow.junit5.RestoreSysPropsAfterThisTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@KillAndHowBeforeEachTest //AndHow provided Junit extension that allows each test to re-initialize AndHow
public class LoadFromFileSystemTest {

	public static final String CLASSPATH_OF_PROPS = "/copy_me_to_filesystem.properties";

	File tempPropFile;

	public LoadFromFileSystemTest() {
	}

	@BeforeEach
	public void setupTestFile() throws IOException {

		//copy a properties file to a temp location
		URL inputUrl = getClass().getResource(CLASSPATH_OF_PROPS);
		tempPropFile = File.createTempFile("andhow_test", ".properties");
		tempPropFile.deleteOnExit();
		FileUtils.copyURLToFile(inputUrl, tempPropFile);
	}

	@AfterEach
	public void teardownTestFile() throws IOException {
		tempPropFile.delete();
	}

	@Test
	@RestoreSysPropsAfterThisTest //AndHow provided Junit extension to erase System.property changes
	public void testConfigViaSysPropsWithoutSpecifyingAFileSystemPath()
			throws IOException {

		//The file on the filesystem is not being used at all
		System.setProperty("org.simple.SimpleStringArgs.LAUNCH_CMD", "Go-LoadedFromSystemProperties!");
		System.setProperty("org.simple.SimpleStringArgs.COUNT_DOWN_START", "3");

		SimpleStringArgs ssa = new SimpleStringArgs();

		//These values found in /my.properties file
		//By default AndHow reads from /andhow.properties, but CustomInit changed the name
		assertEquals(Integer.valueOf(3), SimpleStringArgs.COUNT_DOWN_START.getValue());
		assertEquals("3...2...1...Go-LoadedFromSystemProperties!", ssa.launch());
	}

	@Test
	@RestoreSysPropsAfterThisTest //AndHow provided Junit extension to erase System.property changes
	public void testConfigFromFilesystem() throws IOException {

		//Use a system property to specify which file to load config from.
		//It would also work to specify this property via a main method, env. Var,
		//or JNDI.
		System.setProperty("org.simple.LoadFromFileSystem.MY_APP_PROP_FILE_PATH", tempPropFile.getCanonicalPath());

		SimpleStringArgs ssa = new SimpleStringArgs();

		//These values loaded from a file on the file system that was copied from
		// /copy_me_to_filesystem.properties
		assertEquals(Integer.valueOf(4), SimpleStringArgs.COUNT_DOWN_START.getValue());
		assertEquals("4...3...2...1...GoFilesystem!", ssa.launch());
	}

}
