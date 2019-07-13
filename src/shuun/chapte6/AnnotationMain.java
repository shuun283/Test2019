package shuun.chapte6;

import java.lang.reflect.Method;

public class AnnotationMain {

	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("AnnotationInstance");
			Method method1 = clazz.getMethod("execute", new Class<?>[] {});
			Info info1 = method1.getAnnotation(Info.class);
			System.out.println(info1.value());
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
