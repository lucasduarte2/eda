import java.util.Arrays;
import java.util.Scanner;

class MoveImpostor {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
		System.out.println(moveImpostor(array));
	}

	private static String moveImpostor(int[] array) {
		int indice = indiceImpostor(array);

		while (indice > 0 && array[indice - 1] > array[indice]) {
			int aux = array[indice];
			array[indice] = array[indice - 1];
			array[indice - 1] = aux;
			indice--;

		}

		return Arrays.toString(array);
	}

	private static int indiceImpostor(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return i + 1;
			}
		}
		return 0;
	}

	private static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

}
