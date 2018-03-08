import java.util.Arrays;
import java.util.Scanner;

class InsertionSortRecursivo {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
		insertionSortRecursivo(array, 0, 1);
	}

	public static void insertionSortRecursivo(int[] array, int leftIndex, int i) {
		if (i > array.length - 1) {
			return;
		}
		int aux = array[i];
		int j = i - 1;
		while (j >= leftIndex && aux < array[j]) {
			array[j + 1] = array[j];
			array[j] = aux;
			j--;
		}
		System.out.println(Arrays.toString(array));
		insertionSortRecursivo(array, leftIndex, i + 1);

	}

	private static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

}
