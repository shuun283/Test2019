package rin.lesson3.calculate;

public class TokenOperator extends Token {

	public TokenOperator(String strOpe) {
		super(strOpe);
	}

	@Override
	public boolean isOperator() {
		return true;
	}

	@Override
	public boolean isNumeric() {
		return false;
	}

	/**
	 * 優先度を判定する
	 * 
	 * @param strOpe
	 * @return 0はequal;1はhigher;-1はlower;9はミスマッチ
	 */
	@Override
	public int isPriorityHigherThan(Token token) {
		int result = 9;
		if (token == null) {
			return result;
		}
		int tokenIndexLeft = CommonUtil.getOperatorPriorityIndex(super.toString());
		int tokenIndexRight = CommonUtil.getOperatorPriorityIndex(token.toString());
		return CommonUtil.ope_priority[tokenIndexLeft][tokenIndexRight];
	}

}
