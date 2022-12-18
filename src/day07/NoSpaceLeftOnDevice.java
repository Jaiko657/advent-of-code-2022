package day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NoSpaceLeftOnDevice {

	private final static String INPUT_LOCATION = "C:\\Users\\Matthew Boyd\\Documents\\code\\advent-of-code-2022\\AoC2022\\src\\day07\\input.txt";

	public static String getCdLocation(String line) {
		return line.split(" ")[2];
	}

	public static String getCommand(String line) {
		if (line.charAt(0) == '$') {
			return line.split(" ")[1];
		}
		return "";
	}


	public void printTree(Tree<String> root) {
		printTreeHelper(root, 0);
	}

	private void printTreeHelper(Tree<String> node, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("  ");
		}
		System.out.println(node.getData());

		for (Tree<String> child : node.getChildren()) {
			printTreeHelper(child, level + 1);
		}
	}

	public static void main(String[] args) {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(INPUT_LOCATION));

			// preconditions for while loop
			String line = reader.readLine();
			Tree<String> currentNode = new Tree<>("root");
			Tree<String> root = currentNode;

			while (line != null) {
				System.out.println("iterate");
				String command = getCommand(line);
				if (command.equals("cd")) {
					String location = getCdLocation(line);
					if (location == "..") {
						// go up tree
						Tree<String> parent = currentNode.getParent();
						if (parent != null) {
							currentNode = parent;
						}
					} else {
						// add child to tree
						Tree<String> child = new Tree<>("dir " + location);
						currentNode.addChild(child);
						currentNode = child;
					}
				} else {
					// ls add files to tree if they are files
					while (line.charAt(0) != '$') {
						Tree<String> child = new Tree<>(line);
						currentNode.addChild(child);
						line = reader.readLine();
					}
					continue;
				}

				// read next line
				line = reader.readLine();
			}

			System.out.println(root.getData());

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
