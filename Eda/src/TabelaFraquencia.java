import java.util.Arrays;
import java.util.Scanner;

public class TabelaFraquencia {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
		System.out.println(tabela(array));

	}

	private static String tabela(int[] array) {
		int maior = maior(array) + 1;
		int[] count = new int[maior];
		for (int i = 0; i < array.length; i++) {
			count[array[i]]++;
		}
		String saida = "";
		for (int i = 0; i < array.length; i++) {
			if (count[array[i]] > 0) {
				saida += array[i] + "," + count[array[i]] + " ";
				count[array[i]] = 0;
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

	public static int maior(int[] array) {
		int maior = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}

}
