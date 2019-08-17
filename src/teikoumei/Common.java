package teikoumei;

public class Common {

	private Common() {

	}

	public static boolean isNumber(char c) {
		if (('0' <= c && c <= '9') || c == '.') {
			return true;
		}
		return false;
	}

	public static Boolean isOperator(String value) {
		return "(".equals(value) || ")".equals(value) || "+".equals(value) || "-".equals(value) || "*".equals(value)
				|| "/".equals(value);
	}
	
	public static Boolean isOperator(char value) {
		return "(".equals(value) || ")".equals(value) || "+".equals(value) || "-".equals(value) || "*".equals(value)
				|| "/".equals(value);
	}
}
