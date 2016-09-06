
public class Excercise4 {

	static final byte COLON = ':';					//58;
	static final byte COMMA = ',';					//44;
	static final byte QUOTES = '\"';				//34;
	static final byte CARRIAGE_RETURN = 13;
	static final byte NEW_LINE = 10;
	static final byte TAB = 9;
	static final byte SPACE = 32;
	static final byte SQR_LEFT_BRACKET = '[';		//91;
	static final byte SQR_RIGHT_BRACKET = ']';		//93;
	static final byte CURLY_LEFT_BRACKET = '{';		//123;
	static final byte CURLY_RIGHT_BRACKET = '}';	//125;
	
		
	public static void main(String[] args) {
	
		String jsonString = "Juansadsadasdasd    a ;asd";  // quotes in string are not accepted.
		
		System.out.println("String= " + jsonString);
		
		if(correctJsonString(jsonString, 0)){
			for(int i = 0; i < jsonString.length(); i++){
				System.out.println("object"+ i + ": " + jsonString.charAt(i));
			}
		}
		else{
			System.out.println("Json String format error.");
		}
		
		String str = "[\"hola\"   , ]\"cara\",	\"como andas\", \"tenes caca\"]     \n ";
		if(correctJsonFormatListStrings(str)){
			System.out.println("Correct Json List of String format. GREAT !! ");
		}
		else{
			System.out.println("Json List of String format error.");
		}
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////  4 A part 1
	// Write a java method that given a String it determines if it is a valid JSON string.
	// String str = "Juan";
	public static boolean correctJsonString(String str, int position){
				
		if(position == str.length()){			
			return true;						 
		}										
		
		if(str.charAt(position)=='\"') return false;
		
		
		return correctJsonString(str, position + 1);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////  4 A part 2
	// Write a java method that given a String it determines if ais a valid JSON list of strings.
	//“[ “Pedro”, “Walter Castro”,                   “Jaime”   ]”
	
	public static boolean correctJsonFormatListStrings(String str){
		int dataBegin = 0;
		int position = 0;
		boolean inList = false;
		boolean inData = false;
		boolean thereAreData = false;
		
		if(str.equals("")) {
			return false;  // if string is empty returns false
		}		
		
		while(position < str.length()){		
		
			char character = str.charAt(position);
			System.out.println("Char" + position + ": " + character);
			if( ! inList ){	// -------------------------------------------------------------------------------------- NOT inList
				if (character == (char)SQR_LEFT_BRACKET ){
					inList = true;		// --> list starts
					position ++;
					continue;
				}
				
				else if ( unusedSpace(character) ) {
					position ++;	
					continue;							
				}
				
				else{
					return false;
				}
			}				
			else{		// ------------------------------------------------------------------------------------------ inList
				if ( ! inData){	//  -------------------------------------------------------------- not inData
					
					if( character == (char)QUOTES )	{ // --> data starts
						dataBegin = position;
						position ++;
						inData = true;
						continue;
					}				
					
					else if( character == (char)COMMA  && thereAreData)	{ // --> data separator COMMA and exists data previously
						position ++;
						continue;							
					}	
					
					else if( unusedSpace(character) ) {
						position ++;
						continue;									
					}			
					
					else if ( character == (char)SQR_RIGHT_BRACKET ) {
						inList = false;
						position ++;
						continue;							
					}
					
					else{
						return false;
					}											
				}	
				
				else{	//	--------------------------------------------------------------------  inData
				
					if( character == (char)QUOTES ) {	// --> Data ends
					
						if( correctJsonString( str.substring( dataBegin + 1, position - 1), 0 ) )	{	// if correct String Data
							dataBegin = 0;
							inData = false;
							thereAreData = true;	
							position ++;
							continue;									
						}
						
						else {
							return false;					
						}							
					}
					
					else {
						position ++;
						continue;										
					}
				}
			}
		}
		if( str.length() == position ) {		// for end of file
			if( inList ) {
				return false;
			}
			else {
				return true;
			}
		}
		
		return false;
	}
		
	public static boolean unusedSpace(char car){
		
		if(car == (char) TAB) return true;
		if(car == (char) NEW_LINE) return true;
		if(car == (char) CARRIAGE_RETURN) return true;
		if(car == (char) SPACE) return true;
	
		return false;
	}
}
