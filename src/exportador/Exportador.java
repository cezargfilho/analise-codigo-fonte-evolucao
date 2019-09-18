package exportador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import reader.ResultadoMes;

public class Exportador {

	public Exportador() {
		// Construtor Default
	}

	public void gerarCSV(List<ResultadoMes> resultadosMeses) {
		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		PrintWriter printWriter;
		try {
			fileWriter = new FileWriter("metricas-codigo.csv");
			bufferedWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferedWriter);
			printWriter.println("MES" + "," + "LOC" + "," + "QTD. CLASSES" + "," + "QTD. METODOS");// Cabecalho do CSV
			for (ResultadoMes resultadoMes : resultadosMeses) {
				printWriter.println(resultadoMes.getNumeroMes() + "," + resultadoMes.getLoc() + ","
						+ resultadoMes.getQtdClasses() + "," + resultadoMes.getQtdMetodos());
			}
			printWriter.flush();
			printWriter.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
