package integrationdemo;

/*
 * This demo program is for "Integration Test"
 */

public class GradeCollector {
	GradeDB db = null;
	AverageComputer avg;
	int subjectGrade[][];
	double grade[] = null;
	static int NUMBER_OF_SUBJECT = 4;

	public GradeCollector(GradeDB db, AverageComputer avg) {
		this.db = db;
		this.avg = avg;
	}

	/*
	 * To query the grade of all students in the class classID.
	 * 
	 * The result array stores the average grade of each student.
	 */
	public double[] getGrade(int classID) throws Exception {

		if (validClassID(classID)) {
			if (db == null)
				throw new Exception("Please set the GradeDB first");

			subjectGrade = db.getGrade(classID);
			if (validGrade(subjectGrade)) {
				avg = new AverageComputer();
				grade = avg.computeAverage(subjectGrade);
			} else
				throw new Exception("Invalid grade");
		} else
			throw new Exception("Invalid class ID");

		return grade;
	}

	/*
	 * Set the GradeDB by calling the method setGradeDB. By this way,
	 * RealGradeDB and GradeDBStub are are easy to exchange
	 */
	public void setGradeDB(GradeDB db) {
		this.db = db;
	}

	boolean validClassID(int c) {
		if (c >= 1000 && c <= 9999)
			return true;
		else
			return false;
	}

	/*
	 * Valid grade book means (1) each grade must between 1-100 (2) all number
	 * of subjects must be equals to the constant NUMBER_OF_SUBJECT
	 */
	boolean validGrade(int[][] gradeBook) {
		if (gradeBook == null)
			return false;
		else {
			for (int i = 0; i < gradeBook.length; i++) {
				if (gradeBook[i].length != NUMBER_OF_SUBJECT)
					return false;

				// all grade must between 1-100;
				for (int j = 0; j < gradeBook[i].length; j++) {
					int g = gradeBook[i][j];
					if (g > 100 || g < 0) {
						return false;
					}
				}
			}
		}
		return true;

	}
}