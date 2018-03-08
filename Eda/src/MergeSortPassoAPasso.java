import java.util.Arrays;
import java.util.Scanner;

public class MergeSortPassoAPasso {
	
	public static void main(String[] args) {
		//Scanner entrada = new Scanner(System.in);
		//String[] numeros = entrada.nextLine().split(" ");
		//int[] array = parseInt(numeros);
		int[] a = {1, 2, 3, 4, 6, 5};
		System.out.println(sort(a, 0, a.length));
	}
	

	public static String sort(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex < 0) {
			leftIndex = 0;
		}
		if (rightIndex > array.length - 1) {
			rightIndex = array.length - 1;
		}
		if (!(array == null && leftIndex > rightIndex)) {
			mergeSort(array, leftIndex, rightIndex);
		}
		return Arrays.toString(array);

	}

	private static void mergeSort(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int average = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, average);
			mergeSort(array, average + 1, rightIndex);
			merge(array, leftIndex, average, rightIndex);
		}

	}

	private static void merge(int[] array, int leftIndex, int media, int rightIndex) {
		int[] arrayHelper = (int[]) new int[rightIndex + 1];
		for (int i = leftIndex; i <= rightIndex; i++) {
			arrayHelper[i] = array[i];
		}
		int i = leftIndex;
		int j = media + 1;
		int k = leftIndex;
		while (i < media && j <= rightIndex) {
			System.out.println(Arrays.toString(arrayHelper));
			if (arrayHelper[i] <= arrayHelper[j]) {
				array[k] = arrayHelper[i];
				i++;

			} else {
				array[k] = arrayHelper[j];
				j++;
			}
			k++;
		}
	
		while (i <= media) {
			array[k] = arrayHelper[i];
			i++;
			k++;
		}

		while (j <= rightIndex) {
			array[k] = arrayHelper[j];
			j++;
			k++;
		}
	}

}
