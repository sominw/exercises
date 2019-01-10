package stack;

import java.util.Scanner;
import java.util.Stack;

public class SortAStack {

	public static Stack<Integer> sortStack(Stack<Integer> input) {
		Stack<Integer> tempStack = new Stack<>();
		while (input.size() > 0) {
			if (tempStack.size() == 0) {
				tempStack.push(input.pop());
				continue;
			}
			int curr = input.pop();
			while (!tempStack.isEmpty() && tempStack.peek() < curr) {
				input.push(tempStack.pop());
			}
			tempStack.push(curr);
		}
		return tempStack;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int data = scan.nextInt();
		while (data != -1) {
			stack.push(data);
			data = scan.nextInt();
		}
		Stack<Integer> result = sortStack(stack);
		while (!result.isEmpty()) {
			System.out.print(result.pop() + "\t");
		}
		scan.close();
	}
}
