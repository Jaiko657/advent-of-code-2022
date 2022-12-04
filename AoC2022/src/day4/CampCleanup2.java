package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class CampCleanup2 {

	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day4\\input.txt";

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
					ArrayList<Integer> leftSideList = new ArrayList<Integer>();
					ArrayList<Integer> rightSideList = new ArrayList<Integer>();

					IntStream.rangeClosed(overLaps[0], overLaps[1]).forEach(no -> {
						leftSideList.add(no);
					});
					IntStream.rangeClosed(overLaps[2], overLaps[3]).forEach(no -> {
						rightSideList.add(no);
					});
					
						if (leftSideList.stream().anyMatch(element -> rightSideList.contains(element))) {
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
