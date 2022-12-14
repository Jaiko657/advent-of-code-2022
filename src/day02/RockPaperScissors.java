package day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissors {

	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day02\\input.txt";

	public static void main(String[] args) {
		int score = 0;

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(INPUT_LOCATION));
			// preconditions for while loop
			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				// read next line
				char enemy = line.charAt(0);
				char player = line.charAt(2);

				//make code more readable
				char eRock = 'A';
				char ePaper = 'B';
				char eScissors = 'C';

				char pRock = 'X';
				char pPaper = 'Y';
				char pScissors = 'Z';

				if (player == pRock) {
					score += 1;
					if (enemy == eScissors) {
						score += 6;
					}
					if (enemy == eRock) {
						score += 3;
					}
				} else if (player == pPaper) {
					score += 2;
					if (enemy == eRock) {
						score += 6;
					}
					if (enemy == ePaper) {
						score += 3;
					}
				} else if (player == pScissors) {
					score += 3;
					if (enemy == ePaper) {
						score += 6;
					}
					if (enemy == eScissors) {
						score += 3;
					}
				}
				//read in line for next loop
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(score);
	}

}
