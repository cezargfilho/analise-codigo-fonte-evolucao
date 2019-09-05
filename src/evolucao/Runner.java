package evolucao;

import reader.CodeReader;

public class Runner {
	static String localPath = "C:\\Users\\cezar-filho\\workspaces\\ucsal-20192\\codigo-fonte-analise\\src\\evolucao\\Pessoa.java";
	static CodeReader codeReader = new CodeReader();

	public static void main(String[] args) {
		
		codeReader.run(localPath);

	}
	


}
