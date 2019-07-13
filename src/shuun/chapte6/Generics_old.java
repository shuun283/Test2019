package shuun.chapte6;

public class Generics_old {

	public static void main(String[] args) {
		ClassSample cs = new ClassSample("Hello");
		Integer i = (Integer) cs.getO();
		System.out.println(i);
		
		// String型として利用可能
        ClassSample1<String> cs1 = new ClassSample1<String>("Hello");
        String str = cs1.getT();
        System.out.println(str);
 
        // Integer型として利用可能
        ClassSample1<Integer> cs2 = new ClassSample1<Integer>(1);
        Integer j = cs2.getT();
        System.out.println(j);
	}

}

class ClassSample {
	private Object o;

	public ClassSample(Object o) {
		this.o = o;
	}

	public Object getO() {
		return o;
	}
}
class ClassSample1<T>{
    private T t;
 
    public ClassSample1(T t){
        this.t = t;
    }
 
    public T getT(){
        return t;
    }
}