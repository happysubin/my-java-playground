package happysubin.javapractice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false, 800, Dish.Type.MEAT),
                new Dish("beef",false, 700, Dish.Type.MEAT),
                new Dish("chicken",false, 400, Dish.Type.MEAT),
                new Dish("french fires",true, 530, Dish.Type.OTHER),
                new Dish("rice",true, 350, Dish.Type.OTHER),
                new Dish("season fruit",true, 120, Dish.Type.OTHER),
                new Dish("pizza",true, 550, Dish.Type.OTHER),
                new Dish("prawns",false, 300, Dish.Type.FISH),
                new Dish("salmon",false, 400, Dish.Type.FISH)
        );

        List<String> name = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("name = " + name);

        List<Dish> vegetarianDishes = menu.stream()
                .filter(Dish::isVegetarian) //채식주의자인지 검사
                .collect(Collectors.toList());
        System.out.println("vegetarianDishes = " + vegetarianDishes);

        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream().filter(i -> i%2==0).distinct().forEach(System.out::println); //2,4 2개만 출력. 중복은 걸러진다.

        int calories = menu.stream().mapToInt(t -> t.getCalories()).sum();
        System.out.println("calories = " + calories);
    }
}
