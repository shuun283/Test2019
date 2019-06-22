package shuun.chapte3;

public class SampleInterface {

	public static void main(String[] args) {
		InheritClass ic = new InheritClass();
		ic.printParentOne();
		ic.printParentTwo();
		ic.printChild();
	}

}

interface ParentOne {

	// 暗黙でpublic Static final int pOne = 1;
	int pOne = 1;

	// 暗黙でpublic abstract void printParentOne();
	void printParentOne();
}

interface ParentTwo {

	int pTwo = 2;

	void printParentTwo();
}

interface Child extends ParentOne, ParentTwo {

	int child = 3;

	void printChild();
}

class InheritClass implements Child{

	@Override
	public void printParentOne() {
		System.out.println(pOne);
	}

	@Override
	public void printParentTwo() {
		System.out.println(pTwo);
	}

	@Override
	public void printChild() {
		System.out.println(child);
	}
	
}
