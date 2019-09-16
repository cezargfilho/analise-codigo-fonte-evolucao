package reader;

import java.io.File;

public class TesteDiretorios {

	public static void main(String[] args) {
		CodeReader codeReader = new CodeReader();
		File file = new File("C:\\Users\\000912220\\Downloads\\Dataset");
		codeReader.caminhaDiretorios(file);

	}

}
