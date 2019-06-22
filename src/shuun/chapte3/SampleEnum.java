package shuun.chapte3;

public class SampleEnum {

	public static void main(String[] args) {
		Colors c = new Colors();
		c.color = Colors.ThreeColors.RED;
		System.out.println(c.color);
	}

}

class Colors{
	enum ThreeColors {
		RED, BULE, GREENW
	}
	ThreeColors color;
	
}