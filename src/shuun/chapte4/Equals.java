package shuun.chapte4;

public class Equals {

	public static void main(String[] args) {
		ObjectOne obj1 = new ObjectOne(1, 2);
		ObjectOne obj2 = new ObjectOne(1, 2);
		ObjectTwo obj3 = new ObjectTwo(1, 2);
		ObjectTwo obj4 = new ObjectTwo(1, 2);
		
		if (obj1.equals(obj2)) {
			System.out.println("obj1 is equals to obj2");
		} else {
			System.out.println("obj1 is not equals to obj2");
		}

		if (obj3.equals(obj4)) {
			System.out.println("obj3 is equals to obj4");
		} else {
			System.out.println("obj3 is not equals to obj4");
		}
	}

}

class ObjectOne {
	private int x;
	private int y;

	public ObjectOne(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ObjectTwo {
	private int x;
	private int y;

	public ObjectTwo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object o) {
		if ((o instanceof ObjectTwo) && (((ObjectTwo) o).x == this.x) && (((ObjectTwo) o).y == this.y)) {
			return true;
		} else {
			return false;
		}
	}
}