package lin.Lesson3;

public class TelevisionColor extends Television{
	public TelevisionColor(String size, int color) {
		super(size, color);
	}

	@Override
	public void playChanel() {
		System.out.println("カラーの番組を再生する");
	}
	
}
