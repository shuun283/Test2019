package shuun.chapte2;

public class Sample05 {

	public static void main(String[] args) {		
		
		Innerclass name = new Innerclass();
		name.methodA();
	}

}
class Innerclass {

	int memberVar = 10;

	void methodA() {
		int localVarA = 20;
		System.out.println("メンバ変数(memberVar)：" + this.memberVar);
		System.out.println("ローカル変数(localVarA)：" + localVarA);
		// System.out.println("ローカル変数(localVarB)：" + localVarB);
	}

	void methodB() {
		int localVarB = 20;
	}

}