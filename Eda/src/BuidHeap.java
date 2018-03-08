import java.util.Arrays;
import java.util.Scanner;

class BuidHeap {
	private static Scanner entrada;

	public static void main(String[] args) {
		entrada = new Scanner(System.in);
		String[] heap = entrada.nextLine().split(" ");
		int[] numeros = parseInt(heap);
		BuidHeap heapSort = new BuidHeap(numeros.length);
		for (int i = 0; i < numeros.length; i++) {
			heapSort.add(numeros[i]);
		}
		System.out.println(heapSort.toString());
	}

	public static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

	private int[] heap;
	private int tail;

	public BuidHeap(int capacidade) {
		this.heap = new int[capacidade];
		this.tail = -1;
	}

	public int left(int i) {
		return (2 * i) + 1;
	}

	public int right(int i) {
		return (i + 1) * 2;
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public void add(int n) {

		if (tail < (heap.length - 1)) {

			tail += 1;
			this.heap[tail] = n;

			int i = tail;
			while (i > 0 && this.heap[parent(i)] < this.heap[i]) {
				int aux = this.heap[i];
				this.heap[i] = this.heap[parent(i)];
				this.heap[parent(i)] = aux;
				i = parent(i);
			}

		}

	}

	public String toString() {
		return Arrays.toString(this.heap);
	}

}