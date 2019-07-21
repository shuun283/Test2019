package ou.cal;

import java.util.List;

/**
 * @author wuitar
 *
 */
final class Calculate {

	/**
	 * @param in
	 * @return
	 */
	static protected List<String> execute(List<String> formulaList) {
		List<Violation> constraintViolations = validate(formulaList);
		if (constraintViolations.size() != 0) {
			// LOG
		}
		// parse Reverse Polish
		// method

		// calculate
		// method
		// return data

		return null;
	}

	private static List<Violation> validate(List<String> formulaList) {
		// TODO Auto-generated method stub
		return null;
	}
}
