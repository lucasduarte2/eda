import java.util.Arrays;
import java.util.Scanner;

public class Estudo {
	
	public static void main(String[] args) {
		int[] vetor = new int[10];
		int j = 0;
		for (int i = vetor.length -1; i > 0; i--) {
			vetor[j] = i;
			j++;
		}	
		
//		String palavra = "lucas";
//		for (int i=0; i<palavra.length(); i++) {
//			   char c = palavra.charAt(i);
//			   System.out.println(c);
//		}
//		
		
		//ordenacaoS(vetor);
		quickSort(vetor,0,vetor.length -1);
		//System.out.println(busca(vetor, 3));
		//System.out.println(quickSelect(vetor,7));
		System.out.println(Arrays.toString(vetor));
		
	}
	private static int busca(int[] array, int valor) {
		return buscaBinariaRecursiva(array,valor, 0, array.length - 1);
	}

	private static int buscaBinariaRecursiva(int[] array,int valor, int inicio, int fim) {
		int media = (fim + inicio) / 2;
		if (inicio > fim)
			return -1;
		else if(array[media] == valor) 
			return valor;
		else if (array[media] < valor)
			return buscaBinariaRecursiva(array,valor, media+1, fim);
		else
			return buscaBinariaRecursiva(array,valor, inicio, media-1);
	}
	
	public static void ordenacaoB(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 1; j < vetor.length; j++) {
				if(vetor[j - 1] > vetor[j]) {
					swap(vetor, j, j-1);
				}
			}
		}
		
	}
	

	public static void ordenacaoS(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			int menor = vetor[i];
			int indexMenor = i;
			for (int j = i + 1; j < vetor.length; j++) {
				if(vetor[j] < menor){
					menor = vetor[j];
					indexMenor = j;
				}
			}
			swap(vetor, i, indexMenor);
		}
	}
	
	

	public static void ordenacaoI(int[] vetor) {
		for (int i = 1; i < vetor.length; i++) {
				int aux = vetor[i];
				int j = i - 1;
				while (j >= 0 && aux < (vetor[j])) {
					vetor[j + 1] = vetor[j];
					vetor[j] = aux;
					j--;
				}
			}
	}
	public static int quickSelect(int[] array, int k) {
		if (array == null || array.length == 0 || k > array.length || k < 1)
			return -1;
		return quickSelect(array, 0, array.length - 1, k);
	}

	private static int quickSelect(int[] v, int ini, int fim, int k) {
		int i = ini;
		int pivot = v[ini];
		for (int j = ini + 1; j <= fim; j++) {
			if (v[j] < (pivot)) {
				i++;
				swap(v, i, j);
			}
		}
		swap(v, i, ini);
		if (k == i + 1) {
			return pivot;
		} else if (k < i + 1) {
			return quickSelect(v, ini, i - 1, k);
		} else {
			return quickSelect(v, i + 1, fim, k);
		}

	}
	
	public static void swap(int[] array, int i, int j) {
		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	private static void quickSort(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int positionPivot = particiona(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, positionPivot - 1);
			quickSort(array, positionPivot + 1, rightIndex);
		}
	}

	private static int particiona(int[] array, int leftIndex, int rightIndex) {
		int pivor = array[leftIndex];
		int positionPivot = leftIndex;
		for (int j = positionPivot + 1; j <= rightIndex; j++) {
			if (array[j] < (pivor)) {
				positionPivot++;
				swap(array, positionPivot, j);
			}
		}
		swap(array, leftIndex, positionPivot);
		return positionPivot;
	}



}
