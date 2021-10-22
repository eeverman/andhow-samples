package com.bigcorp;

import org.yarnandtail.andhow.AndHow;

/**
 * Simple class with a main method entry point so this app can be run from command-line.
 * <p>
 * Unit tests can be run from any IDE or via Maven ({@code mvn clean test}).
 * To run as an application, see the instruction in the Readme.md file at the
 * root of andhow-samples project (its easy).
 */
public class Main {
	public static void main(String[] args) throws Exception {
		AndHow.findConfig().setCmdLineArgs(args);

		AppDataAccess dao = new AppDataAccess();

		System.out.println("Exported Hibernate properties:");
		dao.getHibernateProperties().entrySet().stream().forEach(
				e -> System.out.println(e.getKey() + ": " + e.getValue()));

	}
}
