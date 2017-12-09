package codeNamesTest;


import codeNames.*;
import junit.framework.TestCase;

public class WinConditionsTest extends TestCase {
	public void testgetStatus() {
		WinConditions w= new WinConditions(7,8);
		 int redcount=w.getStatus()[0];
		assertEquals("Fail",0,redcount);}
	
	public void teststatus() {
		WinConditions w= new WinConditions(7,8);
		String[] test = {"blue","red","blue"};
		w.getStatus();
		int redcount=w.getStatus()[0];
		assertEquals("Fail",1,redcount);}
		
			
	public void testdecision1() {
		WinConditions w= new WinConditions(7,8);
		String[] test = {"blue","red","blue"};
		w.getStatus();
		Guess guess =new Guess("Dog",1);
		assertEquals("Fail",4,w.decision(guess));}
		
		public void testdecision2() {
			WinConditions w= new WinConditions(7,8);
			String[] test = {"blue","red","blue"};
			w.getStatus();
			Guess guess =new Guess("Dog",2);
			assertEquals("Fail",3,w.decision(guess));}

		
			public void testdecision3() {
				WinConditions w= new WinConditions(7,2);
				String[] test = {"blue","red","blue"};
				w.getStatus();
				Guess guess =new Guess("Dog",2);
				assertEquals("Fail",2,w.decision(guess));}
				
			public void testdecision4() {
				WinConditions w= new WinConditions(1,3);
				String[] test = {"blue","red","blue"};
				w.getStatus();
				Guess guess =new Guess("Dog",2);
				assertEquals("Fail",1,w.decision(guess));}
			
			
			public void testdecision5() {
					WinConditions w= new WinConditions(7,2);
					String[] test = {"blue","black","blue"};
					w.getStatus();
					Guess guess =new Guess("Dog",2);
					assertEquals("Fail",0,w.decision(guess));
				
	}
}
