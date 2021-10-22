package org.example.init;

import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.load.PropFileOnClasspathLoader;
import org.yarnandtail.andhow.load.std.*;

/** 
 * This class would be found at runtime and used to initiate {@code AndHowInit}
 * <br>
 * This example inserts a {@code PropFileOnClasspathLoader} loader into the
 * list of loaders, after the Jndi loader.  It hard-codes the file location
 * for that loader as &quote;/my.properties&quote;.  Hard-coding the path is
 * generally not a good strategy, since paths will likely vary depending on the
 * environment.
 * 
 * <h2>NOTE</h2>
 * <em>This class and the others in this package cannot be used
 * in the same application together.  Each example class in this package
 * implements {@code AndHowInit}, which is intended to be a unique initiation
 * point for an application.  Having multiple {@code AndHowInit}'s in an
 * application would cause an error at startup.
 * </em>
 * <p>
 * To use this example, copy this class to your own application.
 */
public class InsertLoader implements AndHowInit {
	@Override public AndHowConfiguration getConfiguration() {
		PropFileOnClasspathLoader pfl = new PropFileOnClasspathLoader();
		pfl.setFilePath("/my.properties");
		
		return  AndHow.findConfig()
				.insertLoaderBefore(StdJndiLoader.class, pfl);
	}
}
