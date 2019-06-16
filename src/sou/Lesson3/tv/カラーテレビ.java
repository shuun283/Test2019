package sou.Lesson3.tv;

public class カラーテレビ extends 抽象テレビ {

	public カラーテレビ(int size, String color) {
		super(size, color);
	}

	@Override
	public void 番組を再生する() {
		System.out.print(
				String.format(" カラーテレビの番組を再生します。[channel:%d, volumn:%d]", getChannel(),
						getVolumn()));
	}
}
