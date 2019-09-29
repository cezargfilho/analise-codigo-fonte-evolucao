package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cezar-filho
 *
 */
public class GeradorMetricas {

	private BufferedReader reader;
	private int qtdChaves;

	public int buscarMetricas(File arquivo, String padrao) {
		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher;
		String linha;
		int contador = 0;
		try {
			reader = new BufferedReader(new FileReader(arquivo));
			if (reader.ready()) {
				while ((linha = reader.readLine()) != null) {
					matcher = pattern.matcher(linha);
					if (matcher.find())
						contador++;
				}
			}
			reader.close();
			return contador;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contador;
	}

	public void buscarMetodosDeus(File arquivo, String padrao) {

	}

	public int buscarDeuses(File file, String padrao, int padraoLinhas) { // incompleta
		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher = null;
		String linha;
		int localizacao = 0;
		int qtdClasseDeus = 0;
		try {
			reader = new BufferedReader(new FileReader(file));
			if (reader.ready()) {
				while ((linha = reader.readLine()) != null) {
					matcher = pattern.matcher(linha);
					if (matcher.find()) {
						Object[] lista = retornaLinhasAsArray(file);
						int qtdLinhas = 0;
						for (int i = 0; i < lista.length; i++) {
							if (localizacao <= i) {
								System.out.println(lista[i].toString());
								contaChaves(lista[i].toString());
								if (lista[i].toString().equalsIgnoreCase("") || lista[i] == null) {
									qtdLinhas--;
								}
								qtdLinhas++;
								matcher = pattern.matcher(lista[i].toString());
								if (matcher.find()) {
									int linhas = qtdLinhas;
									if (linhas > padraoLinhas) {
										System.out.println("Classe Deus");
										System.out.println(linhas);
										qtdClasseDeus++;
									}
								}
							}
						}
					}
					localizacao++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qtdClasseDeus;

	}

	public Object[] retornaLinhasAsArray(File arquivo) {
		List<String> linhas = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(arquivo));
			if (reader.ready()) {
				String linha;
				while ((linha = reader.readLine()) != null) {
					linhas.add(linha);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return linhas.toArray();

	}

	private void contaChaves(String line) {
		if (line.contains("{")) {
			qtdChaves++;
		}
		if (line.contains("}")) {
			qtdChaves--;
		}
	}

}
