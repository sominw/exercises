/*
 * Given an input, we wish to multiply 3.5 to it without using *,/ operators 
 */

package bitwise;

import java.util.Scanner;

public class MultiplyThreePointFive {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int num = scan.nextInt();

		int res = (num << 1) + num + (num >> 1);

		System.out.println("Result: " + res);

		scan.close();

	}

}
