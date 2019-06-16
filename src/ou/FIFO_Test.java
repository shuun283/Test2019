package ou;

public class FIFO_Test {

	public static void main(String[] args) {
		FIFO<String> line = new FIFO<String>();
		line.in("A");
		line.in("B");
		line.in("C");
		line.out();
		line.in("D");
		System.out.println(line.toString());
	}
}
