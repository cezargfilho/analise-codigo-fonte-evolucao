package exportador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exportador {

	public Exportador() {
		// Construtor Default
	}

	public void gerarCSV(int loc, int qtdClasses, int qtdMetodos) {
		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		PrintWriter printWriter;
		try {
			fileWriter = new FileWriter("metricas-codigo.csv");
			bufferedWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferedWriter);

			printWriter.println("LOC" + ";" + "QTD. CLASSES" + ";" + "QTD. METODOS");// Cabecalho do CSV
			printWriter.println(loc + ";" + qtdClasses + ";" + qtdMetodos);
			printWriter.flush();

			printWriter.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
