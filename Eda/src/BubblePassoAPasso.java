import java.util.Arrays;
import java.util.Scanner;

class BubblePassoAPasso {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
		bubblePassoAPasso(array);
	}

	private static void bubblePassoAPasso(int[] array) {
		boolean entrou = false;
		for (int j = 0; j <= array.length; j++) {
			boolean trocou = false;
			for (int i = 1; i < array.length; i++) {
				if (array[i - 1] > (array[i])) {
					entrou = true;
					int temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
					trocou = true;
				}
			}
			if (trocou) {
				System.out.println(imprimiArray(array));
			}
		}
		if (!entrou) {
			System.out.println(imprimiArray(array));
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
