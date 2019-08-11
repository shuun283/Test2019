package sou.Lesson3.tv;

public interface テレビ {

	int defaultVolumn = 5;

	int defaultChannel = 1;
	
	void 番組を再生する();
	void 番組を再生する(int channel);

	void 音量を調整する(int volumn);

	void チャンネルを変える(int channel);
}
