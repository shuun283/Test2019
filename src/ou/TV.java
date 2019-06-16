package ou;

public class TV {

	public int size;
	public String color;
	public int volume;

	public void replay() {
		System.out.println("Palying " + this.color + " TV.");
	}

	public void replay(int channel) {

	}

	public void changeVolume(boolean loud) {
		if (loud) {
			this.volume++;
		} else {
			this.volume--;
		}
	}

	public void changeChannel(int channel) {

	}
}
