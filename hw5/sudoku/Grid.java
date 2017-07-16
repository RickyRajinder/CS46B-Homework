package sudoku;

import java.util.*;


public class Grid 
{
	private int[][]	values;
	private Grid grid;
	

	//
	// DON'T CHANGE THIS.
	//
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	/**
	 * Ctor used by TestGridSupplier
	 * @param rows a String array with ints (1-9) and/or '.' (empty space)
	 */
	public Grid(String[] rows)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
		{
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i=0; i<9; i++)
			{
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}
	
	/**
	 * 2nd ctor to create a grid from an int array, will be useful in next9Grids method
	 * @param an integer array that represents a sudoku board
	 */
	public Grid(int[][] board) {
        values = new int[9][9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                this.values[row][column] = board[row][column];
            }
        }
    }


	//
	// DON'T CHANGE THIS.
	//
	/**
	 * @return a string representation of the sudoku board
	 */
	public String toString()
	{
		String s = "";
		for (int j=0; j<9; j++)
		{
			for (int i=0; i<9; i++)
			{
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char)('0' + n);
			}
			s += "\n";
		}
		return s;
	}
	
	
	
	// Finds an empty member of values[][]. Returns an array list of 9 grids that look like the current grid,
	// except the empty member contains 1, 2, 3 .... 9. Returns null if the current grid is full.
	//
	// Example: if this grid = 1........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//
	// Then the returned array list would contain:
	//
	// 11.......          12.......          13.......          14.......    and so on     19.......
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	//
	/**
	 * @return an array list with 9 grids as described above
	 */
	public ArrayList<Grid> next9Grids(){		
		 if(this.isFull()) 
		        return null;
		    ArrayList<Grid> grids = new ArrayList<>();
		    outerloop: for (int row = 0; row < values.length; row++){
		    	for (int col = 0; col < values.length; col++){
		    		if (values[row][col] == 0){
		    			for (int i = 1; i <= 9; i++){
		    				values[row][col] = i;
		    				grids.add(new Grid(values));
		    			}
		    			break outerloop; // so that only 9 grids will be generated
		    		}
		    	}
		    }
		 
		 return grids;
	}
	
	
	/**
	 * 
	 * @return true if this grid is legal. A grid is legal if no row, column, diagonal, or 
 	 * 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9. Otherwise return false
	 */
	public boolean isLegal(){
		if (checkRows() && checkColumns() && checkBlocks()){
			return true;
		}
		else 
			return false;
	}
	
	/**
	 * Private method used by isLegal()
	 * @return true if all rows are legal, otherwise return false
	 */
	private boolean checkRows(){
		 boolean[] rowAppearances;
		    for(int row = 0; row < 9; row++) {
		        rowAppearances = new boolean[9];
		        for(int col = 0; col < 9; col++ ) {
		            if (values[row][col] != 0) {
		               if(rowAppearances[values[row][col] - 1])
		                   return false;
		               else
		                   rowAppearances[values[row][col] - 1] = true;
		            }
		        }
		    }
		    return true;
	}
	
	/**
	 * Private method used by isLegal()
	 * @return true if all columns are legal, otherwise return false
	 */
	private boolean checkColumns(){
		boolean[] colAppearances;
	    for(int col = 0; col < 9; col++) {
	        colAppearances = new boolean[9];
	        for(int row = 0; row < 9; row++ ) {
	            if (values[row][col] != 0) {
	               if(colAppearances[values[row][col] - 1])
	                   return false;
	               else
	                   colAppearances[values[row][col] - 1] = true;
	            }
	        }
	    }
	    return true;
	}
	
	/**
	 * Private method used by isLegal()
	 * @return true if all 3x3 blocks are legal, otherwise return false
	 */
	private boolean checkBlocks(){
		for (int block = 0; block < 9; block++) {
			boolean[] blockAppearances = new boolean[9];
			for (int row = block / 3 * 3; row < block / 3 * 3 + 3; row++) {
				for (int col = block % 3 * 3; col < block % 3 * 3 + 3; col++) {
					if (values[row][col] != 0) {
						if (blockAppearances[(values[row][col] - 1)]) {
							return false;
						}
						blockAppearances[(values[row][col] - 1)] = true;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Check if board is full
	 * @return true if every space on the board is occupied by an integer from 1-9
	 * otherwise return false
	 */
	public boolean isFull(){
	    for (int row = 0; row < values.length; row++){
	      for (int col = 0; col < values[0].length; col++){
	        if (values[row][col] < 1 || values[row][col] > 9)
	        {
	          return false;
	        }
	      }
	    }
	    return true;
	  }     

	/**
	 * Deep equals method for Grid objects
	 * Uses Array.deepEquals() method that compares two 2D arrays
	 * @return true if two Grids contain the same integers in the same exact spaces
	 */
	public boolean equals(Object x) {
		Grid other = (Grid) x;
		return Arrays.deepEquals(other.values, this.values);
	}
}
