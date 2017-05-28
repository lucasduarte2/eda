import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] numeros = entrada.nextLine().split(" ");
		int[] array = parseInt(numeros);
		// int[] a = {2, 6, 9, 11, 13, 5};
		System.out.println(ordenaUltimo2(array));
	}

	// private static String ordenaUltimo(int[] numeros) {
	//
	// for (int i = 1; i < numeros.length; i++) {
	// int j = i;
	// while (j > 0 && numeros[j] < numeros[j - 1] ) {
	// int aux = numeros[j - 1];
	// numeros[j - 1] = numeros[j];
	// numeros[j] = aux;
	// j--;
	// }
	// System.out.println(Arrays.toString(numeros));
	//
	// }
	//
	// return Arrays.toString(numeros);
	// }

	private static String ordenaUltimo2(int[] numeros) {

		int j = numeros.length - 1;
		while (j > 0 && numeros[j] < numeros[j - 1]) {
			int aux = numeros[j - 1];
			numeros[j - 1] = numeros[j];
			numeros[j] = aux;
			j--;
		}

		return Arrays.toString(numeros);
	}

	public static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

}
