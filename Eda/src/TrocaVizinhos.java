import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
		System.out.println(trocaVizinhos(array));
	}
	
	private static String trocaVizinhos(int[] array) {
		for (int i = 0; i < array.length -1; i += 2){
				int aux = array[i];
				array[i] = array[i + 1];
				array[i + 1] = aux;
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
