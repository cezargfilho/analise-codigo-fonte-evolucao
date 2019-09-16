package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exportador.Exportador;

public class CodeReader {

//	private int loc;
//	private int qtdMetodos;
//	private int qtdClasses;

	public void run(File diretorio) {
		caminhaDiretorios(diretorio);
		Exportador exportador = new Exportador();
		// exportador.gerarCSV(loc, qtdClasses, qtdMetodos);

	}

	public int getQtdMetodos(File arquivo) { // Conta os metodos do arquivo
		Pattern pattern = Pattern.compile(
				"(^.*(public|private|protected|.*))*(void|int|boolean|byte|double|float|char|long|short|String).*([A-z0-9a-z]*[(].*[)]*[{])");
		BufferedReader reader;
		Matcher matcher;
		String linha;
		int qtdMetodos = 0;
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
		int qtdClasses = 0;
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
		int loc = 0;
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
		System.err.println(file.getName());
		File[] listFiles = file.listFiles();
		for (File arquivo : listFiles) {
			if (!arquivo.isDirectory()) {
				int loc = getLoc(arquivo);
				int classes = getQtdClasses(arquivo);
				int metodos = getQtdMetodos(arquivo);
				imprime(loc, classes, metodos);
			} else {
				caminhaDiretorios(arquivo);
			}
		}
	}

	public void imprime(int loc, int qtdClasses, int qtdMetodos) {
		System.out.println("LOC: " + loc);
		System.out.println("CLASSES: " + qtdClasses);
		System.out.println("METODOS: " + qtdMetodos);
		System.out.println("\n");
	}
}