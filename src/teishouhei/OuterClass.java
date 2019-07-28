package teishouhei;

public class OuterClass {
    
    private String name;
    
    public static Integer age;

    public static void main(String[] args) {
        
        Runnable runable = new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                
            }
            
        };
        
        
        OuterClass out = new OuterClass();
        
        OuterClass.InnerClass inner = out.new InnerClass();
        
        OuterClass.StaticInnerClass  staticInnerClass = new OuterClass.StaticInnerClass();
        

    }
    
    public void sayHello() {
        int age2 = 1;
        try {
            class InnerInner {
               public void sayHello() {
                   //age2 = 12;
                   name = "aaaa";
                   System.out.println(age2);
               }
            }        
           } catch (Exception e) {
            
        }

    }
    
    private class InnerClass {
        
        private String name;
        
        public void sayHello() {
            System.out.println("inner class");
            
            System.out.println(name);
            
            System.out.println(OuterClass.this.name);
            
            System.out.println(age);
        }
    }
    
    static class StaticInnerClass {
        
       /// private String name;
        
        public void sayHello() {
            System.out.println("inner class");
            
            System.out.println(age);
            
            //System.out.println(name);
            
            System.out.println(age);
        }
    }
    

}
