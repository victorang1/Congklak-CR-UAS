package com.congklak.ui;

import com.congklak.core.Computer;

public class ComputerMenu extends CharacterMenu {
	
	private int level;

	public ComputerMenu(String label, int level) {
		super(label);
		this.level = level;
	}

	@Override
	protected void createCharacter() {
		String name = Computer.generateName();
		player = new Computer(name, level);
	}

}
