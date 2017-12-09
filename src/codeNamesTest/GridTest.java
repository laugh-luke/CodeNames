// Written by Luke

package codeNamesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import codeNames.*;

public class GridTest {

	
	// colourGrid
	@Test
	public void colourGridTest() {
		Grid PlayerGrid = new Grid("player", new Words("words.txt"));
		ArrayList<String> testColourGrid = new ArrayList<String>();
		for(int i=0; i<25; i++)
		{
			testColourGrid.add("white");
		}
		assertTrue(PlayerGrid.getColourGrid().equals(testColourGrid));
		
	}
	
	
	//WordGrid
	@Test
	public void wordGridTest() {
		Grid PlayerGrid = new Grid("player", new Words("words.txt"));
		ArrayList<String> testWordGrid = new ArrayList<String>(Arrays.asList("PLATE", "FISH", "CANADA", "THUMB", "DROP", "CYCLE", "WHIP", "CHOCOLATE", "CIRCLE", "FAN", "NURSE", "MOLE", "LAWYER", "ROBOT", "PUMPKIN", "ANGEL", "SLUG", "PIT", "POLE", "SNOW", "MATCH", "RABBIT", "PAPER", "BOOM", "IVORY"));
		PlayerGrid.setWordGrid(testWordGrid);
		
		assertTrue(PlayerGrid.getWordGrid().equals(testWordGrid));
	}
	
	
	//CurrentTurn
	@Test
	public void currentTurnTest() {
		Grid PlayerGrid = new Grid("player", new Words("words.txt"));
		String currentTurn = "";
		assertTrue(PlayerGrid.getCurrentTurn().equals(currentTurn));
	}
	
	//CurrentTurn
	@Test
	public void postInitialisedCurrentTurnTest() {
		Grid PlayerGrid = new Grid("spymaster", new Words("words.txt"));
		//String currentTurn = "";
		assertTrue(PlayerGrid.getCurrentTurn().equals("red") || PlayerGrid.getCurrentTurn().equals("blue") );
	}

	
	//ToString
	@Test
	public void GridToStringTest() {
		Grid PlayerGrid = new Grid("player", new Words("words.txt"));
		
		ArrayList<String> testWordGrid = new ArrayList<String>(Arrays.asList("IVORY", "GREEN", "AMAZON", "MERCURY", "RAY", "COMIC", "ROBIN", "WORM", "COVER", "SOUND", "DRILL", "CONCERT", "LOG", "CAT", "REVOLUTION", "SLUG", "NEW YORK", "LOCH NESS", "PIPE", "FENCE", "CONDUCTOR", "BEAR", "TELESCOPE", "STRING", "CARROT"));
		ArrayList<String> testColourGrid = new ArrayList<String>(Arrays.asList("blue", "black", "blue", "red", "red", "blue", "red", "blue", "red", "cream", "blue", "cream", "cream", "red", "blue", "cream", "blue", "red", "blue", "cream", "cream", "cream", "red", "red", "red"));

		PlayerGrid.setWordGrid(testWordGrid);
		PlayerGrid.setColourGrid(testColourGrid);
		String expectedOutput= "(IVORY, blue) (GREEN, black) (AMAZON, blue) (MERCURY, red) (RAY, red) \n"
				+ "(COMIC, blue) (ROBIN, red) (WORM, blue) (COVER, red) (SOUND, cream) \n"
				+ "(DRILL, blue) (CONCERT, cream) (LOG, cream) (CAT, red) (REVOLUTION, blue) \n"
				+ "(SLUG, cream) (NEW YORK, blue) (LOCH NESS, red) (PIPE, blue) (FENCE, cream) \n"
				+ "(CONDUCTOR, cream) (BEAR, cream) (TELESCOPE, red) (STRING, red) (CARROT, red) \n";

				
		assertEquals("Grid toString Fail",expectedOutput ,PlayerGrid.toString());
	}
	
	
	//UpdatePlayerGrid
	@Test
	public void testUpdateGrid() {
		Grid PlayerGrid = new Grid("player", new Words("words.txt"));
		Grid SpymasterGrid = new Grid("spymaster", new Words("words.txt"));
		
		ArrayList<String> testWordGrid = new ArrayList<String>(Arrays.asList("IVORY", "GREEN", "AMAZON", "MERCURY", "RAY", "COMIC", "ROBIN", "WORM", "COVER", "SOUND", "DRILL", "CONCERT", "LOG", "CAT", "REVOLUTION", "SLUG", "NEW YORK", "LOCH NESS", "PIPE", "FENCE", "CONDUCTOR", "BEAR", "TELESCOPE", "STRING", "CARROT"));
		ArrayList<String> testColourGrid = new ArrayList<String>(Arrays.asList("blue", "black", "blue", "red", "red", "blue", "red", "blue", "red", "cream", "blue", "cream", "cream", "red", "blue", "cream", "blue", "red", "blue", "cream", "cream", "cream", "red", "red", "red"));

		PlayerGrid.setWordGrid(testWordGrid);
		SpymasterGrid.setWordGrid(testWordGrid);
		SpymasterGrid.setColourGrid(testColourGrid);
		
		Guess G = new Guess("IVORY",1);
		PlayerGrid.updatePlayerGrid(SpymasterGrid, G);
		System.out.println(PlayerGrid.getColourGrid().get(0));
		
		assertTrue("Update Grid Fail", PlayerGrid.getColourGrid().get(0).equals("blue"));
	}


}
