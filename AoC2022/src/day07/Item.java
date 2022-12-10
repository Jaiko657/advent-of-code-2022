package day07;

public class Item {
	public String name;
	public int size;

	Item(String name, int size) {
		this.name = name;
		this.size = size;
	}
	Item(String name) {
		this.name = name;
		this.size = 0;
	}
	public boolean isFile() {
		if(size == 0) return false;
		return true;
	}
}
