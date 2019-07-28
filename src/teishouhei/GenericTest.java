package teishouhei;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        //list.add("asdf");
        
        Parent parent1 = new Parent<String>("aaaa");
        parent1.printT();
        
        Parent parent2 = new Parent<Integer>(123);
        parent2.printT();
        
        @SuppressWarnings("rawtypes")
        Parent parent3 = new Parent<String>("parent3");
        
        // String p31 = parent3.genericMethod();
        
        //parent3.genericMethod();

    }

}


class Parent<T> {
    
    T entry;
    
    
    public Parent(T t) {
        this.entry = t;
    }
    
    public void printT() {
        System.out.println(entry);
    }
    
    @SuppressWarnings("unchecked")
    public <E> E genericMethod() {
        
        return (E) "";
    }
   
}
