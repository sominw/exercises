package stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {
	
	public static boolean checkForBalancedParenthesis(char[] ch) {
		Stack<Character> stack = new Stack<>();
		for (char c : ch) {
			if (c == '{' || c == '(' || c == '[')
				stack.push(c);
			else if (c == '}') {
				if (!stack.pop().equals(new Character('{'))) {
					return false;
				}
			}
			else if (c == ')') {
				if (!stack.pop().equals(new Character('('))) {
					return false;
				}
			}
			else if (c == ']') {
				if (!stack.pop().equals(new Character('['))) {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		char[] ch = input.toCharArray();
		System.out.println(checkForBalancedParenthesis(ch));
		scan.close();
	}
}
