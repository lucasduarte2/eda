package eda;

public class LinkdList1 {
	private Node head;
	private int size;

	public LinkdList1() {
		this.head = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void add(int valor) {
		Node novoNo = new Node(valor);
		if (isEmpty()) {
			this.head = novoNo;
		} else {
			Node aux = head;
			while (aux.proximo != null) {
				aux = aux.proximo;
			}
			Node prev = aux;
			aux.proximo = novoNo;
			aux.anterior = prev;
		}
		this.size++;
	}

	public Node search(int value) {
		Node aux = head;
		while (aux != null && aux.valor != value) {
			aux = aux.proximo;
		}
		return aux;
	}

	public void removeLast() {

		if (!isEmpty()) {

			if (this.head.proximo == null)
				this.head = null;
			else {
				Node prev = null;
				Node aux = head;

				while (aux.proximo != null) {
					prev = aux;
					aux = aux.proximo;
				}

				prev.proximo = null;
			}
			this.size--;
		}
	}

	public void inverte() {

		Node atual = head.anterior;
		Node proximo = head.proximo;
		Node temp = head.proximo;
		while (proximo != null) {
			temp = temp.proximo;
			proximo.proximo = atual;
			atual = proximo;
			proximo = temp;
		}
		head.proximo = null;
		head = atual;
	}

	public String toString() {

		String out = "";
		Node aux = head;

		while (aux != null) {
			out += aux.valor + " ";
			aux = aux.proximo;
		}

		return out.trim();
	}

	public int size() {
		return this.size;
	}

	public Node getHead() {
		return this.head;
	}

	public static void main(String[] args) {
		LinkdList1 lista = new LinkdList1();
		lista.add(1);
		lista.add(2);
		System.out.println(lista.head.proximo.valor);
	}

}
