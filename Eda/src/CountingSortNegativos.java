
import java.util.Arrays;
import java.util.Scanner;

class CountingSortNegativos {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		
		int[] array = parseInt(vetor);
		int maior = entrada.nextInt();
		int menor = entrada.nextInt();
		System.out.println(countingSort(array, maior, menor));

	}

	private static String countingSort(int[] array, int maior, int menor) {

		int tamanhoArray = maior - menor + 1;
		int[] arrayTemporario = new int[tamanhoArray];

		for (int i = 0; i <= array.length - 1; i++) {
			arrayTemporario[array[i] - menor]++;
			System.out.println(Arrays.toString(arrayTemporario));
		}

		for (int i = 1; i < tamanhoArray; i++) {
			arrayTemporario[i] += arrayTemporario[i - 1];
		}
		System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(arrayTemporario));

		int[] arrayAuxiliar = new int[array.length];

		for (int i = array.length - 1; i >= 0; i--) {
			arrayAuxiliar[arrayTemporario[array[i] - menor] - 1] = array[i];
			arrayTemporario[array[i] - menor]--;
		}
		System.out.println(Arrays.toString(arrayTemporario));

		for (int i = 0; i <= array.length - 1; i++) {
			array[i] = arrayAuxiliar[i];
		}
		return Arrays.toString(array);
	}

	private static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

}
