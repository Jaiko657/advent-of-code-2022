package day11;

public class TestMonkey {

	public static void main(String[] args) {
		String[] input = {"Monkey 1:", "  Starting items: 79, 98", "  Operation: new = old * 19", "  Test: divisible by 23", "    If true: throw to monkey 2", "    If false: throw to monkey 3" };
		Monkey m = new Monkey(input);
		System.out.println(m.id);
		System.out.println(m.items);
		System.out.println(m.operation);
		System.out.println(m.test);
		System.out.println(m.trueMonkeyInt);
		System.out.println(m.falseMonkeyInt);
		var operation = m.operation;
		System.out.println(operation.substring(10,operation.length()));
	}

}
