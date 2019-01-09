package stack;

import java.util.Scanner;

public class BasicOpsImpl {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StackNode<Integer> stack = new StackNode<>();
		Integer data = scan.nextInt();
		while (data != -1) {
			stack.push(data);
			data = scan.nextInt();
		}
		Integer res = stack.pop();
		while (res != null) {
			System.out.println(res);
			res = stack.pop();
		}
		scan.close();
	}

}
