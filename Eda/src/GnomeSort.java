import java.util.Arrays;
import java.util.Scanner;

public class GnomeSort {
	public static void main(String[] args) {
		int[] array = new int[] { 02, 05, 06, 04, 13 };
		System.out.println(gnomeSort(array, 0, array.length - 1));
	}

	public void sort(int[] array, int leftIndex, int rightIndex) {
		gnomeSort(array, leftIndex, rightIndex);
	}

	private static String gnomeSort(int[] array, int leftIndex, int rightIndex) {

		int pivot = array[leftIndex + 1];
		int indicePivot = 1;
		while (indicePivot < rightIndex) {
			if (pivot > array[indicePivot + 1]) {
				int aux = array[indicePivot];
				array[indicePivot] = array[indicePivot + 1];
				array[indicePivot + 1] = aux;
				if (indicePivot > 0) {
					indicePivot -= 2;
				}

			}
			pivot = array[++indicePivot];
		}
		return Arrays.toString(array);
	}

	public static void swap(int[] array, int i, int j) {
		if (array == null)
			throw new IllegalArgumentException();

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
