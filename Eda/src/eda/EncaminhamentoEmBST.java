package eda;


import java.util.Arrays;
import java.util.Scanner;

class EncaminhamentoEmBST {
	private static Node root;
	
	public EncaminhamentoEmBST() {
		this.root = new Node();
	}
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String[] entrada = rdr.nextLine().split(" ");
		int[] numeros = criaArrayDeInteiros(entrada); 
		int valor = rdr.nextInt();
		EncaminhamentoEmBST enc = new EncaminhamentoEmBST();
		for (int i = 0; i < numeros.length; i++) {
			enc.insert(numeros[i]);
		}
		
		
		System.out.println(Arrays.toString(enc.preOrder()));
		//System.out.println(Arrays.toString(enc.order()));
		//System.out.println(Arrays.toString(enc.postOrder()));

	}
	
	
	static int[] criaArrayDeInteiros(String[] frase) {
		int[] retorno = new int[frase.length]; 
		
		for (int i = 0; i < frase.length; i++) {
			retorno[i] = Integer.parseInt(frase[i]);
		}
		
		return retorno;
	}
	
	public void insert(Integer element) {
		recursiveInsert(element, root);
	}
	
	private void recursiveInsert(Integer element, Node actualNode) {
		if (actualNode.isEmpty()) {
			actualNode.setValue(element);
			actualNode.setRight(new Node());
			actualNode.getRight().setParent(actualNode);
			actualNode.setLeft(new Node());
			actualNode.getLeft().setParent(actualNode);
		
		} else {
			if (actualNode.getValue().compareTo(element) < 0) {
				actualNode = actualNode.getRight();
				recursiveInsert(element, actualNode);
			
			} else if (actualNode.getValue().compareTo(element) > 0) {
				actualNode = actualNode.getLeft();
				recursiveInsert(element, actualNode);
			}
		}
	}
	
	
	public Integer[] preOrder() {
		Integer[] array = new Integer[(size(root))];
		if (!isEmpty()) {
			array = recursivePreOrder(root, array);
		}
		return array;
	}
	
	public Integer[] order() {
		Integer[] array = new Integer[(size(root))];
		if (!isEmpty()) {
			array = recursiveOrder(root, array);
		}
		return array;
	}
	
	public Integer[] postOrder() {
		Integer[] array = new Integer[(size(root))];
		if (!isEmpty()) {
			array = recursivePostOrder(root, array);
		}
		return array;
	}
	
	private int size(Node node) {
		int result = 0;
		if (!node.isEmpty()) {
			result = 1 + size(node.getLeft()) + size(node.getRight());
		}
		return result;
	}

	private boolean isEmpty() {
			return root == null;
	}
	
 	private void insertOnArray(Integer[] array, Integer element) {
 		int i = 0;
 		while (i < array.length) {
 			if (array[i] == null) {
 				array[i] = element;
 				break;
 			}
 			i++;
 		}
 	}

	private Integer[] recursivePreOrder(Node actualNode, Integer[] array) {
		if (actualNode.isLeaf()) {
			insertOnArray(array, actualNode.getValue());
		} else {
		
			insertOnArray(array, actualNode.getValue());
		
			if (!actualNode.getLeft().isEmpty()) {
				Node left = actualNode.getLeft();
				recursivePreOrder(left, array);
			}
			
			if (!actualNode.getRight().isEmpty()) {
				Node right = actualNode.getRight();
				recursivePreOrder(right, array);
			}
			
		
		}
		return array;
	}
	
	private Integer[] recursiveOrder(Node actualNode, Integer[] array) {
		if (actualNode.isLeaf()) {
			insertOnArray(array, actualNode.getValue());
		} else {
		
			if (!actualNode.getLeft().isEmpty()) {
				Node left = actualNode.getLeft();
				recursiveOrder(left, array);
			}
			
			insertOnArray(array, actualNode.getValue());
			
			if (!actualNode.getRight().isEmpty()) {
				Node right = actualNode.getRight();
				recursiveOrder(right, array);
			}
			
		
		}
		return array;
	}
	
	private Integer[] recursivePostOrder(Node actualNode, Integer[] array) {
		if (actualNode.isLeaf()) {
			insertOnArray(array, actualNode.getValue());
		} else {
		
			if (!actualNode.getLeft().isEmpty()) {
				Node left = actualNode.getLeft();
				recursivePostOrder(left, array);
			}
			
			if (!actualNode.getRight().isEmpty()) {
				Node right = actualNode.getRight();
				recursivePostOrder(right, array);
			}
			
			insertOnArray(array, actualNode.getValue());
		
		}
		return array;
	}
	
	
}