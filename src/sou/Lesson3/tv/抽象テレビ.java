package sou.Lesson3.tv;

public abstract class 抽象テレビ implements テレビ {
	private final int size;

	private final String color;

	protected int volumn = defaultVolumn;

	protected int channel = defaultChannel;

	public 抽象テレビ(int size, String color) {
		this.size = size;
		this.color = color;
	}

	public int getVolumn() {
		return volumn;
	}

	public int getSize() {
		return size;
	}


	public String getColor() {
		return color;
	}


	public int getChannel() {
		return channel;
	}

	@Override
	public void チャンネルを変える(int channel) {
		this.channel = channel;
		// 再生？
	}

	@Override
	public void 音量を調整する(int volumn) {
		this.volumn = volumn;
	}

	@Override
	public void 番組を再生する(int channel) {
		this.channel = channel;
		番組を再生する(); 
	}

}
