package codeNames;

public class Guess {
final String text;
	 int guessLeft;
public Guess(String guess,int NumofGuesses){
this.text=guess;
this.guessLeft= NumofGuesses;
}
public String  getGuess(){
return this.text;
}
public void setGuessLeft(int guessesLeft) {
	 this.guessLeft=guessesLeft;}

public int getGuessLeft() {
	return this.guessLeft;}


}