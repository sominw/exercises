package stack;

import java.util.Scanner;
import java.util.Stack;

public class MinimumBracketReversal {

	public static int requiredMinimumBracketsToBalance(String exp) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch == '{')
				stack.push(ch);
			else
				stack.pop();
		}
		if (stack.size() % 2 == 0)
			return stack.size() / 2;
		else
			return -1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String exp = scan.nextLine();
		System.out.println(requiredMinimumBracketsToBalance(exp));
		scan.close();
	}

}
