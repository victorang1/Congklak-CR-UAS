package com.congklak.ui;

import com.congklak.core.Hint;
import com.congklak.core.Player;

public abstract class CharacterMenu {
	
	protected Player player;
	public String label;
	protected MainMenu mainMenu = null;
	
	public CharacterMenu(MainMenu mainMenu, String label) {
		this.mainMenu = mainMenu;
		this.label = label;
		this.player = null;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public String getLabel() {
		return label;
	}
	
	protected abstract void createCharacter();
	
	public int inputHole() {
		int hole = 0;
		do {
			System.out.println(player.getName() + " turn");
			if (player.getName().equals("BINUS")) { // hidden feature
				Hint c = new Hint("");
				System.out.println("Hint: " + c.getHint(player.getOpponent(), player));
			}
			System.out.print("Choose hole(1-7): ");
			if (mainMenu.scan.hasNextInt()) {
				hole = mainMenu.scan.nextInt();
			}
			if (mainMenu.scan.hasNextLine()) {
				mainMenu.scan.nextLine();
			}
		} while(hole < 1 || hole > 7 || player.getValueHole(hole - 1) == 0);
		return hole;
	}
	
	public void printDraw() {
		System.out.println("Draw");
		System.out.print("Press enter to continue");
		mainMenu.scan.nextLine();
	}
	
	public void printWin() {
		System.out.println(player.getName() + " win");
		System.out.print("Press enter to continue");
		mainMenu.scan.nextLine();
	}; 
}
