package evolucao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	// Resolver problema de caracteres especiais
	public static void main(String[] args) {
		String fonte = "o método é public double getSalario() na classe Empresa";
		String padrao = "public double getSalario()";
		String retorno = "";

		Pattern pattern = Pattern.compile(padrao, Pattern.LITERAL);
		Matcher matcher = pattern.matcher(fonte);

		while (matcher.find()) {
			retorno = matcher.group();
			
			System.out.println(matcher.start());
			System.out.println(retorno);

		}
	}
}
