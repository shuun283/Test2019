package shuun.chapte4;

public class HashCode {

	public static void main(String[] args) {
		HashStore hs1 = new HashStore(89, 101);
		HashStore hs2 = new HashStore(75, 101);
		HashStore hs3 = new HashStore(89, 101);

		System.out.println("HashCode for hs1: " + hs1.hashCode());
		System.out.println("HashCode for hs2: " + hs2.hashCode());
		System.out.println("HashCode for hs3: " + hs3.hashCode());

		if (hs1.equals(hs2)) {
			System.out.println("hs1 is equals to hs2");
		} else {
			System.out.println("hs1 is not equals to hs2");
		}

		if (hs1.equals(hs3)) {
			System.out.println("hs1 is equals to hs3");
		} else {
			System.out.println("hs1 is not equals to hs3");
		}
	}

}

class HashStore {
	private int key;
	private int value;
	private int storeSize = 10;

	public HashStore(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof HashStore)) {
			return false;
		}
		HashStore hS = (HashStore) obj;
		return (key == hS.key && value == hS.value);
	}

	public int hashCode() {
		return key % storeSize;
	}
}