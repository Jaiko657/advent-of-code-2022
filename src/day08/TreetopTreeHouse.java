package day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TreetopTreeHouse {

	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day08\\input.txt";

	private static int getFileHeight(String fileName) throws IOException {
		int count = 0;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		while (reader.readLine() != null)
			count++;
		reader.close();
		return count;
	}

	public static void main(String[] args) {
		try {
			int height = getFileHeight(INPUT_LOCATION);
			int[][] data = new int[height][height];

			BufferedReader reader = new BufferedReader(new FileReader(INPUT_LOCATION));
			String line = reader.readLine();
			int row = 0;
			while (line != null) {
				char[] lineArray = line.toCharArray();
				for (int i = 0; i < lineArray.length; i++) {
					char c = lineArray[i];
					data[row][i] = Integer.parseInt(c + "");
				}
				row++;
				line = reader.readLine();
			}
			reader.close();

			int count = 0;
			for (int i = 0; i < height; i++) {

				for (int j = 0; j < height; j++) {
					if (isVisible(data, i, j))
						count++;
				}
			}
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean isVisible(int[][] data, int row, int column) {
		int testValue = data[row][column];

		// left
		int directionsClear = 4;
		for (int i = column - 1; i + 1 != 0; i--) {
			int currentValue = data[row][i];
			if (testValue <= currentValue) {
				directionsClear--;
				break;
			}
		}
		// right
		for (int i = column + 1; i != data[0].length; i++) {
			int currentValue = data[row][i];
			if (testValue <= currentValue) {
				directionsClear--;
				break;
			}
		}
		// up
		for (int i = row - 1; i + 1 != 0; i--) {
			int currentValue = data[i][column];
			if (testValue <= currentValue) {
				directionsClear--;
				break;
			}
		}
		// down
		for (int i = row + 1; i != data.length; i++) {
			int currentValue = data[i][column];
			if (testValue <= currentValue) {
				directionsClear--;
				break;
			}
		}

		if (directionsClear > 0)
			return true;
		return false;
	}

}
