package bitwise;

public class BasicOps {

	public static void main(String[] args) {

		int a = 8;
		int b = 7;
		int c = 9;

		System.out.println("Left wise shift: " + a + " << " + 1 + ": " + (a << 1));
		System.out.println("Left wise shift: " + a + " << " + 3 + ": " + (a << 3));
		System.out.println("Right wise shift: " + a + " >> " + 1 + ": " + (a >> 1));
		System.out.println("Right wise shift: " + a + " >> " + 3 + ": " + (a >> 3));

		System.out.println();

		System.out.println("Left wise shift: " + b + " << " + 1 + ": " + (b << 1));
		System.out.println("Left wise shift: " + b + " << " + 3 + ": " + (b << 3));
		System.out.println("Right wise shift: " + b + " >> " + 1 + ": " + (b >> 1));
		System.out.println("Right wise shift: " + b + " >> " + 2 + ": " + (b >> 2));
		
		System.out.println();
		
		System.out.println("OR Operator between " + a + " & " + b + " : " + (a|b));
		System.out.println("OR Operator between " + a + " & " + c + " : " + (a|c));
		System.out.println("AND Operator between " + a + " & " + b + " : " + (a&b));
		System.out.println("AND Operator between " + a + " & " + c + " : " + (a&c));
		System.out.println("XOR Operator between " + a + " & " + b + " : " + (a^b));
		System.out.println("XOR Operator between " + a + " & " + c + " : " + (a^c));
		System.out.println("Compliment of " + a + " : " + (~a));
		System.out.println("Compliment of " + b + " : " + (~b));
		System.out.println("Compliment of " + c + " : " + (~c));

	}

}
