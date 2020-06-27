package com.congklak.ui;

import java.util.Scanner;

import com.congklak.core.Hint;
import com.congklak.core.Player;

public abstract class CharacterMenu {
	
	protected Player player;
	public String label;
	protected Scanner scan = new Scanner(System.in);
	
	public CharacterMenu(String label) {
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
			if (scan.hasNextInt()) {
				hole = scan.nextInt();
			}
			if (scan.hasNextLine()) {
				scan.nextLine();
			}
		} while(hole < 1 || hole > 7 || player.getValueHole(hole - 1) == 0);
		return hole;
	}
	
	public void printDraw() {
		System.out.println("Draw");
		System.out.print("Press enter to continue");
		scan.nextLine();
	}
	
	public void printWin() {
		System.out.println(player.getName() + " win");
		System.out.print("Press enter to continue");
		scan.nextLine();
	}; 
}
