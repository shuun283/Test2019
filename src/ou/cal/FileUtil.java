package ou.cal;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

final class FileUtil {

	static final List<String> readFile(String path) throws IOException {
		// synchronized
		Path file = Paths.get(path);
		List<String> text = Files.readAllLines(file);
		System.out.println(text);

		return text;
	}

	static final boolean writeFile(List<String> data, String path) throws IOException {
		// synchronized
		FileWriter fw = new FileWriter(path);
		data.forEach(line -> {
			try {
				fw.write(line + System.lineSeparator());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		fw.close();
		return true;
	}
}
