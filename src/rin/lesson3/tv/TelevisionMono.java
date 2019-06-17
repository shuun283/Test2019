package rin.lesson3.tv;

import java.awt.geom.Point2D;

public class TelevisionMono extends Television {

	public TelevisionMono(Point2D.Float size, int color) {
		super(size, color);
	}

	@Override
	public void playChanel() {
		System.out.println("モノクロTVの番組を再生します。チャンネルは" + getChanel() + ";音量は" + getVoice());
	}

}
