import java.util.Scanner;

public class ValidaExpressao {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String expressao = entrada.nextLine();
	}

	private static char[] array;
	private static int top;

	public ValidaExpressao(int size) {
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
