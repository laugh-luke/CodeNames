package codeNamesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import codeNames.*;

//4 methods to test
//get&set helpAL
//
public class HelpTest {
public Help testH = new Help();


	@Test
	public void createArrayTest() {
		String pathToHelp="";
		Help H = new Help();
		
		String HelpTest = Help.getHelpAL();
		//ArrayList<String> HelpTestload = buildListL();
		assertEquals("Help Not Found ","help file text",HelpTest);
	}
	
	@Test
	public void HelpArraytest() {
		
		
		
		
		//assertEquals("Not yet implemented",obj,obj);
	}

	
	//test loaded help arraylist is the expected arraylist;
}
