package dp;

public class MinCostPath {

	public static void main(String[] args) {
		
		int[][] arr = {{1,1,1}, {4,5,2}, {7,8,9}};
		System.out.println(minCostPath(arr));

	}

	private static int minCostPath(int[][] arr) {
		// TODO Auto-generated method stub
		return minCostPath(arr,0,0);
	}

	private static int minCostPath(int[][] arr, int i, int j) {
		// TODO Auto-generated method stub
		int m = arr.length;
		int n = arr[0].length;
		
		if (i == m-1 && j == n-1) {
			return arr[i][j];
		}
		
		if (i >= m || j >=n) {
			return Integer.MAX_VALUE;
		}
		
		return arr[i][j] + Math.min(minCostPath(arr, i+1, j), Math.min(minCostPath(arr, i,j+1), minCostPath(arr, i+1, j+ 1)));
	}

	
}
