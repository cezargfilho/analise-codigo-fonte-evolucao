package evolucao;

import java.io.File;
import java.util.Scanner;

import reader.CodeReader;

/**
 * @author cezar-filho
 *
 */
public class Runner {
	static String localPath;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o Local do arquivo:");
		localPath = scanner.nextLine();
		File file = new File(localPath);
		new CodeReader().run(file);
		scanner.close();
	}
}
