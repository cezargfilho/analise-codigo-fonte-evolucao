package reader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exportador.Exportador;

/**
 * @author cezar-filho
 * 
 */
public class CodeReader {

	private String padraoClasse = "(.*class) * [A-Z].*[{]";
	private String padraoMetodo = "(^.*(public|private|protected|.*))*(void|int|boolean|byte|double|float|char|long|short|String).*([A-z0-9a-z]*[(].*[)]*[{])";
	private String padraoLoc = "(\\S)";
	private GeradorMetricas geradorMetricas = new GeradorMetricas();
	private List<ResultadoMes> resultadosMeses = new ArrayList<>();

	public void run(File diretorio) {
		caminhaDiretorios(diretorio);
		ordenarMeses();
		new Exportador().gerarCSV(resultadosMeses);
		imprimir();

	}

	public static boolean verificaEhMes(File[] subDiretorios) {
		if (subDiretorios != null) {
			for (int i = 0; i < subDiretorios.length; i++) {
				if (!subDiretorios[i].isFile())
					return false;
			}
			return true;

		}
		return false;
	}

	public void caminhaDiretorios(File file) {
		if (file.isDirectory()) {
			System.out.println(file.getPath());
			if (file.listFiles() != null) {
				File[] listFiles = file.listFiles();
				if (verificaEhMes(listFiles)) { // verifica se eh um mes
					ResultadoMes mes = new ResultadoMes();
					gerarMetricas(listFiles, mes); // popula o objeto
					String nomeMes = file.getName();
					int numeroMes = Integer.parseInt(nomeMes);
					System.out.println("Mes " + numeroMes + " criado");
					mes.setNumeroMes(numeroMes);
					resultadosMeses.add(mes);
				}
				for (File arquivo : listFiles) {
					caminhaDiretorios(arquivo);
				}
			}
		}
	}

	public void gerarMetricas(File[] listFiles, ResultadoMes resultado) {
		for (File file : listFiles) {
			int loc = geradorMetricas.buscarMetricas(file, padraoLoc);
			resultado.setLoc(loc);
			int metodos = geradorMetricas.buscarMetricas(file, padraoMetodo);
			resultado.setQtdMetodos(metodos);
			int classes = geradorMetricas.buscarMetricas(file, padraoClasse);
			resultado.setQtdClasses(classes);
		}
	}

	public void ordenarMeses() {
		Collections.sort(resultadosMeses);
	}

	private void imprimir() {
		for (ResultadoMes resultadoMes : resultadosMeses) {
			System.out.println(resultadoMes.getNumeroMes());
			System.out.println(resultadoMes.getLoc());
			System.out.println(resultadoMes.getQtdClasses());
			System.out.println(resultadoMes.getQtdMetodos());

		}

	}

}