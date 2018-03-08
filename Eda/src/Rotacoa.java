import java.util.Scanner;

class Rotacoa {
	
	private static Scanner entrada;

	public static void main(String[] args) {
		entrada = new Scanner(System.in);
		String[] valor = entrada.nextLine().split(" ");
		int[] valores = parseInt(valor);
		rotacao(valores);
	}
	
	public static void rotacao(int[] array){
		int a = array[0];
		int b = array[1];
		int c = array[2];
		if(a < b && b < c){
			System.out.println("rot_esq("+ a +")");
			System.out.println("["+ b +", "+ a +", "+ c +"]");
		}else if(a > b && b > c){
			System.out.println("rot_dir("+ a +")");
			System.out.println("["+ b +", "+ c +", "+ a +"]");
		}else if(a < b && b > c){
			System.out.println("rot_dir("+ b +")");
			System.out.println("["+ a +", "+ c +", "+ b +"]");
			System.out.println("rot_esq("+ a +")");
			System.out.println("["+ c +", "+ a +", "+ b +"]");
		}else if (a > b && b < c && c < a){
			System.out.println("rot_esq("+ b +")");
			System.out.println("["+ a +", "+ c +", "+ b +"]");
			System.out.println("rot_dir("+ a +")");
			System.out.println("["+ c +", "+ b +", "+ a +"]");
		}else {
			System.out.println("balanceada");
		}
		
	}

	public static int[] parseInt(String[] array) {
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		return arrayInt;

	}


}
