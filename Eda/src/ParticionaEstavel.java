import java.util.Arrays;
import java.util.Scanner;

class ParticionaEstavel {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] numeros = entrada.nextLine().split(" ");
		int[] array = parseInt(numeros);
		System.out.println(particionaModicicado(array, 0, array.length - 1));
	}

	public static String particionaModicicado(int[] array, int leftIndex, int rightIndex) {
		int pivot = array[leftIndex];
		int posicaoPivot = leftIndex;
		
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] <= pivot) {
				int aux = array[posicaoPivot];
				array[posicaoPivot] = array[i];
				array[i] = aux;
				//System.out.println(Arrays.toString(array));
				posicaoPivot++;
			}

		}
		int posicaoPivot2 = rightIndex;
		for (int i = rightIndex; i >= leftIndex; i--) {
			if (array[i] > pivot) {
				int aux = array[posicaoPivot2];
				array[posicaoPivot2] = array[i];
				array[i] = aux;
				posicaoPivot2--;
				//System.out.println(Arrays.toString(array));
			}
		}
		return Arrays.toString(array);
	}

	public static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

}
