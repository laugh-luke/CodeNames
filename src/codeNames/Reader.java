// Written by Leo

package codeNames;


import java.io.*;
import java.util.ArrayList;

public class Reader {
	public ArrayList<String> read(String inFile) {
		ArrayList<String> outAL = new ArrayList<String>();
		try {
			BufferedReader bufferedIn = new BufferedReader(new FileReader(inFile));
			String line = "";

			while ((line = bufferedIn.readLine()) != null) {
				String[] splitting = line.split(",");
				for (String s : splitting) {
					outAL.add(s);
				}
			}
			bufferedIn.close();
		} catch (IOException e) {
			System.out.println("Input Output Exception Detected: " + e);
		} catch (Exception e) {
			System.out.println("Exception Detected: " + e);
		}
		return outAL;
	}
	
	public String readString(String inFile) {
		String outAL = "";
		try {
			BufferedReader bufferedIn = new BufferedReader(new FileReader(inFile));
			String line = "";

			while ((line = bufferedIn.readLine()) != null) {
				//String[] splitting = line.split(",");
				//for (String s : splitting) {
					outAL+=line + "\n";
				//}
			}
			bufferedIn.close();
		} catch (IOException e) {
			System.out.println("Input Output Exception Detected: " + e);
		} catch (Exception e) {
			System.out.println("Exception Detected: " + e);
		}
		return outAL;
	}

}
