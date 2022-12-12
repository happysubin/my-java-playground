package happysubin.javapractice.the_java.how_to_manipulate_code.reflection.v1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Class<Book> bookClass = Book.class;
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        Field[] fields = bookClass.getFields(); //public 접근제어자 필드만 가져올 수 있다.
        Field[] declaredFields = bookClass.getDeclaredFields(); //모든 필드를 가져옴

        Arrays.stream(declaredFields)
                .forEach(f -> {
                    try{
                        f.setAccessible(true); //모든 것에 접근가능하게 설정
                        System.out.println(f + " = " + f.get(book) );
                        int modifiers = f.getModifiers();
                        System.out.println(Modifier.isFinal(modifiers));
                        System.out.println(Modifier.isStatic(modifiers));
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                });



        for (Field field : fields) {
            System.out.println("field = " + field.toString());

        }


        System.out.println();
        //메서드

        Class<? super MyBook> superclass = MyBook.class.getSuperclass();
        Class<?>[] interfaces = MyBook.class.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("anInterface = " + anInterface);
        }
        System.out.println("superclass = " + superclass);
        Method[] declaredMethods = Book.class.getDeclaredMethods();
        Arrays.stream(declaredMethods)
                .forEach(m -> System.out.println("m = " + m));


        for (Annotation annotation : book.getClass().getAnnotations()) {
            System.out.println("annotation = " + annotation.toString());
        }


        Annotation[] annotations = MyBook.class.getAnnotations();
        Arrays.stream(annotations)
                .forEach(i -> System.out.println("i = " + i));
        Annotation[] declaredAnnotations = MyBook.class.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println("declaredAnnotation = " + declaredAnnotation);
        }
    }
}

/**
 * getFi
 */