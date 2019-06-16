package lin.Lesson3;

public class TelevisionMonokuro extends Television {
    public TelevisionMonokuro(String size, int color) {
        super(size, color);
    }

    @Override
    public void playChanel() {
        System.out.println("ものくろの番組を再生する");
    }

}
