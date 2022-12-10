package day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RucksackReorganization2 {

	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day03\\input.txt";

	public static void main(String[] args) {
		ArrayList<String[]> data = new ArrayList<>();
		int currentIndex = 0;

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(INPUT_LOCATION));
			// preconditions for while loop
			String[] empty = { "", "", "" };

			while (true) {
				// read next line
				try {
					String elf1 = reader.readLine();
					if (elf1 == null)
						break; //break at end of the file
					String elf2 = reader.readLine();
					String elf3 = reader.readLine();
					String[] pair = { elf1, elf2, elf3 };
					data.add(empty);
					data.set(currentIndex++, pair);
				} catch (Exception e) {
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int sum = 0;
		for (String[] line : data) {
			System.out.println(line[0] + '-' + line[1] + '-' + line[2]);
			ArrayList<Character> usedCharacters = new ArrayList<Character>();
			for (char ch : line[0].toCharArray()) {
				if (line[1].contains(ch + "") && line[2].contains(ch + "") && !usedCharacters.contains(ch)) {
					usedCharacters.add(ch);
					if (Character.isLowerCase(ch)) {
						sum += (int) ch;
						sum -= 96; // offset for lower case characters
					} else {
						sum += (int) ch;
						sum -= 38; // offset for upper case characters
					}
				}
				System.out.println(sum);
			}
		}
	}
}
