
import java.util.Arrays;
import java.util.Scanner;

class CountingSortPassoAPasso {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
		int tamanho = entrada.nextInt();
		countingSort(array, tamanho);

	}

	private static void countingSort(int[] array, int tamanho) {

		int tamanhoArray = tamanho + 1;
		int[] arrayTemporario = new int[tamanhoArray];

		for (int i = 0; i < array.length; i++) {
			arrayTemporario[array[i]]++;
			System.out.println(Arrays.toString(arrayTemporario));
		}

		for (int i = 1; i < tamanhoArray; i++) {
			arrayTemporario[i] += arrayTemporario[i - 1];
		}
		System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(arrayTemporario));

		int[] arrayAuxiliar = new int[array.length];

		for (int i = array.length - 1; i >= 0; i--) {
			arrayAuxiliar[--arrayTemporario[array[i]]] = array[i];
		}

		for (int i = 0; i < array.length ; i++) {
			array[i] = arrayAuxiliar[i];
		}
		System.out.println(Arrays.toString(arrayTemporario));
		System.out.println(Arrays.toString(array));
	}

	private static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}
	
	
	private static String imprimiArray(int[] array) {
		String saida = "";
		for (int i = 0; i < array.length; i++) {
			if (i < array.length - 1) {
				saida += array[i] + " ";
			} else {
				saida += array[i];
			}
		}
		return saida;
	}

}
