package bitwise;

import java.util.Scanner;

public class SwapUsingBitwiseXOR {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Integer a = scan.nextInt();
		Integer b = scan.nextInt();
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		System.out.println();

		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("After Swap: ");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		
		scan.close();
		
	}
	
}
