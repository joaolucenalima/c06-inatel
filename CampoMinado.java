import java.util.Random;
import java.util.Scanner;

public class CampoMinado {
	public static void main(String[] args) {
		boolean [][] matriz = new boolean[2][2];
		
		Random rand = new Random();
		int x = rand.nextInt(2);
		int y = rand.nextInt(2);

		matriz[x][y] = true;

		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite a posicao x que deseja acessar: ");
		int posicaoX = entrada.nextInt();
		System.out.println("Digite a posicao y que deseja acessar: ");
		int posicaoY = entrada.nextInt();

		if (matriz[posicaoX][posicaoY] == true) {
			System.out.println("Existe uma bomba nessa posição!\n");
		} else {
			System.out.println("Ufa! Não existe bomba nessa posição!\n");
		}

		for (int i = 0; i < matriz.length * 2; i++) {
			System.out.println("Digite a posicao x que deseja acessar: ");
			posicaoX = entrada.nextInt();
			System.out.println("Digite a posicao y que deseja acessar: ");
			posicaoY = entrada.nextInt();

			if (matriz[posicaoX][posicaoY] == true) {
				System.out.println("Existe uma bomba nessa posição!\n");
			} else {
				System.out.println("Ufa! Não existe bomba nessa posição!\n");
			}
		}

		entrada.close();
	}
}
