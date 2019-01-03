package dp;

public class LIS {

	public static int calculateLIS(int[] arr, int[] solution) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i])
					continue;
				solution[i] = Math.max(solution[j] + 1, solution[i]);
			}
		}
		int best = -1;
		for (int i : solution) {
			if (best < i)
				best = i;
		}

		return best;
	}

	public static void main(String[] args) {

		int[] arr = { 5, 4, 11, 1, 16, 8 };
		int[] solution = new int[arr.length];
		for (int i = 0; i < solution.length; i++) {
			solution[i] = 1;
		}
		System.out.println(calculateLIS(arr, solution));

	}

}
