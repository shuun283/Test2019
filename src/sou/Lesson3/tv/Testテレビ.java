package sou.Lesson3.tv;

public class Testテレビ {

    public static void main(String[] args) {
        テレビ tv1 = new 白黒テレビ(15, "black");
        tv1.番組を再生する();
        tv1.音量を調整する(7);
        tv1.チャンネルを変える(2);

        テレビ tv2 = new カラーテレビ(21, "red");
        tv2.番組を再生する();
        tv2.音量を調整する(6);
        tv2.チャンネルを変える(7);
    }

}
