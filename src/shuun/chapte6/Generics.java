package shuun.chapte6;

public class Generics {

	public static void main(String[] args) {
		Myclass myclass = new Myclass();
		myclass.func(10);
		myclass.func(new Integer(10));
		myclass.func(10.0);
		myclass.func(new Double(10.0));
		myclass.func("aaa");
		myclass.func("あああ");
	}

}
class Myclass{
	public <T> void func(T val) {
        System.out.println("val = " + val);
	}
}