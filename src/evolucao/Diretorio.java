package evolucao;

import java.io.File;
import java.util.List;

public class Diretorio {

	public static void main(String[] args) {
		String caminho = "/home/cezarfilho/cezarfilho-workspace/codigo-fonte-analise/src/evolucao/";
		
		File file = new File(caminho);
		System.out.println(file);
		String pai = file.getParent();
		System.out.println(pai);
		
		File[] files = file.listFiles();
		for (File file2 : files) {
			System.out.println(file2.getName());
			
		}
		
		
	}

}
