package happysubin.javapractice.lecture.inflearn.the_java.how_to_manipulate_code.reflection.v1;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface MyAnnotation {

    String value() default "awesome";
}

/**
 * 애노테이션 필드 값을 꺼낼 수 있다는 것을 개인적으로 잘 기억하면 좋을 것 같다.
 */