package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CathodeRayTube {

	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day10\\input.txt";

	public static void main(String[] args) {
		ArrayList<String> lines = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(INPUT_LOCATION));
			String line = reader.readLine();

			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		CPU cpu = new CPU(lines.toArray(new String[lines.size()]));
		int sumStrength = 0;
		for (int i = 1; i <= 220; i++) {
			int registerX = cpu.cycleClock();
			switch ((i + 1)) {
			case 20:
			case 60:
			case 100:
			case 140:
			case 180:
			case 220:
				System.out.print((i + 1) + ": " + registerX);
				int newStrength = (i + 1) * registerX;
				System.out.println(" "+newStrength);
				if (sumStrength == 0)
					sumStrength = newStrength;
				else
					sumStrength += newStrength;
			}
		}
		System.out.println(sumStrength);
	}
}
