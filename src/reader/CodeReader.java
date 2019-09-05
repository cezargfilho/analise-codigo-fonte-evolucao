package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeReader {

	private  File arquivo;
	private int loc;
	private int qtdMetodos;
	private int qtdClasses;

	public void main(String[] args) {
		
		setArquivo("C:\\Users\\cezar-filho\\workspaces\\ucsal-20192\\codigo-fonte-analise\\src\\evolucao\\Pessoa.java");
	}
	
	public void run(String diretorio	) {
		setArquivo(diretorio);
		System.out.println("LOC: " + getLoc());
		System.out.println("METODOS: " + getQtdMetodos());
		System.out.println("CLASSES:" + getQtdClasses());
		
	}

	public void setArquivo(String diretorio) { // contaMetodo e contaClasse consome este método
		this.arquivo = new File(diretorio);
	}

	public int getQtdMetodos() { // Conta os metodos do arquivo
		Pattern pattern = Pattern.compile(
				"(^.*(public|private|protected|.*))*(int|boolean|byte|double|float|char|long|short|.*([A-z0-9a-z]*[(].*[)]*[{]))");
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

	public int getQtdClasses() { // Conta as classes do arquivo
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

	public int getLoc() {
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

}