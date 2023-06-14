package happysubin.javapractice.lecture.the_java.how_to_manipulate_code.reflection.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType){
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields())
                .forEach(
                        f -> {
                            if(f.getAnnotation(Inject.class) != null){
                                Object instance1 = createInstance(f.getType());
                                f.setAccessible(true);
                                try {
                                    f.set(instance, instance1);
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                );
        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();

        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
