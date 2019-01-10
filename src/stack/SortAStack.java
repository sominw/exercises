package stack;

import java.util.Scanner;
import java.util.Stack;

public class SortAStack {
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int data = scan.nextInt();
		while (data != -1) {
			stack.push(data);
		}
		
		scan.close();
	}
}
