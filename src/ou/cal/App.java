package ou.cal;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {
	private static final String PATH = "src/ou/cal/";

	public static void main(String[] args) throws IOException {
		File directory = new File("./");
		System.out.println(directory.getAbsolutePath());
		List<String> in = FileUtil.readFile(PATH + "question.txt");
//
//		ValidatorHandle vh = new ValidatorHandle(in);
//
//		if (constraintViolations.size() != 0) {
//			// LOG
//		}
		List<String> result = Calculate.execute(in);
		FileUtil.writeFile(in, PATH + "answer.txt");
	}

}
