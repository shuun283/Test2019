package rin.lesson3.calculate;

public class TokenOperator extends Token{
	
	public TokenOperator(String strOpe) {
		super.value = strOpe;
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
	 * 
	 * @param strOpe
	 * @return 0はequal;1はhigher;-1はlower;9はミスマッチ
	 */
	@Override
	public int isPriorityHigherThan(Token token){
		int result = 9;
		if(token == null){
			return result;
		}
		int tokenIndexLeft = commonFunction.getOperatorPriorityIndex(super.toString());
		int tokenIndexRight = commonFunction.getOperatorPriorityIndex(token.toString());
		return commonFunction.ope_priority[tokenIndexLeft][tokenIndexRight];
	}

}
