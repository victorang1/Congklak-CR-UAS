package com.congklak.ui;

public abstract class Mode {
	
	private String playerOneLabel;
	private String playerTwoLabel;
	
	protected abstract String getPlayerOneLabel();
	protected abstract String getPlayerTwoLabel();
}