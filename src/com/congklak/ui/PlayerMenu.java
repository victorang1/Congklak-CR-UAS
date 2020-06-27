package com.congklak.ui;

import com.congklak.core.Player;

public class PlayerMenu extends CharacterMenu {
	
	public PlayerMenu(String label) {
		super(label);
	}
	
	public void createCharacter() {
		String name = "";
		do {
			System.out.print(label + " name: ");
			name = scan.nextLine();
		} while(name.length() == 0 || name.length() > 10);
		player = new Player(name);
	}
}
