package sudoku;

public class Solve {
    public static void main(String[] args) {
		int[][] puzzle = 
	   {{0,0,3,0,2,0,6,0,0},
		{9,0,0,3,0,5,0,0,1},
		{0,0,1,8,0,6,4,0,0},
		{0,0,8,1,0,2,9,0,0},
		{7,0,0,0,0,0,0,0,8},
		{0,0,6,7,0,8,2,0,0},
		{0,0,2,6,0,9,5,0,0},
		{8,0,0,2,0,3,0,0,9},
		{0,0,5,0,1,0,3,0,0}};
		
		Sudoku s = new Sudoku(puzzle);
		System.out.println(s.numUnsolved());
		s.constraintPropagation();
		System.out.println(s);
		System.out.println(s.numUnsolved());
	}
}
