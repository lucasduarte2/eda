package eda;

import java.util.Scanner;

import com.sun.org.apache.regexp.internal.recompile;

class ContaNosInternos {

	private No raiz;

	public boolean isEmpty() {
		return raiz == null;
	}

	public void addNo(int valor) {
		if (isEmpty()) {
			this.raiz = new No(valor);
		} else {
			raiz.addNo(valor);
		}
	}

	public void preOrder() {
		if (!isEmpty()) {
			System.out.print("[");
			
			this.raiz.preOrder();
			System.out.println("]");
		}
		
	}
	
	public void emOrder() {
		if (!isEmpty()) {
			System.out.print("[");
			
			this.raiz.emOrder();
			System.out.println("]");
		}
		
	}
	
	public void posOrder() {
		if (!isEmpty()) {
			System.out.print("[");
			
			this.raiz.posOrder();
			System.out.println("]");
		}
		
	}

	public int soma() {
		if (raiz == null) {
			return 0;
		}
		return raiz.soma();
	}

	public int size() {
		return this.raiz.size();
	}

	public int contaFolhas() {
		if (isEmpty()) {
			return 0;
		}
		return this.raiz.contaFolhas();
	}

	public int contaNosNFolhas() {
		if (isEmpty()) {
			return 0;
		}
		return this.raiz.contaNosNFolhas();
	}
	
	
	
	public void pesquisaValorMaisProximo(int valor){
		this.raiz.pesquisaValorMaisProximo(valor, raiz);
		System.out.print("[");
		this.preOrder();
		System.out.print("]");
	}
	
	public void buscaBst(int valor){
		this.raiz.buscaBst(valor, raiz);
		
	}
	public int calcularAlturaArvore(){
		return this.raiz.calcularAlturaArvore(raiz) -1;
	}
	
	public void predecessor(int valor){
		//this.raiz.predecessor2(valor, raiz);

	}
	public int somaValorFolhas(){
		return this.raiz.somaValorFolhas();
	}
	
	public static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}
	
	public void imprimeEmLargura(){
		raiz.imprimeEmLargura();
		System.out.println("");
		
	}
	public void imprimeEmLarguraD(){
		raiz.imprimeEmLarguraD();
		System.out.println("");
		
	}
	public void pai(int valor){
		System.out.println(raiz.pai(valor,raiz));
	}
	
	public int somaMaiores(int valor){
		return raiz.somaMaiores(valor);
	}
	

	public static void main(String[] args) {
		//EncaminhamentoEmBST
		//conta folhas
		//soma folhas
		//- 'quantidade_elementos_maiores_bst'
		//isHeap
		//rotacoes
//		ContaNosInternos novaArvore = new ContaNosInternos();
//		Scanner entrada = new Scanner(System.in);
//		String[] arvore = entrada.nextLine().split(" ");
//		int[] numeros = parseInt(arvore);
//		for (int i = 0; i < numeros.length; i++) {
//			novaArvore.addNo(numeros[i]);
//		}
//		novaArvore.imprimeEmLarguraD();
//		
//		
//		
//		
		
		ContaNosInternos novaArvore = new ContaNosInternos();
		ContaNosInternos novaArvore2 = new ContaNosInternos();
		Scanner entrada = new Scanner(System.in);
		int valor = entrada.nextInt();
		Integer arvore1 = null;
		Integer arvore2 = null;
		
		for (int i = 0; i < valor; i++) {
			arvore1 = entrada.nextInt();
			novaArvore.addNo(arvore1);
		}
		
		for (int i = 0; i < valor; i++) {
			arvore2 = entrada.nextInt();
			novaArvore2.addNo(arvore2);
		}
		
		if(novaArvore.calcularAlturaArvore() == novaArvore2.calcularAlturaArvore()){
			System.out.println("Arvores similares.");
		}
		else{
			System.out.println("Arvores com estruturas diferentes.");
		}
	}

}
