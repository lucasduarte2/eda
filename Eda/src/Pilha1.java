public class Pilha1 {

    private int[] pilha;
    private int capacidade;
    private int topo;

    public Pilha1(int capacidade) {
        this.capacidade = capacidade;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == (capacidade - 1);
    }

    public void push(int n) {
        
        if (this.isFull())
            throw new RuntimeException("FullStackException");
        this.topo += 1;
        this.pilha[topo] = n;
    }
    
    public int pop() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        int valor_topo = this.pilha[topo];
        topo -= 1;
        return valor_topo; 
    }

    public int peek() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        return this.pilha[topo];
    }

    public int size() {
        return this.topo + 1;
    }
    
    public String toString(){
    	String saida = "";
    	for (int i = 0; i < pilha.length; i++) {
			saida += pilha[i] + " ";
		}
		return saida;
    	
    }
    
    public void inverterPilha(int posicao){
    	int j = pilha.length - 1;
    	for (int i = posicao; i < pilha.length / 2; i++) {
			int aux = pilha[i];
			int aux2 = pilha[j];
			pilha[i] = aux2;
			pilha[j] = aux;
			j--;
		}
  }

    public static void main(String[] args) {
        Pilha1 pilha = new Pilha1(5);
        assert pilha.isEmpty();
        assert !pilha.isFull();
        assert pilha.size() == 0;
    
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);
        pilha.push(5);
        System.out.println(pilha.toString());
        pilha.inverterPilha(3);
        System.out.println(pilha.toString());}
}