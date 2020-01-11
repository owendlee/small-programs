package ass1.olee;
/**
 * This Class represents results from a class on a students transcript
 * @author Owen Lee // 3595946
 */
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Grade {
    /**
	*courseNum represents the course number of the grade 
	*/
	private String courseNum;
	/**
	*letterGrade is the result of course in terms of a letter grade 
	*/
	private String letterGrade;
	/**
	*pointGrade is the result of course in terms of the point system 
	*/
	private double pointGrade;
	/**
	*creditHour is the number of credit hours the course is worth
	*/
	private double creditHour;
	/**
	*Registrar is the tool used to calculate missing grade
	*/
	private Registrar registrar;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	*Constructor method to create a grade object, uses letter grade as grade format
	*@param courseNum is the course number
	*@param creditHour is the credit hours the course is worth
	*@param letterGrade is the letter grade earned in the course
	*/
	public Grade(String courseNum, double creditHour, String letterGrade) {
		registrar=new Registrar();
		this.courseNum=courseNum;
		this.creditHour=creditHour;
		this.letterGrade=letterGrade;
		try {
		this.pointGrade=registrar.FindMissingFormat(this.letterGrade);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	*Constructor method to create a grade object, uses point grade as grade format
	*@param courseNum is the course number
	*@param creditHour is the credit hours the course is worth
	*@param pointGrade is the point grade earned in the course
	*/
	public Grade(String courseNum, double creditHour, double pointGrade) {
		registrar=new Registrar();
		this.courseNum=courseNum;
		this.creditHour=creditHour;
		this.pointGrade=pointGrade;
		try {
		this.letterGrade=registrar.FindMissingFormat(this.pointGrade);
		}catch(Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
	
//~~~GETTERS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Method to return the course number
	 * @return courseNum is the course number6
	 */
	public String getCourseNum() {
		return courseNum;
	}
	
	/**
	 * Method to return the letter grade
	 * @return letterGrade is the letter grade earned
	 */
	public String getLetterGrade() {
		return letterGrade;
	}
	
	/**
	 * Method to return the point grade
	 * @return pointGrade is the point grade
	 */
	public double getPointGrade() {
		return pointGrade;
	}
	
	/**
	 * Method to return the credit hours the course is worth
	 * @return creditHour is the credit hours its worth
	 */
	public double getCreditHour() {
		return creditHour;
	}
//~~~GETTERS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	/**
	 * Method to change the letterGrade received
	 * @param letter, the new letter grade
	 */
	public void setLetterGrade(String letter) {
		letterGrade=letter;
	}
	
	/**
	 * Method to change the point grade received
	 * @return point, the new point grade
	 */
	public void setPointGrade(double point) {
		pointGrade=point;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	/**
	 * Method to return a complete record of one grade
	 * @return String that contains all the info regarding a grade
	 */
	public String toString() {
		return courseNum +" "+ creditHour + "CH " + pointGrade
				+ " ("+ letterGrade + ")\n";
	}
}
