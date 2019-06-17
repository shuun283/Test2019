package rin.lesson3.tv;

import java.awt.geom.Point2D;

public class TelevisionColor extends Television {

	public TelevisionColor(Point2D.Float size, int color) {
		super(size, color);
	}

	@Override
	public void playChanel() {
		System.out.println("カラーTVの番組を再生します。チャンネルは" + getChanel() + ";音量は" + getVoice());
	}

}

