import java.util.Scanner;

class InverteFrase {
	private static final String ESPACO = " ";

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String frase = entrada.nextLine();
		entrada.close();
		InverteFrase frase1 = addNaPilha(frase);
		int qtdPalavras = quantidadeDePalavras(frase);
		// imprimir a pilha
		for (int i = 0; i < qtdPalavras; i++) {
			if (i == qtdPalavras - 1) {
				System.out.print(InverteFrase.pop());
			} else {
				System.out.print(InverteFrase.pop() + " ");
			}
		}
		System.out.println("");

	}

	// metodo para adicionar a string na pilha
	private static InverteFrase addNaPilha(String frase) {
		int qtdPalavras = quantidadeDePalavras(frase);
		InverteFrase frase1 = new InverteFrase(qtdPalavras);
		String palavraAux = "";
		for (int i = 0; i < frase.length(); i++) {
			String palavra = String.valueOf(frase.charAt(i));
			if (!ESPACO.equals(palavra)) {
				palavraAux += palavra;
			} else {
				InverteFrase.push(palavraAux);
				palavraAux = "";
			}
		}
		InverteFrase.push(palavraAux);
		return frase1;
	}

	// metodo para contar a quantidade de palavras da frase
	private static int quantidadeDePalavras(String frase) {
		int qtdPalavras = 1;
		for (int i = 0; i < frase.length(); i++) {
			String teste = String.valueOf(frase.charAt(i));
			if (ESPACO.equals(teste)) {
				qtdPalavras++;
			}
		}
		return qtdPalavras;
	}

	private static String[] array;
	private static int top;

	public InverteFrase(int size) {
		array = new String[size];
		top = -1;
	}

	private static void push(String element) {
		top++;
		array[top] = element;

	}

	private static String pop() {
		String topValue = array[top];
		top--;
		return topValue;

	}

}
