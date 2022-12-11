package day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MonkeyInTheMiddle {
	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day11\\input.txt";

	public static void main(String[] args) {
		ArrayList<String> data = new ArrayList<>();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(INPUT_LOCATION));
			// preconditions for while loop
			String line = reader.readLine();

			while (line != null) {
				// read next line
				data.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MonkeyManager manager = new MonkeyManager(data.toArray(new String[data.size()]));
//		System.out.println(manager);
		for (int round = 0; round < 20; round++) {
			for (int i = 0; i < manager.monkeyList.size(); i++) {
				manager.updateMonkey(i);
			}
		}
//		System.out.println("------------------------");
//		System.out.println(manager);
//		System.out.println("------------------------");
		System.out.println(manager.getMonkeyBusiness());
	}
}
