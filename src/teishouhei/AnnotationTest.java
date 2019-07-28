package teishouhei;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;


public class AnnotationTest {

    public static void main(String[] args) {
        
        Annotation[] annotations = AnnotationImp.class.getAnnotations();
        
        System.out.println(annotations[0].annotationType());
        
        Field[] fields = AnnotationImp.class.getFields();
        
        for (Field field : fields) {
            annottationTest annotation = field.getAnnotation(annottationTest.class);
            
            if (annotation != null) {
                System.out.println(field.getName() + " annottationTest is exist!");
            } else {
                System.out.println(field.getName() + " annottationTest is not exist!");
            }
        }
        
        

    }
    
}

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface annottationTest {
    String  method() default "aa";
    
}


@annottationTest
class AnnotationImp {
    
    @annottationTest(method = "name")
    public String name;
    
    @annottationTest(method = "age")
    public Integer age;
    
    @annottationTest(method = "method")
    public void method1() {
        
    }
    
}