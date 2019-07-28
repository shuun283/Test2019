package teishouhei;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest {

    public static void main(String[] args) {
        
        Function<String, String> func = (name) -> {System.out.println(name); System.out.println("bbbb"); return name + "aa";};
        
        Function<String, String> func1 = (name) -> {return "name* " + name;};
        
        // (x, y) -> {};
//        FunctionInterface func = new FunctionInterface() {
//            public void m1() {
//                System.out.println("aaaa");
//            }
//        };
        
        // String returnVal = func.m1("name");
        
//        FunctionInterfaceImpl functionInterfaceImpl = new FunctionInterfaceImpl();
//        functionInterfaceImpl.m1();
        
        //List<User> list = new ArrayList<>();
        //list.stream().filter(predicate);
    }

}

@FunctionalInterface
interface FunctionInterface {
    public String m1(String str);
    
}

//class FunctionInterfaceImpl implements FunctionInterface {
//    @Override
//    public void m1() {
//        System.out.println("aaaa");
//    }
//    
//}