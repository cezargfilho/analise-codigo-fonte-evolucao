package evolucao;

import java.util.Scanner;

import reader.CodeReader;

public class Runner {
	static String localPath;
	static CodeReader codeReader = new CodeReader();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o LOCAL do arquivo:");
		localPath = scanner.nextLine();
		codeReader.run(localPath);
		scanner.close();

	}
	


}
