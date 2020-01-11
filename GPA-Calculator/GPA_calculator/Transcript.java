package ass1.olee;

import java.util.ArrayList;

/**
 * This Class represents a transcript for a student, containing all of their grades
 * @author Owen Lee // 3595946
 */
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Transcript {
	/**
	*stuID represents the student ID on the transcript
	*/
	private int stuID;
	/**
	*grades is a list of grade objects that appear on transcript
	*/
	private ArrayList<Grade> grades;
	
	private int numGrades;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	*Constructor to build a transcript given a student ID
	*@param stuID is the studentID of the student on transcript
	*/
	public Transcript(int stuID) {
		this.stuID=stuID;
		grades=new ArrayList<Grade>();
		numGrades=0;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	*Method to add a grade to the transcript
	*@param toAdd is the grade object to add
	*/
	public void addGrade(Grade toAdd) {
		grades.add(toAdd);
		numGrades++;
	}
	
	/**
	*Method to remove a grade from the transcript based on a course number
	*@param courseNum is the course number of the course to remove.
	*/
	public void removeGrade(String courseNum) {
		int index=0;
		for(Grade temp: grades) {
			if(courseNum==temp.getCourseNum()) {
				break;
			}
			index++;
		}
		grades.remove(index);
		numGrades--;
	}
	
	/**
	*Method to calculate the GPA of the given transcript
	*@return gpa the gpa given grades on transcript
	*/
	public double calculateGPA() {
		double total=0;
		double totalCredit=0;
		double gpa;
		
		for(int i=0;i<numGrades;i++) {
			Grade current= grades.get(i);
			total+=current.getCreditHour()*current.getPointGrade();
			totalCredit+=current.getCreditHour();	
		}
		gpa=total/totalCredit;
		return gpa;
	}
	
	/**
	*Method to return a string that contains all the info on the student transcript
	*@return a string that contains the complete transcript information
	*/
	public String toString() {
    	return "Student " + stuID + ":\n" + grades.toString().replace(", ", "")
    			.replace("[", "").replace("]", "").trim()+"\nGPA: "+
    			String.format("%.3f", calculateGPA());
	}
}
