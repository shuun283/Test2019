package teishouhei;

import java.util.ArrayList;
import java.util.List;

public class MethodRefTest {

    public static void main(String[] args) {
        
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        for (String str : list) {
            System.out.println(str);
        }
        
        list.forEach(System.out :: println);
        
        list.forEach((value) -> System.out.println(value));
        
        Customizer customizer = new Customizer();
        MethodRefTest methodRefTest = new MethodRefTest();
        
        methodRefTest.operateStr(customizer:: customizer, "aaaa");  
        
        methodRefTest.operateStr((value) -> System.out.println("the result : " + value), "aaaa");  
        
    }
    
    public void operateStr(MethodRefInterface methodRefInterface, String str) {
        methodRefInterface.m1(str);
    }

}

interface MethodRefInterface {
    public void m1(String value);
}

class Customizer {
    public void customizer(String value) {
        System.out.println("the result : " + value);
    }
}


