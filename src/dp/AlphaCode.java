package dp;

import java.util.Scanner;

public class AlphaCode {

	static int getTotalNoOfCodes(char[] ch, int n) {

		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			count[i] = 0;
			if (ch[i - 1] > '0')
				count[i] = count[i - 1];
			if (ch[i - 2] == '1' || ch[i - 2] == '2' && ch[i - 1] < '7')
				count[i] += count[i - 2];
		}

		return count[n];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();

		while (!str.equalsIgnoreCase("0")) {
			char[] ch = str.toCharArray();
			System.out.println(getTotalNoOfCodes(ch, ch.length));
			str = scan.next();
		}
		scan.close();
	}
}
