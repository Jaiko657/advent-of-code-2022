package day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CampCleanup {

	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day04\\input.txt";

	public static void main(String[] args) {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(INPUT_LOCATION));
			// preconditions for while loop
			String line = reader.readLine();
			int sum = 0;

			while (line != null) {
				System.out.println(line);
				try {
					String[] sides = line.split(",");
					String[] leftSide = sides[0].split("-");
					String[] rightSide = sides[1].split("-");
					Integer[] overLaps = { Integer.parseInt(leftSide[0]), Integer.parseInt(leftSide[1]),
							Integer.parseInt(rightSide[0]), Integer.parseInt(rightSide[1]) };
					if(overLaps[0] >= overLaps[2] && overLaps[1] <= overLaps[3]) {
						sum++;
					} else if(overLaps[2] >= overLaps[0] && overLaps[3] <= overLaps[1]) {
						sum++;
					}
					System.out.println(sum);
				} catch (Exception e) {
					e.printStackTrace();
				}

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
