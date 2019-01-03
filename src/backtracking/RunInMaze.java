package backtracking;

/*
 * Input: N, followed 1s & 0s for a 2D matrix (N*N) filled row-wise
 * Output: Paths from (0,0) to (N-1, N-1) assuming they're both set to 1
 * 
 * @Author: sw
 */

public class RunInMaze {
	
	static void printPath(int[][] input, int[][] solution, int n, int x, int y) {
		if (x == n-1 && y == n-1) {
			solution[x][y] = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(solution[i][j] + "\t");
				}
				System.out.println();
			}
		}
		
		if (x < 0 || y < 0 || x >= n || y >= n || input[x][y] == 0 || solution[x][y] == 1)
			return;
		
		solution[x][y] = 1;
		
		printPath(input, solution, n, x+1, y);
		printPath(input, solution, n, x-1, y);
		printPath(input, solution, n, x, y-1);
		printPath(input, solution, n, x, y+1);
		
		solution[x][y] = 0;
	}
	
	static boolean hasPaths(int[][] input, int[][] solution, int n, int x, int y) {
		
		if (x == n-1 && y == n-1)
			return true;
		
		if (x < 0 || y < 0 || x >= n || y >= n || input[x][y] == 0 || solution[x][y] == 1)
			return false;
		
		solution[x][y] = 1;
		
		if (hasPaths(input, solution, n, x+1, y))
			return true;
		if (hasPaths(input, solution, n, x-1, y))
			return true;
		if (hasPaths(input, solution, n, x, y+1))
			return true;
		if (hasPaths(input, solution, n, x, y-1))
			return true;
		
		solution[x][y] = 0;
		return false;
	}

	public static void main(String[] args) {
		
		int n = 3;
		
		int[][] input = {{1, 0, 1},
						 {1, 0, 1},
						 {1, 1, 1}};
		
		int[][] solution = {{0, 0, 0},
				 			{0, 0, 0},
				 			{0, 0, 0}};
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(input[i][j] + "\t");
			}
			System.out.println();
		}
//		System.out.println(hasPaths(input, solution, n, 0, 0));
		System.out.println();
		printPath(input, solution, n, 0, 0);
	}

}
