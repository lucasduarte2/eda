import java.util.Arrays;
import java.util.Scanner;

class SelectionSortPassoAPasso {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
		selectionSortPassoAPasso(array);
	}

	private static void selectionSortPassoAPasso(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int menor = i;
			for (int j = menor + 1; j < array.length; j++) {
				if (array[j] < array[menor]) {
					menor = j;
				}
			}
			if (menor != i) {
				int aux = array[i];
				array[i] = array[menor];
				array[menor] = aux;
				System.out.println(Arrays.toString(array));
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
