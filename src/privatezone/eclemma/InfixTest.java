package privatezone.eclemma;

import static java.lang.System.out;
import static org.junit.Assert.*;

import org.junit.Test;

public class InfixTest {

	@Test
	public void testToPostfix() {
        String infix = "(a*b)";
        out.println();
        assertEquals("ab*", Infix.toPostfix(infix));
	}
	
	@Test
	public void testToPostfix2() {
        String infix = "(a*b)+(c*d)";
        out.println();
        assertEquals("ab*cd*+", Infix.toPostfix(infix));
	}


	@Test
	public void testToPrefix() {
        String infix = "(a*b)";
        out.println();
        assertEquals("*ab", Infix.toPrefix(infix));
	}

	@Test
	public void testToPrefix2() {
        String infix = "(a*b)+(c*d)";
        out.println();
        assertEquals("+*ab*cd", Infix.toPrefix(infix));
	}

}
