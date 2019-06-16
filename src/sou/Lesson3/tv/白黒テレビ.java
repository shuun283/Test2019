package sou.Lesson3.tv;

public class 白黒テレビ extends 抽象テレビ {

	public 白黒テレビ(int size, String color) {
		super(size, color);
	}

	@Override
	public void 番組を再生する() {
		System.out.print(
				String.format("白黒テレビの番組を再生します。[channel:%d, volumn:%d]", getChannel(), getVolumn()));
	}

}
