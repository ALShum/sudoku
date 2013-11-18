package sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Represents a single cell in a Sudoku.  Tracks cell's row number and column number in the sudoku.
 * If the cell is unsolved, stores a hashset of possible values (candidates). 
 * @author
 */
public class Cell implements Comparable<Cell>, Cloneable {
    private static final Integer[] SUDOKU_VALUES = {1,2,3,4,5,6,7,8,9};
	private int solution;
	private boolean solved;
	private int rowNum;
	private int colNum;
	private HashSet<Integer> values;
	
	public Cell(int solution, int rowNum, int colNum) throws IllegalArgumentException {
		values = new HashSet<Integer>();
		this.rowNum = rowNum;
		this.colNum = colNum;
		set(solution);
	}
	
	public boolean isSolved() {
		return solved;
	}
	
	public int get() {
		return solution;
	}
	
	public int getRowNum() {
		return rowNum;
	}
	
	public int getColNum() {
		return colNum;
	}
	
	/**
	 * Removes a candidate from the hashset
	 * @param value
	 */
	public void remove(int value) {
		values.remove(value);
		if(numCandidates() == 1) {
			solution = values.iterator().next();
			solved = true;
		}
	}
	
	public void remove(int[] values) {
		for(int i = 0; i < values.length; i++) {
			this.values.remove(values[i]);
		}		
		if(numCandidates() == 1) {
			solution = this.values.iterator().next();
			solved = true;
		}
	}
	
	public void set(int solution) throws IllegalArgumentException {
		if(solution < 0 || solution > 9) throw new IllegalArgumentException();
		if(solution == 0) {
			values.addAll(Arrays.asList(SUDOKU_VALUES));
			solved = false;
		}
		else solved = true;
		this.solution = solution;
	}
	
	public int numCandidates() {
		return values.size();
	}
	
	public int[] getCandidates() {
		Iterator<Integer> iter = values.iterator();
		int[] output = new int[values.size()];
		int i = 0;
		while(iter.hasNext()) {
			output[i] = iter.next();
			i++;
		}
		return output;
	}
	
	@Override
	public String toString() {
		return String.valueOf(solution);
	}

	@Override
	public int compareTo(Cell c) {
		if(this.numCandidates() > c.numCandidates()) return -1;
		else if(this.numCandidates() < c.numCandidates()) return 1;
		else return 0;
	}
	
	@Override
	public Object clone() {
		Cell c = new Cell(solution, rowNum, colNum);
		return (Object) c;
	}
}