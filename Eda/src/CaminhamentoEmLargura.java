
import java.util.Scanner;

class CaminhamentoEmLargura {

	public static void main(String[] args) {

		CaminhamentoEmLargura novaArvore = new CaminhamentoEmLargura();
		entrada = new Scanner(System.in);
		String[] arvore = entrada.nextLine().split(" ");
		int[] numeros = parseInt(arvore);
		for (int i = 0; i < numeros.length; i++) {
			novaArvore.addNo(numeros[i]);
		}
		//novaArvore.imprimeEmLarguraD();
		//System.out.println("");
		novaArvore.imprimeEmLargura();
		

	}

	private NoCaminhamento raiz;
	private static Scanner entrada;

	public boolean isEmpty() {
		return raiz == null;
	}

	public void addNo(int valor) {
		if (isEmpty()) {
			this.raiz = new NoCaminhamento(valor);
		} else {
			raiz.addNo(valor);
		}
	}

	public static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}

	public void imprimeEmLargura() {
		raiz.imprimeEmLargura();
		System.out.println("");

	}

	public void imprimeEmLarguraD() {
		raiz.imprimeEmLarguraD();
		System.out.println("");

	}

}
