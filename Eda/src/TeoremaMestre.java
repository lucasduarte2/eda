import java.util.Scanner;

class TeoremaMestre {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] numeros = entrada.nextLine().split(" ");
		int numero1 = Integer.parseInt(numeros[0]);
		int numero2 = Integer.parseInt(numeros[1]);
		int numero3 = Integer.parseInt(numeros[2]);
		System.out.println(mestre(numero1, numero2, numero3));
	}

	public static String mestre(int a, int b, int ord) {
		String saida = "";
		int logaritmo = log(b, a);
		if (a >= 1 && b > 1 && ord >= 0) {

			if (ord < logaritmo) {
				saida = "T(n) = theta(n**" + ord + ")";
			} else if (ord == logaritmo) {
				saida = "T(n) = theta(n**" + ord + " * log n)";
			} else {
				saida = "T(n) = theta(" + ord + ")";
			}
			
		}
		return saida;
	}

	public static int log(int base, int log) {
		if (log / base > 0) {
			return 1 + log(base, log / base);

		} else {
			return 0;
		}

	}

}
