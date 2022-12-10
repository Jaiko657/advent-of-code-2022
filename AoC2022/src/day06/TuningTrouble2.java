package day06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TuningTrouble2 {

	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day06\\input.txt";

	public static void main(String[] args) {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(INPUT_LOCATION));
			// preconditions for while loop
			String line = reader.readLine();
			int[] rollingArray = new int[Character.MAX_VALUE];
			int rollingLength = 14;

			for(int i = 0; i<rollingLength-1; i++) {
			rollingArray[line.charAt(i)]++;
			}

			int i = 0;
			for (i = rollingLength-1; i < line.length(); i++) {
				int count = 0;
				rollingArray[line.charAt(i)]++;
				for(int j = 0; j < rollingLength;j++) {
					if (rollingArray[line.charAt(i-j)] == 1) {
						count++;
					}
				}
				if(count == rollingLength) break;
				rollingArray[line.charAt(i - (rollingLength-1))]--;
			}
			System.out.println(i+1);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
