package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		writeFile();
		readFile();
	}
	
	public static void writeFile() throws IOException {
		File file = new File("test1.txt");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("hello");
		bufferedWriter.write(System.lineSeparator());
		bufferedWriter.write("world");
		bufferedWriter.close();
		fileWriter.close();
	}
	
	public static void readFile() throws IOException {
		File file = new File("test1.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		while((line = bufferedReader.readLine())!= null) {
			System.out.println(line);
		}
		bufferedReader.close();
		fileReader.close();
	}

}
