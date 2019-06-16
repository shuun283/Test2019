package teiKoumei;

import java.util.List;

public class Arithm {

	public boolean isNumber(char c) {
		if (('0' <= c && c <= '9') || c == '.') {
			return true;
		}
		return false;
	}

	public void setLength(List<String> resultList, StringBuilder operator) {
		resultList.add(operator.toString());
		operator.setLength(0);
	}

	public Boolean isOperator(String value) {
		return "+".equals(value) || "-".equals(value) || "*".equals(value) || "/".equals(value);
	}
}
