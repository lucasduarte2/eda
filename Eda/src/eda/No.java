package eda;

class No {
	private int valor;
	private No esquerda;
	private No direita;
	private No pai;

	public No(int valor) {
		this.valor = valor;
		this.esquerda = null;
		this.direita = null;
		this.pai = null;
	}

	public void addNo(int valor) {
		if (valor < this.valor) {
			if (this.esquerda == null) {
				this.esquerda = new No(valor);
				this.esquerda.pai = new No(this.valor);
			} else {
				this.esquerda.addNo(valor);
			}
		}

		if (valor > this.valor) {
			if (this.direita == null) {
				this.direita = new No(valor);
				this.direita.pai = new No(this.valor);
			} else {
				this.direita.addNo(valor);
			}
		}

	}
	public int ultimoElemento(){
		int ultimo = valor;
		if (this.direita != null) {
			ultimo = this.direita.ultimoElemento();
		}
		return ultimo;
	}
	
	public void preOrder(){
		preOrder(valor);
	}
	
	public void emOrder(){
		int ultimo = ultimoElemento();
		emOrder(ultimo);
	}
	
	public void posOrder(){
		posOrder(valor);
	}
	
	public int pai(int valor,No no){
		No noAux = pesquisaBst(valor, no);
		return noAux.pai.valor;
	}

	public void imprimeEmLargura() {
		int u= ultimoElemento();
		System.out.print(valor);
		for (int i = size(); i > 0; i--) {
			imprimieEmLarguraAux(i,u);
			
		}

	}
	
	public void imprimieEmLarguraAux(int altura, int u){
		if(calcularAlturaArvore(esquerda) == altura){
			System.out.print(" " + esquerda.valor);
		}
		if(calcularAlturaArvore(direita) == altura){
			System.out.print(" " + direita.valor);
		}
		if (esquerda != null) {
			esquerda.imprimieEmLarguraAux(altura,u);
		}
		if (direita != null) {
			direita.imprimieEmLarguraAux(altura,u);
		}
	}
	
	
	public void imprimeEmLarguraD() {
		int u= ultimoElemento();
		System.out.print(valor);
		for (int i = size(); i > 0; i--) {
			imprimieEmLarguraAuxD(i,u);
			
		}

	}
	
	public void imprimieEmLarguraAuxD(int altura, int u){
		if(calcularAlturaArvore(direita) == altura){
			System.out.print(" " + direita.valor);
		}
		if(calcularAlturaArvore(esquerda) == altura){
			System.out.print(" " + esquerda.valor);
		}
		if (direita != null) {
			direita.imprimieEmLarguraAuxD(altura,u);
		}
		if (esquerda != null) {
			esquerda.imprimieEmLarguraAuxD(altura,u);
		}
	}
	
	public void preOrder(int n) {
		if(valor == n){
			System.out.print(this.valor);
		}else{
			System.out.print(", " + this.valor);
		}
		if (this.esquerda != null) {
			this.esquerda.preOrder(n);
		}
		if (this.direita != null) {
			this.direita.preOrder(n);
		}
	}
	
	public void emOrder(int n) {
		if (this.esquerda != null) {
			this.esquerda.emOrder(n);
		}
		if(valor == n){
			System.out.print(this.valor);
		}else{
			System.out.print(this.valor + ", ");
		}
		if (this.direita != null) {
			this.direita.emOrder(n);
		}
	}
	
	
	public void posOrder(int n) {
		if (this.esquerda != null) {
			this.esquerda.posOrder(n);
		}
		if (this.direita != null) {
			this.direita.posOrder(n);
		}
		if(valor == n){
			System.out.print(this.valor);
		}else{
			System.out.print(this.valor + ", ");
		}
	}

	public int size() {
		int tamanho = 1;
		if (this.esquerda != null)
			tamanho += esquerda.size();

		if (this.direita != null)
			tamanho += direita.size();
		return tamanho;
	}

	public int soma() {

		int soma = valor;
		if (this.esquerda != null)
			soma += esquerda.soma();

		if (this.direita != null)
			soma += direita.soma();
		return soma;

	}
	
	public int somaMaiores(int valor) {
		int soma = 0;
		if(this.valor > valor) {
			soma = 1;
		}
		if (this.esquerda != null)
			soma += esquerda.somaMaiores(valor);

		if (this.direita != null)
			soma += direita.somaMaiores(valor);
		return soma;

	}

	public int contaFolhas() {
		int i = 0;
		if (this.esquerda == null && this.direita == null)
			i = 1;

		if (this.esquerda != null)
			i += esquerda.contaFolhas();

		if (this.direita != null)
			i += direita.contaFolhas();

		return i;
	}
	
	public int somaValorFolhas(){
		int soma = 0;
		if (this.esquerda == null && this.direita == null)
			soma = this.valor;
		if (this.esquerda != null)
			soma += esquerda.somaValorFolhas();

		if (this.direita != null)
			soma += direita.somaValorFolhas();

		return soma;
	}

	public int contaNosNFolhas() {
		int i = 0;
		if (this.esquerda != null || this.direita != null)
			i = 1;

		if (this.esquerda != null)
			i += esquerda.contaNosNFolhas();

		if (this.direita != null)
			i += direita.contaNosNFolhas();

		return i;
	}
	

	public void pesquisaValorMaisProximo(int valor, No no) {

		if (no.valor == valor) {
			System.out.println(valor);
		}

		if (valor < no.valor) {
			if (valor > no.esquerda.valor) {
				int valor1 = 0;
				int valor2 = 0;
				valor1 = no.valor - valor;
				valor2 = valor - no.esquerda.valor;
				if (valor1 >= valor2) {
					System.out.println(no.esquerda.valor);
					return;
				} else {
					System.out.println(no.valor);
					return;
				}
			}

			no.esquerda.pesquisaValorMaisProximo(valor, no.esquerda);
		}
		if (valor > no.valor) {
			if (valor < no.direita.valor) {
				int valor1 = 0;
				int valor2 = 0;
				valor1 = valor - no.valor;
				valor2 = no.direita.valor - valor;
				if (valor1 >= valor2) {
					System.out.println(no.direita.valor);
					return;
				} else {
					System.out.println(no.valor);
					return;
				}
			}

			no.direita.pesquisaValorMaisProximo(valor, no.direita);
		}
	}

	public void buscaBst(int valor, No no) {
		System.out.print(no.valor + " ");
		if (no.esquerda == null && no.direita == null)
			return;

		if (valor < no.valor) {
			no.esquerda.buscaBst(valor, no.esquerda);
		}
		if (valor > no.valor) {
			no.direita.buscaBst(valor, no.direita);
		}
	}

	public int calcularAlturaArvore(No no) {

		if (no == null) {
			return 0;
		}
		int altEsq = calcularAlturaArvore(no.esquerda);
		int altDir = calcularAlturaArvore(no.direita);
		if (altEsq > altDir) {
			return altEsq + 1;
		} else {
			return altDir + 1;
		}

	}

	////////////////////////////////////////////////////////////////////////////////

	private No pesquisaBst(int valor, No no) {
		if (valor == no.valor)
			return no;

		if (valor < no.valor) {
			return no.esquerda.pesquisaBst(valor, no.esquerda);
		}
		if (valor > no.valor) {
			return no.direita.pesquisaBst(valor, no.direita);
		}
		return null;

	}

}
