import java.util.Scanner;

class InvertePilhaSemFila {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String tamanho = entrada.nextLine();
		int size = Integer.parseInt(tamanho);
		InvertePilhaSemFila pilha = new InvertePilhaSemFila(size);

		String[] elementos = entrada.nextLine().split(" ");
		if (elementos.length == size) {
			pilha.addNAPilha(elementos);
		}

		pilha.imprimePilha();

	}

	private static void addNAPilha(String[] array1) {
		for (int i = 0; i < array1.length; i++) {
			int element = Integer.parseInt(array1[i]);
			push(element);
		}
	}

	private static int[] array;
	private static int top;

	public InvertePilhaSemFila(int size) {
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

	public static void imprimePilha() {
		for (int i = 0; i <= top; i++) {
			System.out.println(array[i]);
		}

	}

}
