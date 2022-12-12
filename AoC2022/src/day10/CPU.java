package day10;

import java.util.ArrayList;

public class CPU {
	public String[] instructions;
	public int currentInstruction;
	public int clockCycle;
	public int registerX;
	public ArrayList<Integer> queue;

	public CPU(String[] instructions) {
		this.instructions = instructions;
		this.currentInstruction = 0;
		this.clockCycle = 0;
		this.registerX = 1;
		this.queue = new ArrayList<Integer>();
	}

	public int cycleClock() {
		if (atSprite(registerX, this.clockCycle%40))
			System.out.print("#");
		else
			System.out.print(".");
		if (((this.clockCycle+1) % 40) == 0)
			System.out.println();
		if (queue.size() == 0 && currentInstruction < instructions.length) {
			readInstruction(instructions[currentInstruction++]);
		}
		this.registerX += this.queue.remove(0);
		this.clockCycle++;
		return this.registerX;
	}

	private void readInstruction(String instruction) {
		if (instruction.equals("noop")) {
			noap();
		} else {
			add(Integer.parseInt(instruction.split(" ")[1]));
		}
		;
	}

	public void noap() {
		this.queue.add(0);
	}

	public void add(int x) {
		this.queue.add(0);
		this.queue.add(x);
	}

	public boolean atSprite(int spritePos, int pixelPos) {
		if (spritePos == pixelPos)
			return true;
		if (spritePos - 1 == pixelPos)
			return true;
		if (spritePos + 1 == pixelPos)
			return true;
		return false;
	}
}
