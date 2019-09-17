package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cezar-filho
 *
 */
public class GeradorMetricas {

	public int buscarMetricas(File arquivo, String padrao) {
		Pattern pattern = Pattern.compile(padrao);
		BufferedReader reader;
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

	// implementar buscarClasseDeus e bucarMetodoDeus

}
