package dp;

public class minSteps {

	public static int countStepsTo1(int n, int[] memo) {
		if (n == 1)
			return 0;
		if (memo[n] != -1)
			return memo[n];
		int res = countStepsTo1(n - 1, memo);
		if (n%2 == 0)
			res = Math.min(res, countStepsTo1(n/2, memo));
		if (n%3 == 0)
			res = Math.min(res, countStepsTo1(n/3, memo));
		memo[n] = 1 + res;
		return memo[n];

	}

	public static void main(String[] args) {

		int n = 5000;
		int[] memo = new int[n + 1];

		for (int i = 0; i < memo.length; i++)
			memo[i] = -1;

		System.out.println(countStepsTo1(n, memo));

	}

}
