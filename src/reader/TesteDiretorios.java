package reader;

import java.io.File;

/**
 * @author cezar-filho
 *
 */
public class TesteDiretorios {

	private static int loc;
	private static int qtdClasses;
	private static int qtdMetodos;

	private String padraoLoc = "(\\S)";
	private String padraoClasse = "(.*class) * [A-Z].*[{]";
	private String padraoMetodo = "(^.*(public|private|protected|.*))*(void|int|boolean|byte|double|float|char|long|short|String).*([A-z0-9a-z]*[(].*[)]*[{])";

	public static void main(String[] args) {
		File file = new File("C:\\Users\\cezar-filho\\Downloads\\Dataset");

		File[] files = file.listFiles();
		System.err.println(verificaDiretorioEhMes(files));

		/*
		 * System.out.println(loc); System.out.println(qtdClasses);
		 * System.out.println(qtdMetodos);
		 */
		/*
		 * System.out.println(codeReader.gerarLoc(file));
		 * System.out.println(codeReader.gerarQtdClasses(file));
		 * System.out.println(codeReader.gerarQtdMetodos(file));
		 */

	}

	public static boolean verificaDiretorioEhMes(File[] subDiretorios) {
		if (subDiretorios != null) {
			for (int i = 0; i < subDiretorios.length; i++) {
				if (!subDiretorios[i].isFile())
					return false;
			}
			return true;

		}
		return false;
	}

	public void listar(File file) {
		if (file.isDirectory()) {
			System.out.println(file.getPath());
			File[] subDiretorios = file.listFiles();
			if (subDiretorios != null) {
				for (File dir : subDiretorios) {
					listar(dir);
				}
			}
		} else if (file.isFile()) {
			System.out.println(file.getName());
			GeradorMetricas gerador = new GeradorMetricas();
			loc += gerador.buscarMetricas(file, padraoLoc);
			qtdClasses += gerador.buscarMetricas(file, padraoClasse);
			qtdMetodos += gerador.buscarMetricas(file, padraoMetodo);

		}
	}
}
