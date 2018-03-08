
import java.util.Scanner;

class ArvoreSimilar {

	public static void main(String[] args) {

		ArvoreSimilar novaArvore = new ArvoreSimilar();
		ArvoreSimilar novaArvore2 = new ArvoreSimilar();
		entrada = new Scanner(System.in);
		int valor = entrada.nextInt();

		for (int i = 0; i < valor; i++) {
			int arvore1 = entrada.nextInt();
			novaArvore.addNo(arvore1);
		}

		for (int i = 0; i < valor; i++) {
			int arvore2 = entrada.nextInt();
			novaArvore2.addNo(arvore2);
		}

		if (novaArvore.calcularAlturaArvore() == novaArvore2.calcularAlturaArvore()) {
			System.out.println("Arvores similares.");
		} else {
			System.out.println("Arvores com estruturas diferentes.");
		}
	}

	private NoArvoreSimilar raiz;
	private static Scanner entrada;

	public boolean isEmpty() {
		return raiz == null;
	}

	public void addNo(int valor) {
		if (isEmpty()) {
			this.raiz = new NoArvoreSimilar(valor);
		} else {
			raiz.addNo(valor);
		}
	}

	public int calcularAlturaArvore() {
		return this.raiz.calcularAlturaArvore(raiz) - 1;
	}

	public static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

}
