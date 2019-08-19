package evolucao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeitorTeste {

	private static String local = "";
	private static int numLinha;
	private static int loc;

	private static Scanner scan;
	private static BufferedReader codigo = null;

	public static void main(String[] args) {
		inputCaminho();

	}

	public static void inputCaminho() {
		scan = new Scanner(System.in);
		try {
			System.out.println("Insira um Caminho Válido");
			local = scan.next();
			scan.close();
			System.out.println(local);
			pegarArquivo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pegarArquivo() {
		try {
			codigo = new BufferedReader(new FileReader(local));
			lerArquivo();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao Encontrado");
			e.printStackTrace();
		}
	}

	public static void lerArquivo() {
		String linha;
		int contador = 0;
		try {
			while (codigo.ready()) {
				linha = codigo.readLine();
				if (linha != null) {
					System.out.println(linha);
				}
				contador++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("A quantidade de linhas é: " + contador);
	}

}
