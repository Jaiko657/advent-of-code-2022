package day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MonkeyManager {
	public ArrayList<Monkey> monkeyList;

	public MonkeyManager(String[] input) {
		this.monkeyList = new ArrayList<Monkey>();
		for (int i = 0; i < input.length; i += 7) {
			String[] data = new String[6];
			for (int j = 0; j < 6; j++) {
				data[j] = (String) input[j + i];
			}
			addMonkey(data);
		}
	}

	public int getMonkeyBusiness() {
		ArrayList<Monkey> sortedList = new ArrayList<>(monkeyList);
		Collections.sort(sortedList, Comparator.comparing(Monkey::getInspectionCount));
		return (sortedList.get(sortedList.size() - 1).inspectionCount*sortedList.get(sortedList.size() - 2).inspectionCount);
	}
	
	//does inspecting on this monkey	
	public void updateMonkey(int monkeyId) {
		Monkey monkey = this.monkeyList.get(monkeyId);
		var items = monkey.items;
		var size = items.size();
		for(int i = size-1; i >= 0; i--) {
			updateMonkeyItem(i, monkey);
			monkeyGetsBoredWithItem(i, monkey);
			runItemTest(i, monkey);
		}
	}
	
	//divides monkey item by 3
 	private void monkeyGetsBoredWithItem(int i, Monkey monkey) {
 		var items = monkey.items;
		monkey.items.set(i, items.get(i)/3);
	}

 	//moves monkey item to correct monkey
	private void runItemTest(int i, Monkey monkey) {
 		var itemValue = monkey.items.get(i);
 		var divisorTestNumber = Integer.parseInt(monkey.test.split(" ")[2]);
 		if(itemValue%divisorTestNumber == 0) {
 			moveItem(i, monkey.id, monkey.trueMonkeyInt);
 			return;
 		}
 			moveItem(i, monkey.id, monkey.falseMonkeyInt);
	}

	//executes operation on monkey item
	private void updateMonkeyItem(int i, Monkey monkey) {
 		String operation = monkey.operation;
 		int item = monkey.items.get(i);
 		monkey.items.set(i, getNewItemValue(item, operation));
	}

	//returns value of operation(item) 
	private int getNewItemValue(int item, String operation) {
		int ret = item;
		var shortOperation = operation.substring(10,operation.length());
		int number;
		try {
			number = Integer.parseInt(shortOperation.split(" ")[1]);
		} catch(Exception e) {
			number = item;
		}
		switch(shortOperation.charAt(0)) {
		case '+':
			ret = item+number;
			break;
		case '*':
			ret = item*number;
			break;
//		case '-':
//			break;
//		case '/':
//			break;
		}
		return ret;
	}

	private void addMonkey(String[] data) {
		if (data.length != 6)
			throw new IllegalArgumentException("addMonkey string not correct");
		Monkey newMonkey = new Monkey(data);
		monkeyList.add(newMonkey);
	}

	public void moveItem(int index, int sourceMonkeyId,int destMonkeyId) {
		var sourceMonkey = monkeyList.get(sourceMonkeyId);
		var destMonkey = monkeyList.get(destMonkeyId);
		var itemValue = sourceMonkey.items.get(index);
		sourceMonkey.removeItem(index);
		destMonkey.addItem(itemValue);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Monkey m : monkeyList) {
			sb.append(m);
			sb.append("\n");
		}
		return sb.toString();
	}
}
