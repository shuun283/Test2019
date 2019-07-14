package rin.lesson4.fifo;

import java.util.ArrayList;
import java.util.List;

public class FIFOMethod<T> {

	List<T> _list;
	
	public FIFOMethod(){
		this._list = new ArrayList<T>();
	}

	public void in(T t) {
		_list.add(t);
	}
	
	public <R> T out() {
		if(_list.isEmpty()) {
			return null;
		}
		return _list.remove(0);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		this._list.stream().forEach(item->sb.append(item));
		return sb.toString();
	}
}
