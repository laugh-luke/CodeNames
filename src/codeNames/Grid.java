// Written By Luke

package codeNames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Grid {

	// Intrinsic Grid Variables

	private ArrayList<String> colourGrid;
	private ArrayList<String> wordGrid;
	private static String currentTurn;
	private static int initialRed = 0;
	private static int initialBlue = 0;

	// Getters and Setters

	public static int getInitialRed() {
		return initialRed;
	}

	public static void setInitialRed(int a) {
		initialRed = a;
	}

	public static int getInitialBlue() {
		return initialBlue;
	}

	public static void setInitialBlue(int a) {
		initialBlue = a;
	}

	public ArrayList<String> getColourGrid() {
		return colourGrid;
	}

	public void setColourGrid(ArrayList<String> colourGrid) {
		this.colourGrid = colourGrid;
	}

	public ArrayList<String> getWordGrid() {
		return wordGrid;
	}

	public void setWordGrid(ArrayList<String> wordGrid) {
		this.wordGrid = wordGrid;
	}

	public String getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(String c) {
		currentTurn = c;
	}

	// Construct Grid

	public Grid(String s, Words generatedWords) {

		// Initialise intrinsic variables.
		// this.colourGrid = new ArrayList<String>();
		// this.wordGrid = new ArrayList<String>();
		currentTurn = "";

		// Get Words from Words Class

		this.wordGrid = generatedWords.getWordsForGrid();

		// Generate colourGrid

		if (s.equals("player")) {

			this.colourGrid = new ArrayList<String>();
			for (int i = 0; i < 25; i++) {
				this.colourGrid.add("white");
			}
			// make player's colour grid

		} else {

			// make spymaster's colour grid
			randomColoursGen();

		}

		// Set turn based on more red or more blue
	}

	// Update Grid

	public void updatePlayerGrid(Grid spymasterGrid, Guess G) {

		// check if we have positive number of guesses left

		if (G.getGuessLeft() >= 0) {
			// find the word that matches
			for (int i = 0; i < 25; i++) {
				if (this.wordGrid.get(i).equals(G.getGuess())) {
					// update player grid, game state and number of guesses remaining
					this.colourGrid.set(i, spymasterGrid.colourGrid.get(i));

					// THIS STILL NEEDS WORK!!!!
					// Need a way to force the turns to switch.

					WinConditions win = new WinConditions(initialRed, initialBlue);
					win.status(this.getColourGrid());

					// Don't know how to interact this, but we need a discussion on it.

					/*
					 * int decision = WinConditions.decision(); //what does this return?
					 * switch(decision) { case 0: break; case 1: break; case 2: break; case 3:
					 * break; case 4: break; default: }
					 */

					G.setGuessLeft(G.getGuessLeft() - 1);
					updateTurn(spymasterGrid.colourGrid.get(i), G.getGuessLeft());
				}
			}
		}
	}

	// Utilities

	// Generates the spymaster's colour grid
	private void randomColoursGen() {
		// 8 red or blue
		// 9 blue or red
		// 7 cream
		// 1 black
		// for a total of 25

		ArrayList<String> initialGrid = new ArrayList<String>();
		initialGrid.add("black");
		for (int i = 0; i < 8; i++) {
			initialGrid.add("red");
			initialGrid.add("blue");
			if (i < 7) {
				initialGrid.add("cream");
			}
		}

		Random goesFirst = new Random();
		int n = goesFirst.nextInt(2);

		if (n == 0) {
			// 8 blue 9 red
			initialGrid.add("red");
			currentTurn = "red";
			initialRed = 9;
			initialBlue = 8;
		} else {
			// 9 blue 8 red
			initialGrid.add("blue");
			currentTurn = "blue";
			initialRed = 8;
			initialBlue = 9;
		}

		Collections.shuffle(initialGrid);
		this.colourGrid = initialGrid;
	}

	// Updates who's turn it is based on the outcome of the guess and the current
	// turn.
	private static void updateTurn(String colour, int g) {
		// if we've run out of guesses or turned over the wrong colour
		if (g < 0 || !colour.equals(currentTurn)) {
			// then it is the other team's go
			if (currentTurn.equals("red")) {
				currentTurn = "blue";
			} else if (currentTurn.equals("blue")) {
				currentTurn = "red";
			}
		}
		// otherwise do nothing
	}

	@Override
	public String toString() {
		String S = "";

		for (int i = 0; i < 25; i++) {
			S += "(" + this.wordGrid.get(i) + ", " + this.colourGrid.get(i) + ") ";
			if ((i + 1) % 5 == 0) {
				S += "\n";
			}
		}

		return S;
	}

}
