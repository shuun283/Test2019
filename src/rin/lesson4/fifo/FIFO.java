package rin.lesson4.fifo;

import java.util.ArrayList;
import java.util.List;

public class FIFO<T> {

	List<T> _list;
	
	public FIFO(){
		this._list = new ArrayList<T>();
	}

	public void in(T t) {
		_list.add(t);
	}
	
	public T out() {
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
	//	Map<String, String> fifo_obj = new  LinkedHashMap<String, String>();
//	public E<T> output() {
//		
//		return 
//	}
}
