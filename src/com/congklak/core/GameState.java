package com.congklak.core;

public class GameState implements Cloneable{
	private Player player;
	private Player computer;
	
	public GameState(Player player, Player computer) {
		this.player = player;
		this.computer = computer;
		this.player.setOpponent(computer);
		this.computer.setOpponent(player);
	}
	
	public Player getPlayer() {
		return player;
	}

	public Player getComputer() {
		return computer;
	}

	public GameState clone() {
		return new GameState(player.clone(), computer.clone());
	}
}
