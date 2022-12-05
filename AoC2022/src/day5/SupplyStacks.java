package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class SupplyStacks {

	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day5\\input.txt";

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		ArrayList<Stack> stacks = new ArrayList<>();
		//make array 0 indexed
		stacks.add(null);
		ArrayList<char[]> data = new ArrayList<>();

		int height = 0; // algorithm for height
		try {
			BufferedReader heightReader = new BufferedReader(new FileReader(INPUT_LOCATION));
			String heightLine = heightReader.readLine();
			while (true) {
				if (heightLine.charAt(1) == '1') {
					heightReader.close();
					break;
				}
				height++;
				heightLine = heightReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//puts crates into stacks in arrayList
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(INPUT_LOCATION));

			for (int i = 0; i < height + 1; i++) {
				String line = reader.readLine();
				data.add(line.toCharArray());
			}

			int width = data.get(0).length;// algorithm for width
			for (int j = 1; j < width - 1; j += 4) { // loop over each row
				Stack<Character> stack = new Stack<Character>();
				for (int i = height - 1; i >= 0; i--) {
					char[] row = data.get(i);
					char ch = row[j];
					if (ch == ' ')
						break;
					stack.push(ch);
				}
				stacks.add(stack);
			}

			String line = reader.readLine();// skips blank line

			//loops over instructions moving crates around stacks
			line = reader.readLine();
			while (line != null) {
				String[] instruction = line.split(" move | from | to ");
				instruction[0] = instruction[0].substring(5, instruction[0].length());

				int amount = Integer.parseInt(instruction[0]);
				int source = Integer.parseInt(instruction[1]);
				int destination = Integer.parseInt(instruction[2]);

				for (int i = 0; i < amount; i++) {
					@SuppressWarnings("unchecked") // trust me bro
					Stack<Character> currentStack = stacks.get(source);
					char currentValue = (char) currentStack.pop();
					@SuppressWarnings("unchecked")
					Stack<Character> destStack = stacks.get(destination);
					destStack.push(currentValue);
				}
				line = reader.readLine();
			}
			//prints crates at top of stacks at end of instructions
			boolean skip = true;
			for (@SuppressWarnings("rawtypes")
			Stack stack : stacks) {
				if (skip) {
					skip = false;
					continue;
				}
				System.out.print(stack.pop());
			}
			reader.close();
		} catch (

		IOException e) {
			e.printStackTrace();
		}
	}

}
