package com.congklak.ui;

import com.congklak.core.Computer;
import com.congklak.core.EasyComputer;
import com.congklak.core.ExpertComputer;
import com.congklak.core.HardComputer;
import com.congklak.core.MediumComputer;

public class ComputerMenu extends CharacterMenu {
	
	private int level;

	public ComputerMenu(MainMenu mainMenu, String label, int level) {
		super(mainMenu, label);
		this.level = level;
	}

	@Override
	protected void createCharacter() {
		String name = Computer.generateName();
		switch (level) {
			case GameMenu.EASY:
				player = new EasyComputer(name);
				break;
			case GameMenu.MEDIUM:
				player = new MediumComputer(name);
				break;
			case GameMenu.HARD:
				player = new HardComputer(name);
				break;
			case GameMenu.EXPERT:
				player = new ExpertComputer(name);
				break;
		}
	}

}
