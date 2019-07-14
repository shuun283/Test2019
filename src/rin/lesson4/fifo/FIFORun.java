package rin.lesson4.fifo;

public class FIFORun {
	public static void main(String[] args) {
		FIFO<String> fifo = new FIFO<String>();
		fifo.in("123");
		fifo.in("456");
		fifo.in("789");
		System.out.println(fifo.out());
		System.out.println(fifo.out());
		System.out.println(fifo.out());
		fifo.toString();
		FIFOMethod<String> fMethod = new FIFOMethod<String>();
		fMethod.in("123");
		fMethod.in("456");
		fMethod.in("789");
		System.out.println(fMethod.out());
		System.out.println(fMethod.out());
		System.out.println(fMethod.out());
		fMethod.toString();
	}
}
