package com.congklak.ui;

import com.congklak.core.Computer;
import com.congklak.core.EasyComputer;
import com.congklak.core.ExpertComputer;
import com.congklak.core.HardComputer;
import com.congklak.core.Hint;
import com.congklak.core.MediumComputer;
import com.congklak.core.Player;

public class PlayerMenu extends CharacterMenu {
	
	public PlayerMenu(MainMenu mainMenu, String label) {
		super(mainMenu, label);
	}
	
	public void createCharacter() {
		String name = "";
		do {
			System.out.print(label + " name: ");
			name = mainMenu.scan.nextLine();
		} while(name.length() == 0 || name.length() > 10);
		player = new Player(name);
	}
}
