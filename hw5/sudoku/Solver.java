package sudoku;

import java.util.*;


public class Solver 
{
	private Grid						problem;
	private ArrayList<Grid>				solutions;
	
	/**
	 * Ctor generates a new Solver object from a Grid object
	 * @param problem a Grid
	 */
	public Solver(Grid problem)
	{
		this.problem = problem;
	}
	
	/**
	 * Uses private method solveRecurse
	 */
	public void solve()
	{
		solutions = new ArrayList<>();
		solveRecurse(problem);
	}
	
		
	/**
	 * Used by solve() method
	 * Uses recursive backtracking to solve a sudoku board
	 * Relies on enum class Evaluation to determine actions
	 * @param grid a Grid to solve
	 */
	private void solveRecurse(Grid grid)
	{		
		Evaluation eval = evaluate(grid);
		
		if (eval == Evaluation.ABANDON)
		{
			// If board is illegal, it is abandoned, i.e. nothing is done
		}
		else if (eval == Evaluation.ACCEPT)
		{
			// If board is full and legal, it is added to solutions array list
			solutions.add(grid);
		}
		else
		{
			// If board is legal but not full, generates all 9 possible next grids. Then recursively 
			// calls solveRecurse() on those grids.
			 ArrayList<Grid> array = grid.next9Grids();
		        for (Grid g: array){
		        solveRecurse(g);
		        }
		}
	}
	
	/**
	* @return Evaluation.ABANDON if the grid is illegal. 
	* @return ACCEPT if the grid is legal and complete.
	* @return CONTINUE if the grid is legal and incomplete.
	*/
	public static Evaluation evaluate(Grid grid)
	{
		if (!grid.isLegal()){
			return Evaluation.ABANDON;
		}
		else if (grid.isLegal() && grid.isFull()){
			return Evaluation.ACCEPT;
		}
		else { 
			return Evaluation.CONTINUE;
		}
	}

	/**
	 * 
	 * @return the array list that contains the solution
	 */
	public ArrayList<Grid> getSolutions()
	{
		return solutions;
	}
	
	
	public static void main(String[] args)
	{
		Grid g = TestGridSupplier.getPuzzle2();	// or any other puzzle
		//System.out.println(g.next9Grids());
		Solver solver = new Solver(g);
		solver.solve();
		
		// Print out your solution, or test if it equals() the solution in TestGridSupplier.
		System.out.println(solver.getSolutions());
		
		System.out.println(TestGridSupplier.getReject3().equals(TestGridSupplier.getReject1()));
		System.out.println(TestGridSupplier.getPuzzle1().isLegal());
		Evaluation eval = evaluate(TestGridSupplier.getAccept());
		System.out.println(eval);

	}
}
