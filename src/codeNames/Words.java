//Written by Joe

package codeNames;

//import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;

//import java.util.Random;

//dependancies: reader/writer
//feeds into 
public class Words {

	private ArrayList<String> Dictionary;
	private ArrayList<String> WordsForGrid;
	// private ArrayList<String> WordsForGrid;

	public Words(String pathToFile) {
		Reader r = new Reader(); // calling leo's reader
		Dictionary = r.read(pathToFile);
		this.WordsForGrid = getWords();

	}

	public ArrayList<String> getWords() {
		ArrayList<String> W = new ArrayList<String>();
		Collections.shuffle(Dictionary);
		for (int i = 0; i < 25; i++) {
			W.add(Dictionary.get(i));
		}
		/*
		 * int i =0; while (W.size() < 26) {
		 * 
		 * //int i =1; //initiate index
		 * 
		 * 
		 * //for( i=0 , i<25 , i++) { int r = (int)Math.random()*Dictionary.size();
		 * String word = Dictionary.get(r); // if/else here to check for repeated words
		 * if (W.contains(word)){ continue; } //eg if WordsForGrid contains word, gen
		 * new random index //else set the word to current index i else { W.set(i,
		 * word); i++; }
		 * 
		 * //} } System.out.println(W);
		 */
		return W;
	}

	public ArrayList<String> getWordsForGrid() {
		return WordsForGrid;
	}

	public void setWordsForGrid(ArrayList<String> wordsForGrid) {
		WordsForGrid = wordsForGrid;
	}

}
