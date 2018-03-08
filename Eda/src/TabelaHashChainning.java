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

	}

	private List<Pair>[] hashTable;

	private final Function hash;

	public TabelaHashChainning(int tamanho) {
		this.hashTable = new List[tamanho];
		this.hash = new Function(tamanho);
	}

	public void put(int key, String value) {
		int indice = hash.hash(key);
		Pair pair = new Pair(key, value);

		if (hashTable[indice] == null) {
			ArrayList<Pair> lista = new ArrayList<>();
			lista.add(pair);
			hashTable[indice] = lista;
		} else {

			if (this.hashTable[indice].contains(pair)) {
				int i = hashTable[indice].indexOf(pair);
				hashTable[indice].get(i).setValue(pair.getValue());
			} else {
				hashTable[indice].add(pair);

			}
		}
	}

	public void remove(int key) {
		int indice = hash.hash(key);
		Pair pair = new Pair(key, null);
		if (hashTable[indice] != null && hashTable[indice].contains(pair)) {
			hashTable[indice].remove(pair);
		}
	}

	private String StringArrayList(List<Pair> lista) {
		String[] aux = new String[lista.size()];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = lista.get(i).toString();
		}

		return Arrays.toString(aux);
	}

	public void printTable() {
		int tamanho = hashTable.length;
		String[] aux = new String[tamanho];
		for (int i = 0; i < tamanho; i++) {
			if (hashTable[i] != null) {
				aux[i] = StringArrayList(hashTable[i]);
			} else {
				aux[i] = "[]";
			}
		}
		System.out.println(Arrays.toString(aux));
	}

	public void printKey() {
		ArrayList<Integer> listaAux = new ArrayList<>();
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null)
				for (Pair table : hashTable[i]) {
					listaAux.add(table.getKey());
				}
		}
		int[] aux = new int[listaAux.size()];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = listaAux.get(i);
		}
		Arrays.sort(aux);
		System.out.println(Arrays.toString(aux));
	}

	public void printValue() {
		ArrayList<String> listaAux = new ArrayList<>();

		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null)
				for (Pair table : hashTable[i]) {
					listaAux.add(table.getValue());
				}
		}
		String[] aux = new String[listaAux.size()];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = listaAux.get(i);
		}
		Arrays.sort(aux);
		System.out.println(Arrays.toString(aux));
	}

}
