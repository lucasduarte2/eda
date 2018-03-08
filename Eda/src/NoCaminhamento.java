
class NoCaminhamento {

	private int valor;
	private NoCaminhamento esquerda;
	private NoCaminhamento direita;

	public NoCaminhamento(int valor) {
		this.valor = valor;
		this.esquerda = null;
		this.direita = null;
	}

	public void addNo(int valor) {
		if (valor < this.valor) {
			if (this.esquerda == null) {
				this.esquerda = new NoCaminhamento(valor);
			} else {
				this.esquerda.addNo(valor);
			}
		}

		if (valor > this.valor) {
			if (this.direita == null) {
				this.direita = new NoCaminhamento(valor);
			} else {
				this.direita.addNo(valor);
			}
		}

	}

	public int ultimoElemento() {
		int ultimo = valor;
		if (this.direita != null) {
			ultimo = this.direita.ultimoElemento();
		}
		return ultimo;
	}

	public void imprimeEmLargura() {
		int u = ultimoElemento();
		System.out.print(valor);
		for (int i = size(); i > 0; i--) {
			imprimieEmLarguraAux(i, u);

		}

	}

	public void imprimieEmLarguraAux(int altura, int u) {
		if (calcularAlturaArvore(esquerda) == altura) {
			System.out.print(" " + esquerda.valor);
		}
		if (calcularAlturaArvore(direita) == altura) {
			System.out.print(" " + direita.valor);
		}
		if (esquerda != null) {
			esquerda.imprimieEmLarguraAux(altura, u);
		}
		if (direita != null) {
			direita.imprimieEmLarguraAux(altura, u);
		}
	}

	public void imprimeEmLarguraD() {
		int u = ultimoElemento();
		System.out.print(valor);
		for (int i = size(); i > 0; i--) {
			imprimieEmLarguraAuxD(i, u);

		}

	}

	public void imprimieEmLarguraAuxD(int altura, int u) {
		if (calcularAlturaArvore(direita) == altura) {
			System.out.print(" " + direita.valor);
		}
		if (calcularAlturaArvore(esquerda) == altura) {
			System.out.print(" " + esquerda.valor);
		}
		if (direita != null) {
			direita.imprimieEmLarguraAuxD(altura, u);
		}
		if (esquerda != null) {
			esquerda.imprimieEmLarguraAuxD(altura, u);
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

	public int calcularAlturaArvore(NoCaminhamento no) {

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

}
