package ou.cal;

import java.util.List;

public class App {

	public static void main(String[] args) {
		List<String> in = FileUtil.readFile("");
//
//		ValidatorHandle vh = new ValidatorHandle(in);
//
//		if (constraintViolations.size() != 0) {
//			// LOG
//		}
		List<String> result = Calculate.execute(in);
		FileUtil.writeFile(result, "");
	}

}
