package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeReader {

	private BufferedReader codigo = null;
	private String localPath = "";
	private Class<?> classe;

	public CodeReader(String localPath, Class<?> classe) {
		super();
		this.localPath = localPath;
		this.classe = classe;
	}

	public void run() {
		try {
			codigo = new BufferedReader(new FileReader(localPath));// FileReader recebe local
			readFile();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao Encontrado");
		}
	}

	public void readFile() {
		int loc = 0;
		try {
			while (codigo.ready()) {
				codigo.readLine();
				loc++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("O LOC é: " + loc);

		System.out.println("Numero de metodos: " + countMethods(classe));
		System.out.println("Numero de classes: " + countClasses(classe));
	}

	public int countMethods(Class<?> obj) {
		int numeroMetodos = obj.getDeclaredMethods().length;
		return numeroMetodos;
	}

	public int countClasses(Class<?> obj) {
		// Conta as classes do Objeto + a prorpia classe
		int qtdClasses = (obj.getDeclaredClasses().length) + 1;
		return qtdClasses;
	}
	/*
	 * public void inputPath() { Scanner scan = new Scanner(System.in); try {
	 * System.out.println("Insira um Caminho Válido"); localPath = scan.next();
	 * scan.close(); getFileByPath(localPath); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */
}