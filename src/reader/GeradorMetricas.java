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

	private int qtdLinhas;
	private int deus;
	private int chaves;

	public int buscarMetricas(File arquivo, String padrao) {
		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher;
		String linha;
		int contador = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(arquivo));
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

	public int buscarDeuses(File arquivo, String padrao, int padraoLinhas) {
		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher = null;
		String linha;
		int localizacao = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(arquivo));
			if (reader.ready()) {
				while ((linha = reader.readLine()) != null) {// ler arquivo
					matcher = pattern.matcher(linha);
					if (matcher.find()) { // achou padrao
						Object[] lista = retornaLinhasAsArray(arquivo);// transforma em array
						for (int i = 0; i < lista.length; i++) {
							if (localizacao <= i) {
								contaChaves(lista[i].toString(), padraoLinhas);
							}
						}
					}
					localizacao++;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deus;
	}

	public Object[] retornaLinhasAsArray(File arquivo) {
		List<String> linhas = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(arquivo));
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

	private int contaChaves(String line, int padraoLinhas) {
		qtdLinhas++;
		if (line.isEmpty())
			qtdLinhas--;

		if (qtdLinhas > padraoLinhas) {
			deus++;
			qtdLinhas = 0;
		}

		if (line.contains("{"))
			chaves++;

		if (line.contains("}"))
			chaves--;

		return chaves;
	}

}
