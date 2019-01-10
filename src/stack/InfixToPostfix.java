package stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

	static int precOrder(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	public static String infixToPostfix(String exp) {
		String result = new String("");
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); ++i) {
			char c = exp.charAt(i);
			if (Character.isLetterOrDigit(c))
				result += c;

			else if (c == '(')
				stack.push(c);

			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();

				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression";
				else
					stack.pop();
			} else {
				while (!stack.isEmpty() && precOrder(c) <= precOrder(stack.peek()))
					result += stack.pop();
				stack.push(c);
			}

		}

		while (!stack.isEmpty())
			result += stack.pop();

		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String exp = scan.nextLine();
		System.out.println(infixToPostfix(exp));
		scan.close();
	}
}
