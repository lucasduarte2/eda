import java.util.Arrays;
import java.util.Scanner;

public class ParticionaEstavel {
	

	public static void main(String[] args) {
		//Scanner entrada = new Scanner(System.in);
		//String[] numeros = entrada.nextLine().split(" ");
		//int[] array = parseInt(numeros);
		int[] a = {7, 1, 3, 8, 19, 18, 2};
		System.out.println(quickSort(a, 0, a.length -1));
	}

	private static String quickSort(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int positionPivot = particionaModicicado(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, positionPivot - 1);
			quickSort(array, positionPivot + 1, rightIndex);
		}
		return Arrays.toString(array);
	}
	
	public static int particionaModicicado(int[] array, int leftIndex, int rightIndex) {
		int pivot = array[leftIndex];
		int posicaoPivot = leftIndex;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if(array[i] < pivot) {
				posicaoPivot ++;
				int aux = array[posicaoPivot];
				array[posicaoPivot] = array[i];
				array[i] = aux;
				
			}
			
		}
		array[leftIndex] = array[posicaoPivot];
		array[posicaoPivot] = pivot;
		return posicaoPivot;
	}

	public static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}


}
