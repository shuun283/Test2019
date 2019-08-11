package rin.calculate;

public abstract class Token {

	private Object value;
	private TokenType noteType;
	private int priorityIndex;

	public Token(TokenType noteType) {
		this.value = noteType.getValue();
		this.noteType = noteType;
		this.priorityIndex = noteType.getPriorityIndex();
	}

	public Token(Object note, TokenType noteType) {
		this.value = note;
		this.noteType = noteType;
		this.priorityIndex = noteType.getPriorityIndex();
	}

	public Object getValue() {
		return this.value;
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
		int result = pop_dump_push[tokenIndexLeft][tokenIndexRight];
		if (result == 9) {
			System.out.println("優先度判定の想定外エラー：" + this.getValue() + "と" + tokenRight.getValue());
		}
		return result;
	}

	/**
	 * POPandPUSHの比較定義
	 * 縦は一目演算子のインデックス +,-,*,/,(,),#
	 * 横は二目演算子のインデックス +,-,*,/,(,),#
	 * 結果：
	 * 1はPOP; 0は捨てる; -1はPUSH
	 */
	private static int[][] pop_dump_push = { // [left][right]
			// r0, r1, r2, r3, r4, r5, r6
			// +, -, *, /, (, ), #
			{ 1, 1, -1, -1, -1, 1, -1 }, // left0「+」
			{ 1, 1, -1, -1, -1, 1, -1 }, // left1「-」
			{ 1, 1, 1, 1, -1, 1, -1 }, // left2「*」
			{ 1, 1, 1, 1, -1, 0, -1 }, // left3「/」
			{ -1, -1, -1, -1, -1, 9, -1 }, // left4「(」
			{ 9, 9, 9, 9, 9, 9, 9 }, // left5「)」
			{ 1, 1, 1, 1, 1, 1, 9 },// left6「#」
	};

}
