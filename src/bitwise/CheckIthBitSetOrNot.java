/*
 * Given an input integer & i, check if the ith bit in that integer is set or not
 */

package bitwise;

import java.util.Scanner;

public class CheckIthBitSetOrNot {

	public static boolean checkIfIthBitSetOrNot(int num, int i) {
		if (num == 0) {
			return false;
		}

		int mask = 1 << i;
		if ((num & mask) > 0) {
			return true;
		} else {

			return false;
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int num, i;
		num = scan.nextInt();
		i = scan.nextInt();
		
		System.out.println("Bit at ith position set: " + checkIfIthBitSetOrNot(num, i));
		scan.close();
	}

}
