package com.congklak.core;

import java.util.ArrayList;

public class Solution implements Comparable<Solution>
{
	private ArrayList<Integer> picks;
	private int result;
	
	public Solution(ArrayList<Integer> picks, int result) {
		super();
		this.picks = picks;
		this.result = result;
	}
	
	public ArrayList<Integer> getPicks() {
		return picks;
	}
	
	public int getResult() {
		return result;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Solution(picks, result);
	}

	@Override
	public int compareTo(Solution o) {
		return this.result == o.result ? 0 :
			this.result < o.result ? 1 : -1;
	}
}