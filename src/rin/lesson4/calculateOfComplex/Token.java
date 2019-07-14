package rin.lesson4.calculateOfComplex;

public abstract class Token {

	private Object note;
	private TokenType noteType;
	private int priorityIndex;

	public Token(Object note, TokenType noteType) {
		this.note = note;
		this.noteType = noteType;
		this.priorityIndex = CommonUtil.getOperatorPriorityIndex(noteType);
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
	public int getPriorityIndex() {
		return priorityIndex;
	}
	/**
	 * 優先度を判定する
	 * @param strOpe
	 * @return 
	 * @throws Exception 
	 */
	public boolean isPriorityHighterThan(Token token){
		int tokenIndexLeft = this.getPriorityIndex();
		int tokenIndexRight = token.getPriorityIndex();
		//0はequal;1はhigher;-1はlower;
		int result = CommonUtil.ope_priority[tokenIndexLeft][tokenIndexRight];
		if (result>0) {
			return true;
		}
		return false;
	}
//	/**
//	 * 優先度を判定する
//	 * @param strOpe
//	 * @return 
//	 * @throws Exception 
//	 */
//	public boolean isPriorityLowerThan(Token token){
//		int tokenIndexLeft = this.getPriorityIndex();
//		int tokenIndexRight = token.getPriorityIndex();
//		//0はequal;1はhigher;-1はlower;
//		int result = CommonUtil.ope_priority[tokenIndexLeft][tokenIndexRight];
//		if (result<0) {
//			return true;
//		}
//		return false;
//	}
		

}
