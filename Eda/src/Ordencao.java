package ElementoDuplicado;

import java.util.Arrays;
import java.util.Scanner;

class Ordencao {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] vetor = entrada.nextLine().split(" ");
		int[] array = parseInt(vetor);
		Scanner entrada2 = new Scanner(System.in);
		int maior = entrada2.nextInt();
		//int[] array = new int[] {2, 2, 4, 3, 2, 1, 5};
		counting(array, maior);
	}


	private static void counting(int[] array, int maior) {

		// array auxiliar
		int[] arrayTemporario = new int[maior + 1];

		// esse for percorre o array e cada valor encontrado ele
		// incrementa 1 no indice correspondente no arrayAuxiliar
		for (int i = 0; i < array.length; i++) {
			arrayTemporario[array[i]] += 1;
			System.out.println(impressao(arrayTemporario));
		}
		// esse for soma o valor do indice com o valor do indice anterior
		// o valor do indice2 com o anterior ate o fim do arrayAuxiliar
		for (int i = 1; i < arrayTemporario.length; i++) {
			arrayTemporario[i] += arrayTemporario[i - 1];
		}
		System.out.println("Cumulativa do vetor de contagem - " + impressao(arrayTemporario));
		System.out.println(impressao(arrayTemporario));
		int[] arrayAuxiliar = new int[array.length];
		// esse for usa o valor do array como indice no arrayauxiliar,
		// pegando o valor desse indice e usando indice -1 para inserir o
		// valor do array na exata posicao no resposta, depois decrementa
		// arrayAux[i].
		for (int i = 0; i < array.length; i++) {
			//System.out.println(i);
			arrayAuxiliar[arrayTemporario[array[i]]-1] = array[i];
			arrayTemporario[array[i]] -= 1;
		}
		
		

		// esse for copia a resposta para o vetor
		for (int i = 0; i < array.length; i++) {
			array[i] = arrayAuxiliar[i];
		}
		System.out.println(impressao(array));

	}
	private static String impressao(int[] array) {
		String saida = "";
		for (int i = 0; i < array.length; i++) {
			if(i < array.length -1) {
				saida += array[i] + " ";
			}else {
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
