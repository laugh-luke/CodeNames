// Written by Leo

package codeNames;

import java.io.*;

import java.util.ArrayList;

public class Writer {
	public void write(String outFile, ArrayList<String> outAL) {
		try {
			BufferedWriter bufferedOut = new BufferedWriter(new FileWriter(outFile));
			for (String s : outAL) {
				bufferedOut.write(s + ",");
			}

			bufferedOut.close();
		} catch (IOException e) {
			System.out.println("Input Output Exception Detected: " + e);
		} catch (Exception e) {
			System.out.println("Exception Detected: " + e);
		}
	}

}
