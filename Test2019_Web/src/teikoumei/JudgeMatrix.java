package teikoumei;

public class JudgeMatrix {

	private JudgeMatrix() {
		
	}
	
	public static int[][] compareMatrix = {
			// (, +,  -, *, /, )
			{0,  1,  1,  1,  1,  1}, // (
			{1,  0,  0,  1,  1, -1}, // +
			{1,  0,  0,  1,  1, -1}, // -
			{1, -1, -1,  0,  0, -1}, // *
			{1, -1, -1,  0,  0, -1}, // /
			{9,  9,  9,  9,  9,  0}  // )
	};
}
