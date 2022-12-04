package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RucksackReorganization {

	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day3\\input.txt";

	public static void main(String[] args) {
		ArrayList<String[]> data = new ArrayList<>();
		int currentIndex = 0;

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(INPUT_LOCATION));
			// preconditions for while loop
			String line = reader.readLine();
			String[] empty = { "", "" };

			while (line != null) {
				// read next line
				try {
					data.add(empty);
					String compartment1 = line.substring(0, line.length() / 2);
					String compartment2 = line.substring(line.length() / 2, line.length());
					String[] pair = { compartment1, compartment2 };
					data.set(currentIndex++, pair);
				} catch (Exception e) {
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int sum = 0;
		for (String[] line : data) {
			System.out.println(line[0] + '-' + line[1]);
			ArrayList<Character> usedCharacters = new ArrayList<Character>();
			for (char ch : line[0].toCharArray()) {
				if (line[1].contains(ch + "") && !usedCharacters.contains(ch)) {
					usedCharacters.add(ch);
					if (Character.isLowerCase(ch)) {
						sum += (int) ch;
						sum -= 96; //offset for lower case characters
					} else {
						sum += (int) ch;
						sum -= 38; //offset for upper case characters
					}
				}
				System.out.println(sum);
			}
		}
	}
}
