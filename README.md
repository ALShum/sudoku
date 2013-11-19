sudoku
======

sudoku solver

Solve sudoku's using two strategies: constraint propagation and search.  Sudoku's represented as a 2D array of cell objects.  Each cell tracks "constraints"; cells remember which numbers are eliminated from checking rows, columns and grids.

Cell.java - Cell object.
Sudoku.java - Sudoku object.
Solve.java - Easy puzzle that can be solved through constraints only.
Solve2.java - Difficult puzzle.
