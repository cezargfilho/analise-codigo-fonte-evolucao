package evolucao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

//Implementar LOC, Contagem de Classes e Métodos em um código fonte.
public class LeitorTeste {

	private static Scanner scan = new Scanner(System.in);
	private static BufferedReader codigo = null;

	private static String fileName;
	private static String localName;
	private static int numLinha;
	private static int loc;

	public static void main(String[] args) {
		inputCaminho();
		//inputFileName();
	}

	public static void inputFileName() {
		try {
			System.out.println("Digite o nome do arquivo");
			localName = scan.next();
			scan.close();
			pegarArquivo(localName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void inputCaminho() {
		scan = new Scanner(System.in);
		try {
			System.out.println("Insira um Caminho Válido");
			localName = scan.next();
			scan.close();
			pegarArquivo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pegarArquivo(String name) { // carrego arquivo arquivo
		try {
			String local = getLocalName();
			// local tente achar o arquivo
			Path path = FileSystems.getDefault().getPath(local);
			codigo = new BufferedReader(new FileReader(local)); // FileReader recebe local
			lerArquivo(); // passar nome do arquivo como parametro
			
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao Encontrado");
			e.printStackTrace();
		}
	}

	public static void pegarArquivo() { // carrego arquivo arquivo
		try {
			codigo = new BufferedReader(new FileReader(localName));//FileReader recebe local
			lerArquivo(); // passar nome do arquivo como parametro
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
			// Achando nome do arquivo
			File file = new File(localName);
			fileName = file.getName();

			System.out.println("numero metodos: " + contaMetodos(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("A quantidade de linhas é: " + contador);
	}

	public static int contaMetodos(Object obj) {
		int numeroMetodos = 0;
		try {
			numeroMetodos = obj.getClass().getDeclaredMethods().length;
			return numeroMetodos;

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Não foi possível contar o número de métodos");
		}
		return numeroMetodos;
	}

	public static String getLocalName() {
		localName = new File("").getAbsolutePath();
		return localName;
	}
}
