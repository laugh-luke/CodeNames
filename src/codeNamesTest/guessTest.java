//Written by Josh

package codeNamesTest;

import codeNames.*;
import junit.framework.TestCase;

public class guessTest extends TestCase {

public void testGetName() {
Guess guess= new Guess("Dog",1);
assertEquals("Fail","Dog", guess.getGuess());
}	



}
