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
	
	private String padraoFunction = "(fn).*[A-Z]*[(].*[)]";
	private String padraoIMPL = "(impl).*[A-Z].*[{]";
	private String padraoStruct = "(struct).*[A-Z].*[{]";
	private String padraoLoc = "(\\S)";
	private List<ResultadoMes> resultadosMeses = new ArrayList<>();

	public void run(File diretorio) {
		caminhaDiretorios(diretorio);
		ordenarMeses();
		new Exportador().gerarCSV(resultadosMeses);
		// imprimir();
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
			int loc = new GeradorMetricas().buscarMetricas(file, padraoLoc);
			resultado.setLoc(loc);
			int impl = new GeradorMetricas().buscarMetricas(file, padraoIMPL);
			resultado.setQtdIMPL(impl);
			int function = new GeradorMetricas().buscarMetricas(file, padraoFunction);
			resultado.setQtdFunction(function);
			int struct = new GeradorMetricas().buscarMetricas(file, padraoStruct);
			resultado.setQtdStruct(struct);

		}
	}

	public void ordenarMeses() {
		Collections.sort(resultadosMeses);
	}

	private void imprimir() {
		for (ResultadoMes resultadoMes : resultadosMeses) {
			System.out.println("Numero Mes: " + resultadoMes.getNumeroMes());
			System.out.println("LOC: " + resultadoMes.getLoc());
			System.out.println("FUNCTIONS: " + resultadoMes.getQtdFunction());
			System.out.println("STRUTCS: " + resultadoMes.getQtdStruct());
			System.out.println("IMPLS: " + resultadoMes.getQtdIMPL());
			System.out.println("________________ACABOU O MES________________");
		}
	}

}