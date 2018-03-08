import java.util.Scanner;

class Parenteses {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String string = entrada.nextLine();

		Parenteses pa = new Parenteses(string.length());
		for (int i = 0; i < string.length(); i++) {
			pa.push(string.charAt(i));
		}
		if (pa.isEmpty()) {
			System.out.println("S");
		} else {
			System.out.println("N");
		}

	}

	private static char[] array;
	private static int top;

	public Parenteses(int size) {
		array = new char[size];
		top = -1;
	}

	private static char top() {
		if (isEmpty()) {
			return (Character) null;
		}
		return array[top];
	}

	private static boolean isEmpty() {
		return top == -1;
	}

	private static boolean isFull() {
		return top == array.length - 1;
	}

	private static void push(char element) {
		if (isFull()) {
			System.out.println("full");
		} else {
			top++;
			array[top] = element;
			for (int i = 1; i <= top; i++) {

				if (array[i - 1] == '(' && array[i] == ')') {
					pop();
					pop();
				}
			}
		}

	}

	private static char pop() {
		if (isEmpty()) {
			System.out.println("empty");
		} else {

			char topValue = array[top];
			top--;
			return topValue;
		}
		return (Character) null;
	}

}
