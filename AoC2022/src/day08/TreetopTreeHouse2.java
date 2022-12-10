package day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TreetopTreeHouse2 {

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

			int max = 0;
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < height; j++) {
					int score = getScenicScore(data, i, j);
					if (score > max) {
						max = score;
					}
				}
			}
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int getScenicScore(int[][] data, int row, int column) {
		int testValue = data[row][column];

		// left
		int leftScore = 0;
		for (int i = column - 1; i + 1 != 0; i--) {
			int currentValue = data[row][i];
			leftScore++;
			if (testValue <= currentValue) {
				break;
			}
		}
		// right
		int rightScore = 0;
		for (int i = column + 1; i != data[0].length; i++) {
			int currentValue = data[row][i];
			rightScore++;
			if (testValue <= currentValue) {
				break;
			}
		}
		// up
		int upScore = 0;
		for (int i = row - 1; i + 1 != 0; i--) {
			int currentValue = data[i][column];
			upScore++;
			if (testValue <= currentValue) {
				break;
			}
		}
		// down
		int downScore = 0;
		for (int i = row + 1; i != data.length; i++) {
			int currentValue = data[i][column];
			downScore++;
			if (testValue <= currentValue) {
				break;
			}
		}

		return leftScore * rightScore * upScore * downScore;
	}

}
