
class NoArvoreSimilar {

	private int valor;
	private NoArvoreSimilar esquerda;
	private NoArvoreSimilar direita;

	public NoArvoreSimilar(int valor) {
		this.valor = valor;
		this.esquerda = null;
		this.direita = null;
	}

	public void addNo(int valor) {
		if (valor < this.valor) {
			if (this.esquerda == null) {
				this.esquerda = new NoArvoreSimilar(valor);
			} else {
				this.esquerda.addNo(valor);
			}
		}

		if (valor > this.valor) {
			if (this.direita == null) {
				this.direita = new NoArvoreSimilar(valor);
			} else {
				this.direita.addNo(valor);
			}
		}

	}

	public int calcularAlturaArvore(NoArvoreSimilar no) {

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
