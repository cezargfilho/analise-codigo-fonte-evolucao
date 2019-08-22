package evolucao;

import reader.CodeReader;

public class Runner {
	static String localPath = "";
	
	static CodeReader codeReader = new CodeReader(localPath,  classe);

	public static void main(String[] args) {
		
		codeReader.run();
	//	codeReader.countMethods(Regex.class);

	}
	


}
