import java.util.Scanner;

class IsHeap {

	private static Scanner entrada;

	public static void main(String[] args) {
		entrada = new Scanner(System.in);
		String[] heap = entrada.nextLine().split(" ");
		int[] numeros = parseInt(heap);
		System.out.println(isHeap(numeros));
	}

	public static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

	public static boolean isHeap(int[] array) {
		boolean isHeap = true;
		int root = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > root) {
				isHeap = false;
			}
		}
		return isHeap;
	}

}
