import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] numeros = entrada.nextLine().split(" ");
		int[] array = parseInt(numeros);
		selectionSort(array, 0, array.length - 1);
	}

	public static void selectionSort(int[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {
			int smaller = leftIndex;
			for (int j = smaller + 1; j <= rightIndex; j++) {
				if (array[smaller] > array[j]) {
					smaller = j;
				}
			}

			int aux = array[leftIndex];
			array[leftIndex] = array[smaller];
			array[smaller] = aux;
			System.out.println(Arrays.toString(array));
			selectionSort(array, leftIndex + 1, rightIndex);

		}

	}

	public static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

}
