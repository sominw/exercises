package dp;

public class Fibonacci {
	
	static int fibItr(int n) {
		int[] store = new int[n+1];
		store[0] = 1;
		store[1] = 1;
		for (int i = 2; i <= n; i++) {
			store[i] = store[i - 1] + store[i - 2];
		}
		return store[n];
	}
	
	static int fib(int[] store, int n) {
		if (n == 0 || n == 1)
			return 1;
		if (store[n] > 0)
			return store[n];
		store[n] = fib(store, n-1) + fib(store, n-2);
		return store[n];
	}

	public static void main(String[] args) {
		int n = 5;
		int[] store = new int[11];
		System.out.println("Recursive Output: "  + fib(store, n));
		
		System.out.println("Iterative Output: " + fibItr(n));
	}
}
