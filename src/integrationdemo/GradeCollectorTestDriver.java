package integrationdemo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
 * This demo program is to test the module "GradeCollector"
 */
public class GradeCollectorTestDriver {

	GradeDBStub db;
	AverageComputer c;
	GradeCollector collector;

	// setup a default DB and AverageComputer
	@Before
	public void setup() {
		// GradeDBStub is a stub module used by GradeCollector
		int grade[][] = { { 50, 50, 50, 50 }, { 100, 100, 100, 100 } };
		db = new GradeDBStub();
		db.setGrade(grade);

		// AverageComputer is another stub module used by GradeCollector
		AverageComputer c = new AverageComputer();
		collector = new GradeCollector(db, c);
	}

	// a normal case
	@Test
	public void test() {

		try {
			double g[] = collector.getGrade(1234);
			assertArrayEquals(new double[] { 50.0, 100.0 }, g, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// error check: if the program can check invalid classID
	@Test(expected = java.lang.Exception.class)
	public void test2() throws Exception {
		try {
			// 12345 is a invalid classID
			double g[] = collector.getGrade(12345);
		} catch (Exception e) {
			assertEquals("Invalid class ID", e.getMessage());
			// make the @Test (expected ...) happy
			throw new Exception();
		}
	}

	// error check: if the program can check invalid grade?
	@Test(expected = java.lang.Exception.class)
	public void test3() throws Exception {
		// -50 is an invalid grade
		int grade2[][] = { { 50, 50, -50, 50 }, { 100, 100, 100, 100 } };
		db.setGrade(grade2);

		try {
			double g[] = collector.getGrade(1234);
		} catch (Exception e) {
			assertEquals("Invalid grade", e.getMessage());
			// make the @Test (expected ...) happy
			throw new Exception();
		}
	}

}
