import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiro {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] numeros = entrada.nextLine().split(" ");
		int[] array = parseInt(numeros);
		System.out.println(array.length);
		System.out.println(array.length - 1);
		System.out.println(ordenaUltimo2(array));
	}

	private static String ordenaUltimo2(int[] numeros) {

		int j = 1;
		while (j < numeros.length && numeros[j] < numeros[j - 1]) {
			int aux = numeros[j - 1];
			numeros[j - 1] = numeros[j];
			numeros[j] = aux;
			j++;
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
