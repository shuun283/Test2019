package rin.lesson3.tv;

import java.awt.geom.Point2D;

public abstract class Television {
	private final Point2D.Float size;
	private final int color;
	private int chanel = 1;
	private int voice = 10;

	public Television(Point2D.Float size, int color) {
		this.color = color;
		this.size = size;
	}

	public Point2D.Float getSize() {
		return size;
	}

	public int getColor() {
		return color;
	}

	public int getChanel() {
		return chanel;
	}

	public int getVoice() {
		return voice;
	}

	/**
	 * 番組を再生
	 */
	public abstract void playChanel();

	/**
	 * 番組を再生
	 * @param chanel
	 */
	public void playChanel(int chanel) {
		changeChanel(chanel);
		playChanel();
	}

	/**
	 * チャンネルを変え
	 * @param chanel
	 */
	public void changeChanel(int chanel) {
		this.chanel = chanel;
	}

	/**
	 * 音量を調整
	 * @param voice
	 */
	public void changeVoice(int voice) {
		this.voice = voice;
	}
	
}
