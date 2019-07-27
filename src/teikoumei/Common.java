package teikoumei;

public class Common {

	private Common() {

	}

	/**
	 * ”’l”»’è
	 * @param c
	 * @return
	 */
	public static boolean isNumber(char c) {
		if (('0' <= c && c <= '9') || c == '.') {
			return true;
		}
		return false;
	}

	/**
	 * ‰‰Zq”»’è
	 * @param value
	 * @return
	 */
	public static Boolean isOperator(String value) {
		return "(".equals(value) || ")".equals(value) || "+".equals(value) || "-".equals(value)
				|| "*".equals(value) || "/".equals(value);
	}	
}
