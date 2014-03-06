package integrationdemo;

/*
 * This is a stub class
 */
public class GradeDBStub implements GradeDB {
	int grade[][];

	public int[][] getGrade(int classID) {
		return grade;
	}

	/*
	 * This function is just for testing, A real GradeDB will not have this
	 * function
	 */
	public void setGrade(int grade[][]) {
		this.grade = grade;
	}
}
