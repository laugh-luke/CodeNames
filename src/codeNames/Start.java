//Written By Luke

package codeNames;

//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import codeNamesGUI.*;

public class Start extends Control {

	// this needs to be a singleton class ????

	private Words newWordList;
	private Grid playerGrid;
	private Grid spymasterGrid;
	

	public Words getNewWordList() {
		return newWordList;
	}
	
	public Grid getPlayerGrid() {
		return playerGrid;
	}

	
	public Grid getSpymasterGrid() {
		return spymasterGrid;
	}


	public void setNewWordList() {
		this.newWordList = new Words("words.txt");
	}

	public Start() {

		// import words

		setNewWordList();

		// create grids

		playerGrid = new Grid("player", this.getNewWordList());
		spymasterGrid = new Grid("spymaster", this.getNewWordList());

	}

}
