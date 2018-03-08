class Pilha {
	private TorreDeHanoi topo = null;
	private char nome;

	public Pilha(char nome) {
		this.nome = nome;
	}

	public void empilha(int valor) {
		TorreDeHanoi novo = new TorreDeHanoi();
		novo.setValor(valor);
		novo.setAnterior(topo);
		topo = novo;
	}

	public int desempilha() {
		int valor = topo.getValor();
		topo = topo.getAnterior();
		return valor;
	}

	public TorreDeHanoi getTopo() {
		return topo;
	}

	public char getNome() {
		return nome;
	}

}
