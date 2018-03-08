import java.util.Scanner;

class TorreDeHanoi {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int discos = entrada.nextInt();
		Pilha pinoA = new Pilha('A');
		Pilha pinoB = new Pilha('B');
		Pilha pinoC = new Pilha('C');
		for (int i = discos; i > 0; i--) {
			pinoA.empilha(i);
		}
		// Movimentações
		torreHanoi(discos, pinoA, pinoC, pinoB);
		entrada.close();
	}

	public static void torreHanoi(int discos, Pilha pinoA, Pilha pinoC, Pilha pinoB) {
		if (discos > 0) {
			torreHanoi(discos - 1, pinoA, pinoB, pinoC);
			System.out.println("Move o disco " + pinoA.getTopo().getValor() + " da haste " + pinoA.getNome()
					+ " para a haste " + pinoC.getNome());
			pinoC.empilha(pinoA.desempilha()); // Troca entre pinos
			torreHanoi(discos - 1, pinoB, pinoC, pinoA);
		}
	}

	private int valor;
	private TorreDeHanoi anterior;

	public void setAnterior(TorreDeHanoi anterior) {
		this.anterior = anterior;
	}

	public TorreDeHanoi getAnterior() {
		return anterior;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

}