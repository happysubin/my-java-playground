package happysubin.javapractice.the_java.how_to_manipulate_code.reflection.v2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("happysubin.javapractice.the_java.how_to_manipulate_code.reflection.v2.Book");
        Constructor<?> constructor = bookClass.getConstructor(String.class);//null을 넣으면 기본 생성자
        Book book = (Book) constructor.newInstance("myBook");
        System.out.println("book = " + book.toString());

        Field a = bookClass.getDeclaredField("A");
        Object o = a.get(null);//객체를 넣으면 그 객체가 가지는 필드를 가져올 수 있다. static 영역이라서 null을 넣었다.
        System.out.println("A = " + o);
        a.set(null, "BBBBBB"); // 값 세팅
        System.out.println("A = " + a.get(null));


        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true); //private 접근자에서도 접근 가능하게
        Object o1 = b.get(book); //객체의 값을 가져온다.
        System.out.println("o1 = " + o1);
        b.set(book, "awesome"); //book이 참조하는 객체의 b 필드 값을 awesome로 바꾼다.
        System.out.println("book.toString() = " + book.toString()); //B값이 바뀐걸 확인 가능

        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book);

        Method d = Book.class.getDeclaredMethod("sum", int.class, int.class); //원시형과 참조형을 구분해야함
        Object invoke = d.invoke(book, 1, 3);
        System.out.println("invoke = " + invoke);


    }
}
