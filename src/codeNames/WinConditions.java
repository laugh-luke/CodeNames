package codeNames;

import java.util.ArrayList;

public class WinConditions{
private int initalRedTile;
private int initalBlueTile;
private int redTile;
private int blueTile;
private int blackTile;
private int creamTile;

public WinConditions(int initalRedTile,int initalBlueTile) {
	this.redTile=0;
	this.blueTile=0;
	this.blackTile=0;
	this.creamTile=0;
	this.initalRedTile=initalRedTile;
	this.initalBlueTile=initalBlueTile;
}

public int[] getStatus() {
int [] status= {redTile,blueTile,blackTile,creamTile};
return status;
}

public void status(ArrayList<String> grid)
{
	this.redTile = 0;
	this.blueTile = 0;
	this.blackTile=0;
	this.blackTile=0;
	for(String s : grid)
	{
		if (s.equals("red")) {
		redTile++;
		;
	}
		
	if (s.equals("blue")) {
			blueTile++;
	}
	
	if (s.equals("cream")) {
		creamTile++;}
	
	if (s.equals("black")) {
		blackTile++;}
}
}
public int decision(Guess guess ) {
	if (this.blackTile==1) {
	return 0;  
}

if (redTile==initalRedTile) {
	return 1;}

if (blueTile==initalBlueTile) {
	return 2;}
guess.setGuessLeft(guess.getGuessLeft()-1);
if (guess.getGuessLeft()!=0) {
		return 3;}
		else {return 4;}
}
}



