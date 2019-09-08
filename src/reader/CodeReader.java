package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeReader {

	private int loc;
	private int qtdMetodos;
	private int qtdClasses;

	public void run(File diretorio) {
		// usado para busca em múltiplos diretórios
		caminhaDiretorios(diretorio);
		System.out.println("METODOS: " + this.qtdMetodos);

		/*
		 * Usado para busca em um caminho apenas System.out.println("LOC: " +
		 * getLoc(diretorio)); System.out.println("METODOS: " +
		 * getQtdMetodos(diretorio)); System.out.println("CLASSES:" +
		 * getQtdClasses(diretorio));
		 */

	}

	public int getQtdMetodos(File arquivo) { // Conta os metodos do arquivo
		Pattern pattern = Pattern.compile(
				"(^.*(public|private|protected|.*))*(void|int|boolean|byte|double|float|char|long|short|String).*([A-z0-9a-z]*[(].*[)]*[{])");
		BufferedReader reader;
		Matcher matcher;
		String linha;
		try {
			reader = new BufferedReader(new FileReader(arquivo.getPath()));
			if (reader.ready()) {
				while ((linha = reader.readLine()) != null) {
					matcher = pattern.matcher(linha);
					if (matcher.find())
						qtdMetodos++;
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return qtdMetodos;
	}

	public int getQtdClasses(File arquivo) { // Conta as classes do arquivo
		Pattern pattern = Pattern.compile("(.*class) * [A-Z].*[{]");
		BufferedReader reader;
		Matcher matcher;
		String linha;
		try {
			reader = new BufferedReader(new FileReader(arquivo.getPath()));
			if (reader.ready()) {
				while ((linha = reader.readLine()) != null) {
					matcher = pattern.matcher(linha);
					if (matcher.find())
						qtdClasses++;
				}
			}
			reader.close();
			return qtdClasses;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return qtdClasses;
	}

	public int getLoc(File arquivo) {
		Pattern pattern = Pattern.compile("(\\S)"); // regra regex LOC
		BufferedReader reader;
		String linha;
		Matcher matcher;
		try {
			reader = new BufferedReader(new FileReader(arquivo.getPath()));
			while ((linha = reader.readLine()) != null) {
				matcher = pattern.matcher(linha);
				if (matcher.find())
					loc++;
			}
			reader.close();
			return loc;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return loc;
	}

	public void caminhaDiretorios(File file) {
		File[] listFiles = file.listFiles();
		for (File arquivo : listFiles) {
			if (arquivo.isDirectory()) {
				caminhaDiretorios(arquivo);
			} else {
				for (File arq : listFiles) {
					this.loc += getLoc(arq);
					this.qtdClasses += getQtdClasses(arq);
					this.qtdMetodos += getQtdMetodos(arq);

				}
			}
		}
	}

	public void imprime() {
		System.out.println("LOC: " + this.loc);
		System.out.println("CLASSES: " + this.qtdClasses);
		System.out.println("METODOS: " + this.qtdMetodos);
	}
}