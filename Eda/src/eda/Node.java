package eda;

class Node {
	private Node left;
	private Node right;
	private Node parent;
	private Integer value;
	int valor;
	Node anterior;
	Node proximo;
	
	public Node(int value, Node left, Node right, Node parent) {
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.value = value;
	}
	
	public Node(int valor){
		this.valor = valor;
		this.proximo = null;
		this.anterior = null;
	}
	
	public Node() {
	}

	public boolean isEmpty() {
		return value == null;
	}

	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public boolean isLeaf() {
		return this.value != null && this.left.isEmpty() && this.right.isEmpty();
	}
	
}

