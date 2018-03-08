
class Function {

	int tamanho;

	public Function(int tamanho) {
		this.tamanho = tamanho;
	}

	public int hash(int key) {
		return key % this.tamanho;
	}
}