package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class CalorieCounting {

	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day1\\input.txt";

	public static void main(String[] args) {
		ArrayList<Integer> data = new ArrayList<>();
		int currentIndex = 0;

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(INPUT_LOCATION));
			//preconditions for while loop
			String line = reader.readLine();
			data.add(0);

			while (line != null) {
				System.out.println(line);
				// read next line
				try {
					int incrementNumber = Integer.parseInt(line);
					int currentNumber = data.get(currentIndex);
					data.set(currentIndex, currentNumber + incrementNumber);
				} catch (Exception e) {
					currentIndex++;
					data.add(0);
					line = reader.readLine();
					continue;
				}

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("--------------------");
		for(Integer i : data) {
			System.out.println(i);
		}
		System.out.println("--------------------");
		Collections.sort(data);
		System.out.println(data.get(data.size()-1));

	}
}
