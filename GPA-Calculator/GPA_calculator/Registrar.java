
/**
 * This class represents a Registrar to calculate missing grade format and GPA of 
 * a student transcript
 * @author Owen Lee // 3595946
 */
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Registrar {
	/**
	*point list is a list of point grades that can be earned by students
	*/
	private final double POINT_LIST[];
	/**
	*letterList is a list of letter grades that can be earned by students
	*/
	private final String LETTER_LIST[];
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	*Constructor to build a Registrar object and initialize grade lists
	*/
	public Registrar() {
		POINT_LIST=new double[]{4.3,4,3.7,3.3,3,2.7,2.3,2,1.7,1,0};
		LETTER_LIST=new String[]{"A+","A","A-","B+","B","B-",
								"C+","C","C-","D","F"};
		}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	*Method to find the missing grade format 
	*@param pointGrade is the point grade relating to the letterGrade
	*/
	public String FindMissingFormat(double pointGrade) throws Exception{
		
		int position=-1;
		for(int i=0;i<11;i++) {
			if(POINT_LIST[i]==pointGrade) {
				position=i;
			}
		}
		
		if(position==-1) 
			throw new Exception("Input grade invalid");
		else 
			return LETTER_LIST[position];
	}
	
	/**
	*Method to find the missing grade format 
	*@param letterGrade is the letterGrade relating to the pointGrade
	*/
	public double FindMissingFormat(String letterGrade) throws Exception{
		
		int position=-1;
		for(int i=0;i<11;i++) {
			if(LETTER_LIST[i]==letterGrade) {
				position=i;
			}
		}
		
		if(position==-1)
			throw new Exception("Input grade invalid");
		else 
			return POINT_LIST[position];
	}
}
