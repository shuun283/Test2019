package ou;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Plus {

	public static void main(String[] args) {
		String src = "1+2";
		String pattern = "(\\d*)\\+(\\d*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(src);
		if (m.find()) {
			// System.out.println(m.group(0));
			System.out.println(src + "=" + (Integer.valueOf(m.group(1)) + Integer.valueOf(m.group(2))));
		} else {
			System.out.println("No Match!");
		}
	}

}
