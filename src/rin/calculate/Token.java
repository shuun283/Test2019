package rin.calculate;

public abstract class Token {

	private Object note;
	private TokenType noteType;

	public Token(Object note, TokenType noteType) {
		this.note = note;
		this.noteType = noteType;
	}
	public Object getNote() {
		return this.note;
	}
	public TokenType getNoteType() {
		return this.noteType;
	}
	public String toString() {
		return this.getNote().toString();
	}
//	/**
//	 * 優先度を判定する
//	 * @param strOpe
//	 * @return 0はequal;1はhigher;-1はlower;9はミスマッチ
//	 */
//	@Override
//	public int isPriorityHigherThan(Token token) {
//		int result = 9;
//		if (token == null) {
//			return result;
//		}
//		int tokenIndexLeft = CommonUtil.getOperatorPriorityIndex(super.toString());
//		int tokenIndexRight = CommonUtil.getOperatorPriorityIndex(token.toString());
//		return CommonUtil.ope_priority[tokenIndexLeft][tokenIndexRight];
//	}

}
