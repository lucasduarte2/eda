import java.util.Scanner;

class EstatisticaEOrdem {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
		System.out.println(particiona(array, 0, array.length));
	}

	private static int particiona(int[] array, int leftIndex, int rightIndex) {
		int pivot = array[leftIndex];
		int indicePivot = 0;
		for (int i = leftIndex + 1; i < rightIndex; i++) {
			if (pivot >= array[i]) {
				int j = i;
				while (indicePivot < j) {
					swap(array, j, j - 1);
					j--;
				}
				indicePivot += 1;
			}
		}
		return indicePivot + 1;
	}

	private static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

	private static void swap(int[] array, int i, int j) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}