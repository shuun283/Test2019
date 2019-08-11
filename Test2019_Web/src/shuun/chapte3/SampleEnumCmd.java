package shuun.chapte3;

public class SampleEnumCmd {

	public static void main(String[] args) {
		int nargs = args.length;
		if (nargs < 1) {
			System.out.println("UP, DOWN, CHARM, STRANGE, TRUTH, BEAUTY");
			System.exit(0);
		} else {
			Quark q = Quark.valueOf(args[0].toUpperCase());
			char symbol = q.getSymbol();
			double charge = q.getCharge();
			System.out.println("symbol " + symbol);
			System.out.println("charge " + charge);
			System.out.println("quark " + q.name());

		}
	}

}

enum Quark{
	
	UP('u', 2.0/3.0),
	DOWN('d', -1.0/3.0),
	CHARM('c', 2.0/3.0),
	STRANGE('s', -1.0/3.0),
	TRUTH('t', 2.0/3.0),
	BEAUTY('b', -1.0/3.0);
	
	private final char symbol;
	private final double charge;
	Quark(char symbol, double charge){
		this.symbol = symbol;
		this.charge = charge;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public double getCharge() {
		return charge;
	}
}