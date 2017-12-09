package codeNames;

public class Clue {
private final String word;
private  final int guesses;



	
public Clue (String text,int guesses) {
	this.word=text;
	this.guesses=guesses;
}
public static String requestClue() { 
return "please enter Clue";
}



public String getWord() {
return this.word;}

public int getClueNumber() {
return this.guesses;}


}
