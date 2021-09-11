package org.simple;

import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.property.*;

/**
 * This is the example from the AndHow project's Readme file.
 * 
 * <h3>Section //1 : Declare AndHow Properties</h3>
 * {@code StrProp} & {@code IntProp} are AndHow {@code Property}'s.
 * Properties are created as <em>constants</em> in your application, thus, they are always
 * {@code final static}, but may be {@code private} or any scope.
 * Properties are strongly typed, so default values and validation are type specific, e.g.
 * defaults of {@code "Dave"} vs {@code 1}.<br/>
 * {@code builder()} methods simplify Property construction.
 * 
 * <h3>Section //2 : Using AndHow Properties</h3>
 * Properties are used just like static final constants with {@code .getValue()} tacked on.
 * Strong typing means that {@code NAME.getValue()} returns a {@code String} while
 * {@code REPEAT_COUNT.getValue()} returns an {@code Integer}.
 * <p>
 * Since these Properties declare default values, no added configuration is required to run
 * this example: running {@code HelloWorld.main()} will print {@code Hello, Dave} twice.
 */
public class HelloWorld {
	
	//1 Declare AndHow Properties
	private final static StrProp NAME = StrProp.builder()
			.defaultValue("Dave").build();
		
	public final static IntProp REPEAT_COUNT = IntProp.builder()
			.defaultValue(2).build();
	
	public static void main(String[] args) {
		
		//2 Use AndHow Properties
		for (int i = 0; i < REPEAT_COUNT.getValue(); i++) {
			System.out.println("Hello, " + NAME.getValue());
		}
	}
}