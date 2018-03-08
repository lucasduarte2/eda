import java.util.Arrays;
import java.util.Scanner;

class Haore {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
		quicksort(array);
	}

	public static void quicksort(int[] array) {
		if (array == null)
			return;
		quicksort(array, 0, array.length - 1);
	}

	private static void quicksort(int[] array, int inicio, int fim) {
		if (inicio < fim) {
			int splitPoint = partition(array, inicio, fim);
			System.out.println(Arrays.toString(array));
		}
	}

	private static int partition(int[] array, int inicio, int fim) {
		int pivot = array[inicio];
		int i = inicio - 1, j = fim + 1;
		while (true) {
			do {
				i++;
			} while (array[i] < pivot);
			do {
				j--;
			} while (array[j] > pivot);
			if (i < j) {
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;

			} else {
				return j;
			}
		}

	}

	private static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

}
