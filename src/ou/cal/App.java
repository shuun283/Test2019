package ou.cal;

import java.util.List;

public class App {

	public static void main(String[] args) {
		List<String> in = FileUtil.readFile("");
		List<String> result = Calculate.execute(in);
		FileUtil.writeFile(result, "");
	}

}
