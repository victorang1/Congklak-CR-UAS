package com.congklak.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.congklak.ui.GameMenu;

public class Computer extends Player {
	
	protected Queue<Integer> pick = null;
	protected ArrayList<Solution> solutions = null;
	
	private String computerNames[] = new String[]{
		"Christian",
		"Frans",
		"Thomas",
		"Michael",
		"Valent",
		"Yudy"
	};
	
	public Computer(String name, int level) {
		super(name);
		pick = new LinkedList<>();
		solutions = new ArrayList<Solution>();
	}

	public Computer(String name) {
		super(name);
		pick = new LinkedList<>();
		solutions = new ArrayList<Solution>();
	}
	
	public Queue<Integer> getPick() {
		return pick;
	}
	
	public ArrayList<Solution> getSolutions()  {
//		ArrayList<Solution> currentSolution = new ArrayList<>();
//		for(Solution value: solutions) {
//			try {
//				currentSolution.add((Solution) value.clone());
//			}
//			catch(CloneNotSupportedException e) {
//				e.printStackTrace();
//			}
//		}
//		return currentSolution;
		return solutions;
	}

	public static String generateName() {
		Computer comp = new Computer("");
		return comp.computerNames[ GameMenu.rand.nextInt(comp.computerNames.length) ];
	}
	
	protected void combination(GameState state, ArrayList<Integer> picks, int maxLevel) {
		if(maxLevel <= 0) {
			addSolution(state, picks);
			return;
		}
		for (int i = 1; i <= 7; i++) {
			if(state.getComputer().getValueHole(i - 1) > 0) {
				picks.add(i);
				simulateTurn(state.clone(), picks, maxLevel);
				picks.remove(picks.size() - 1);
			}
		}
	}
	
	public void doCombination(GameState state, int maxLevel) {
		this.solutions.clear();
		combination(state, new ArrayList<>(), maxLevel);
		Collections.sort(this.solutions);
	}
	
	protected void simulateTurn(GameState state, ArrayList<Integer> picks, int maxLevel) {
		int hole = picks.get(picks.size() - 1);
		Player currentPlayer = state.getComputer();
		
		int take = 0;
		int currentIndex = hole;
		take = currentPlayer.getValueHole(hole - 1);
		currentPlayer.setValueHole(hole - 1, 0);
		
		while (take > 0) {
			++currentIndex;
			// skip opponent big hole
			if (currentPlayer == state.getPlayer() && currentIndex == GameMenu.BIG_HOLE) {
				++currentIndex;
				continue;
			}
			// change side
			if (currentIndex > GameMenu.BIG_HOLE) {
				currentPlayer = currentPlayer.getOpponent();
				currentIndex = 0;
				continue;
			}
			// drop to hole
			if (currentIndex == GameMenu.BIG_HOLE) {
				currentPlayer.setBig(currentPlayer.getBig() + 1);
			} else if (currentIndex < GameMenu.BIG_HOLE) {
				currentPlayer.setValueHole(currentIndex - 1, currentPlayer.getValueHole(currentIndex - 1) + 1);
			}
			--take;
			// take from last hole
			if (take == 0 && currentIndex < GameMenu.BIG_HOLE && currentPlayer.getValueHole(currentIndex - 1) > 1) {
				take = currentPlayer.getValueHole(currentIndex - 1);
				currentPlayer.setValueHole(currentIndex - 1, 0);
			}
		}
		
		// take from opponent
		if (currentIndex < GameMenu.BIG_HOLE && currentPlayer == state.getComputer()) {
			int indexOpponent = 7 - currentIndex;
			int takeOpponent = state.getPlayer().getValueHole(indexOpponent);
			state.getPlayer().setValueHole(indexOpponent, 0);
			state.getComputer().setValueHole(currentIndex - 1, 0);
			currentPlayer.setBig(currentPlayer.getBig() + takeOpponent + 1);
		}
		
		if (currentIndex == GameMenu.BIG_HOLE) {
			combination(state, picks, maxLevel - 1);
		} else {
			addSolution(state, picks);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void addSolution(GameState state, ArrayList<Integer> picks) {
		Solution data = new Solution((ArrayList<Integer>) picks.clone(), state.getComputer().getBig());
		solutions.add(data);
	}
}
