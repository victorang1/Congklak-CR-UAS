package com.congklak.ui;

public class Expert extends Difficulty {

	@Override
	protected int getLevel() {
		return 4;
	}

	@Override
	protected double getRatio() {
		return 0.10;
	}
}
