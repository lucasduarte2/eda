import java.util.Scanner;

class VerificaElementosDuplicados {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
		System.out.println(verificaElementosDuplicados(array));
	}

	private static boolean verificaElementosDuplicados(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					return true;
				}
			}
		}
		return false;
	}

	private static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

}
