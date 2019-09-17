package evolucao;

import java.io.File;
import java.util.Scanner;

import reader.CodeReader;

public class Runner {
	static String localPath;
	static CodeReader codeReader = new CodeReader();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o Local do arquivo:");
		localPath = scanner.nextLine();
		File file = new File(localPath);
		codeReader.run(file);
		scanner.close();
	}
}
