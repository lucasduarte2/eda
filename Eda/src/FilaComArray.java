
import java.util.Scanner;

class FilaComArray {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		FilaComArray fila = new FilaComArray(entrada.nextInt());
		entrada.nextLine();
		String[] opcao;
		do {
			opcao = entrada.nextLine().split(" ");
			String opcao2 = opcao[0].toLowerCase();

			if (opcao2.equals("print")) {
				System.out.println(fila.toString());
			}
			if (opcao2.equals("add")) {
				fila.enqueue(Integer.parseInt(opcao[1]));
			}
			if (opcao2.equals("element")) {
				fila.head();
			}
			if (opcao2.equals("remove")) {
				fila.dequeue();
			}

		} while (!opcao[0].equals("end"));
	}

	private int[] array;
	private int tail;

	public FilaComArray(int size) {
		this.array = new int[size];
		this.tail = -1;
	}

	public void head() {
		if (tail == -1) {
			System.out.println("-1");
		}
		System.out.println(array[0]);
	}

	public boolean isEmpty() {
		return tail == -1;
	}

	public boolean isFull() {
		return this.tail == array.length - 1;
	}

	private void shiftLeft() {
		for (int i = 0; i <= this.tail; i++) {
			if (i < this.array.length - 1)
				this.array[i] = this.array[i + 1];
		}
		this.tail--;
	}

	public void enqueue(int element) {
		if (isFull()) {
			System.out.println("full");
		} else {
			tail++;
			array[tail] = element;
		}

	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("empty");
		} else {
			shiftLeft();
		}
	}

	public String toString() {
		String saida = "";
		for (int i = 0; i <= tail; i++) {
			saida += array[i] + " ";
		}
		if (isEmpty()) {
			return "empty";
		}
		return saida.trim();
	}
}
