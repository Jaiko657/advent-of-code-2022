package day11;

import java.util.ArrayList;

public class Monkey {

	public int id;
	public ArrayList<Integer> items;
	public String operation;
	public String test;
	public int trueMonkeyInt;
	public int falseMonkeyInt;
	public int inspectionCount = 0;

	public Monkey(String[] input) {
		String id = input[0].split(" ")[1];
		String id2 = id.substring(0, id.length() - 1);
		this.id = Integer.parseInt(id2);
		ArrayList<Integer> items = new ArrayList<Integer>();
		String stringItems = input[1].substring(18, input[1].length());
		String[] arrayItems = stringItems.split(", ");
		for (String item : arrayItems) {
			items.add(Integer.parseInt(item));
		}
		this.items = items;
		this.operation = input[2].substring(13, input[2].length());
		this.test = input[3].substring(8, input[3].length());
		String trueMonkey = input[4].substring(29, input[4].length());
		String falseMonkey = input[5].substring(30, input[5].length());
		this.trueMonkeyInt = Integer.parseInt(trueMonkey);
		this.falseMonkeyInt = Integer.parseInt(falseMonkey);
	}

	public void addItem(int item) {
		this.items.add(item);
	}
	public void removeItem(int index) {
		this.items.remove(index);
		inspectionCount++;
	}
	public int getInspectionCount() {
		return this.inspectionCount;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append("\n");
		sb.append(this.items);
		sb.append("\n");
		sb.append(this.operation);
		sb.append("\n");
		sb.append(this.test);
		sb.append("\n");
		sb.append(this.trueMonkeyInt);
		sb.append("\n");
		sb.append(this.falseMonkeyInt);
		sb.append("\n");
		return sb.toString();
	}
}
