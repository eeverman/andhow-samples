package simple;

import org.yarnandtail.andhow.AndHow;

import java.math.BigDecimal;

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

		SaleHandler handler = new SaleHandler();

		System.out.println(
				"handle " + BigDecimal.TEN + ": " + handler.handle(BigDecimal.TEN));
	}
}
