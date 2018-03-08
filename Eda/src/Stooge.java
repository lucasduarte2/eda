import java.util.Arrays;
import java.util.Scanner;

class Stooge {
    public static void main(String[] args) {
    	Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
        stoogeSort(array);
        System.out.println(imprimiArray(array));
    }

    public static void stoogeSort(int[] array) {
        stoogeSort(array, 0, array.length - 1);
    }

    public static void stoogeSort(int[] array, int i, int j) {
        if (array[j] < array[i]) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        if (j - i > 1) {
            int t = (j - i + 1) / 3;
            stoogeSort(array, i, j - t);
            stoogeSort(array, i + t, j);
            stoogeSort(array, i, j - t);
        }
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
    
    private static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

}