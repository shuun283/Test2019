package ou;

import java.util.ArrayList;
import java.util.List;

public class FIFO<T> {
	private List<T> fifo;

	public FIFO() {
		// TODO Auto-generated constructor stub
		fifo = new ArrayList<T>();
	}

	public void in(T src) {
		this.fifo.add(src);
	}

	public T out() {
		if (this.fifo.isEmpty()) {
			return null;
		}
		return fifo.remove(0);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		this.fifo.stream().forEach(p -> stringBuilder.append(p));
		return stringBuilder.toString();
	}
}
