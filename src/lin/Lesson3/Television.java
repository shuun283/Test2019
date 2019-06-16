package lin.Lesson3;

public abstract class Television {
	private final String size;
	private final int color;
	private int voice = 2;
	private int chanel = 3;
	public Television(String size, int color) {
		this.size = size;
		this.color = color;
	}
	public String getSize() {
		return size;
	}

	public int getColor() {
		return color;
	}

	public int getVoice() {
		return voice;
	}

	public int getChanel() {
		return chanel;
	}

	public abstract void playChanel();
	
	public void playChanel(int chanel) {
	    changeChanel(chanel);
	    playChanel();
		System.out.println(chanel+"チャンネルを"+this.size+"のサイズ、"+this.color+"の色、"+this.voice+"の音量で再生する");
	}
	public void changeVoice(int voice) {
		this.voice = voice;
		System.out.println(voice+"の音量で放送する");
	}

	public void changeChanel(int chanel) {
	    this.chanel = chanel;
	}
	
}
