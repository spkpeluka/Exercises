import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitClase {

	String str = "[\"hola\"   , \"cara\",	\"como andas\", \"tenes caca\"]     \n ";
	String str1 = "[\"hola\"   , \"cara\",	\"como andas\", \"tenes caca\"]{     \n ";
	String str2 = "[\"hola\"   , ]\"cara\",	\"como andas\", \"tenes caca\"]     \n ";
	String str3 = "[\"hola\"   , \"cara\",	\"como andas\", \"tenes caca\"     \n ";
	String str4 = "[\"hola\"]     \n ";
	
	@Test
	public void testJsonListStringFormat(){
		
		assertEquals(Excercise4.correctJsonFormatListStrings(str),true);  		// correct format
		assertEquals(Excercise4.correctJsonFormatListStrings(str4),true);  		// correct format
		assertEquals(Excercise4.correctJsonFormatListStrings(str1),false);		// bad format
		assertEquals(Excercise4.correctJsonFormatListStrings(str2),false);		// bad format
		assertNotEquals(Excercise4.correctJsonFormatListStrings(str3),true);	// bad format
	}

}


