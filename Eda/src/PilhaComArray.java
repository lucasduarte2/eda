import java.util.Scanner;

class PilhaComArray {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int tamanho = entrada.nextInt();
		String opcao;
		PilhaComArray pilha = new PilhaComArray(tamanho);

		do {
			opcao = entrada.nextLine();
			String[] opcao2 = opcao.split(" ");

			if (opcao2[0].equals("push")) {
				int element = Integer.parseInt(opcao2[1]);
				push(element);
			} else if (opcao.equals("pop")) {
				pop();
			} else if (opcao.equals("peek")) {
				System.out.println(top());
			} else if (opcao.equals("print")) {
				System.out.println(pilha.toString());
			}
		} while (!opcao.equals("end"));

	}

	private static int[] array;
	private static int top;

	public PilhaComArray(int size) {
		array = new int[size];
		top = -1;
	}

	private static int top() {
		if (isEmpty()) {
			return -1;
		}
		return array[top];
	}

	private static boolean isEmpty() {
		return top == -1;
	}

	private static boolean isFull() {
		return top == array.length - 1;
	}

	private static void push(int element) {
		if (isFull()) {
			System.out.println("full");
		} else {
			top++;
			array[top] = element;

		}

	}

	private static int pop() {
		if (isEmpty()) {
			System.out.println("empty");
		} else {

			int topValue = array[top];
			top--;
			return topValue;
		}
		return -1;
	}

	public String toString() {
		String saida = "";
		for (int i = 0; i <= top; i++) {

			saida += array[i] + " ";
		}
		if (top == -1) {
			return "empty";
		}
		String s = saida.trim();
		return s;

	}
}
