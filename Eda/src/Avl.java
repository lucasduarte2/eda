import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

class Avl {

	public static void main(String[] args) {

		Integer[] array = new Integer[] { 1, 2, 3, 8, 9, 14, 15, 20 };
		int n = 20;
		int min = 0;
		int max = array.length - 1;
		System.out.println(floor(array, n));

	}

	public static Integer floor(Integer[] array, Integer x) {
		Integer floor = null;
		if (array != null && array.length > 0) {
			floor = recursiveSearchFloor(array, x, 0, array.length - 1);
		}

		return floor;
	}

	private static Integer recursiveSearchFloor(Integer[] array, Integer x, int left, int right) {
		int middle = (right + left) / 2;
		Integer result = null;

		if (middle <= right && middle >= left) {
			if (array[middle] < x) {
				if (middle + 1 <= right) { // se existir um elemento depois do
											// meio:
					if (array[middle + 1] == x) { // verifica se eh igual a x
						result = array[middle + 1];

					} else { // se nao chama recursivamente o lado direito
						result = recursiveSearchFloor(array, x, middle + 1, right);
					}

				} else {
					result = array[middle];
				}

			} else if (array[middle] > x) {
				if (middle - 1 >= left) { // se existir um elemento antes do
											// meio:
					if (array[middle - 1] == x) { // verifica se eh igual a x
						result = array[middle - 1];

					} else { // se nao chama recursivamente o lado esquerdo
						result = recursiveSearchFloor(array, x, left, middle - 1);
					}

				} else if (middle - 1 >= 0) {
					result = array[middle - 1];

				} // caso contrario nao existe x no array

			} else {
				result = array[middle];
			}
		}

		return result;
	}

	public Integer ceil(Integer[] array, Integer x) {
		Integer ceil = null;
		if (array != null && array.length > 0) {
			ceil = recursiveSearchCeil(array, x, 0, array.length - 1);
		}

		return ceil;
	}

	private Integer recursiveSearchCeil(Integer[] array, Integer x, int left, int right) {
		int middle = (right + left) / 2;
		Integer result = null;

		if (middle <= right && middle >= left) {
			if (array[middle] < x) {
				if (middle + 1 <= right) { // se existir um elemento depois do
											// meio:
					if (array[middle + 1] == x) { // verifica se eh igual a x
						result = array[middle + 1];

					} else { // se nao chama recursivamente o lado direito
						result = recursiveSearchCeil(array, x, middle + 1, right);
					}

				} else if (middle + 1 < array.length) {
					result = array[middle + 1];

				} // caso contrario nao existe x no array

			} else if (array[middle] > x) {
				if (middle - 1 >= left) { // se existir um elemento antes do
											// meio:
					if (array[middle - 1] == x) { // verifica se eh igual a x
						result = array[middle - 1];

					} else { // se nao chama recursivamente o lado esquerdo
						result = recursiveSearchCeil(array, x, left, middle - 1);
					}

				} else {
					result = array[middle];
				}

			} else {
				result = array[middle];
			}
		}

		return result;
	}

}


































/*






import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TabelaHashChainning {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int tamanho = Integer.parseInt(entrada[0]);
		TabelaHashChainning tabelaHash = new TabelaHashChainning(tamanho);

		do {
			entrada = sc.nextLine().split(" ");

			if (entrada[0].equalsIgnoreCase("put")) {
				int key = Integer.parseInt(entrada[1]);
				tabelaHash.put(key, entrada[2]);
				tabelaHash.printTable();
			}

			if (entrada[0].equalsIgnoreCase("remove")) {
				int key2 = Integer.parseInt(entrada[1]);
				tabelaHash.remove(key2);
				tabelaHash.printTable();
			}

			if (entrada[0].equalsIgnoreCase("keys")) {
				tabelaHash.printKey();
			}

			if (entrada[0].equalsIgnoreCase("values")) {
				tabelaHash.printValue();
			}

		} while (!entrada[0].equalsIgnoreCase("end"));
		entrada.clone();

	}

	private List<Table>[] hashTable;

	private final Function hash;

	@SuppressWarnings("unchecked")
	public TabelaHashChainning(int tamamhoTabela) {
		this.hashTable = new List[tamamhoTabela];
		this.hash = new Function(tamamhoTabela);
	}

	public void put(int key, String value) {
		int indice = hash.hash(key);
		Table novaTabela = new Table(key, value);

		if (this.hashTable[indice] == null) {
			List<Table> list = new ArrayList<>();
			list.add(novaTabela);
			this.hashTable[indice] = list;
		} else {

			if (this.hashTable[indice].contains(novaTabela)) {
				int i = this.hashTable[indice].indexOf(novaTabela);
				this.hashTable[indice].get(i).setValue(novaTabela.getValue());
			} else {
				this.hashTable[indice].add(novaTabela);

			}
		}
	}

	public void remove(int key) {
		int indice = hash.hash(key);
		Table table = new Table(key, null);
		if (this.hashTable[indice].contains(table)) {
			this.hashTable[indice].remove(table);
		}
	}

	private String StringArrayList(List<Table> list) {
		String[] aux = new String[list.size()];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = list.get(i).toString();
		}

		return Arrays.toString(aux);
	}

	public void printTable() {
		int tamanho = this.hashTable.length;
		String[] aux = new String[tamanho];
		for (int i = 0; i < tamanho; i++) {
			if (this.hashTable[i] != null) {
				aux[i] = StringArrayList(this.hashTable[i]);
			} else {
				aux[i] = "[]";
			}
		}
		System.out.println(Arrays.toString(aux));
	}

	public void printKey() {
		List<Integer> auxList = new ArrayList<>();
		for (int i = 0; i < this.hashTable.length; i++) {
			if (this.hashTable[i] != null)
				for (Table table : this.hashTable[i]) {
					auxList.add(table.getKey());
				}
		}
		int[] aux = new int[auxList.size()];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = auxList.get(i);
		}
		Arrays.sort(aux);
		System.out.println(Arrays.toString(aux));
	}

	private void printValue() {
		List<String> auxList = new ArrayList<>();

		for (int i = 0; i < this.hashTable.length; i++) {
			if (this.hashTable[i] != null)
				for (Table table : this.hashTable[i]) {
					auxList.add(table.getValue());
				}
		}
		String[] aux = new String[auxList.size()];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = auxList.get(i);
		}
		Arrays.sort(aux);
		System.out.println(Arrays.toString(aux));
	}

}
*/
