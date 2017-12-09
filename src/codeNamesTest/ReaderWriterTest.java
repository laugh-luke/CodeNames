//Written by Leo

package codeNamesTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import codeNames.*;


public class ReaderWriterTest {
	
	public Writer writerTest = new Writer();
	public Reader readerTest = new Reader();
	public ArrayList<String> wordsTest = new ArrayList<String>();
	
	
	@Test
	public void wordsTest() {
		wordsTest.add("One");
		wordsTest.add("Two");
		wordsTest.add("Three");
		writerTest.write("C:\\Users\\Admin\\Files\\fileName.txt", wordsTest);
		
		assertEquals("ReaderClass and WriterClass are functioning incorrectly.", wordsTest, readerTest.read("C:\\Users\\Admin\\Files\\fileName.txt"));
	}


}
