package rin.lesson5IO.calculate;

public abstract class Token {

	private Object note;
	private TokenType noteType;
	private int priorityIndex;

	public Token(TokenType noteType) {
		this.note = noteType.getValue();
		this.noteType = noteType;
		this.priorityIndex = noteType.getIndex();
	}

	public Token(Object note, TokenType noteType) {
		this.note = note;
		this.noteType = noteType;
		this.priorityIndex = noteType.getIndex();
	}

	public Object getValue() {
		return this.note;
	}

	public TokenType getNoteType() {
		return this.noteType;
	}

	public String getStringValue() {
		return this.getValue().toString();
	}

	public int getPriorityIndex() {
		return priorityIndex;
	}

	/**
	 * POP・PUSH・捨てかを判定する
	 * 
	 * @param strOpe
	 * @return
	 * @throws Exception
	 */
	public int chkIspopWith(final Token tokenRight) {
		int tokenIndexLeft = this.getPriorityIndex();
		int tokenIndexRight = tokenRight.getPriorityIndex();
		// 1はPOP; 0は捨てる; -1はPUSH
		int result = CommonUtil.pop_dump_push[tokenIndexLeft][tokenIndexRight];
		if (result ==9) {
			System.out.println("優先度判定の想定外エラー："+this.getValue()+"と"+tokenRight.getValue());
		}
		return result;
	}

}
