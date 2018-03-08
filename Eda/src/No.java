
public class No {
	
	int valor;
	No esquerda;
	No direita;
	No pai;
	
	public No(int valor){
		this.valor = valor;
		this.direita = null;
		this.esquerda = null;
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

	
}
