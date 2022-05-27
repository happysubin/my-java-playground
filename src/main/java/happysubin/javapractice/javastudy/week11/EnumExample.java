package happysubin.javapractice.javastudy.week11;

enum Direction{

    EAST(1), SOUTH(5), WEST(3), NORTH(7);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class EnumExample {
    public static void main(String[] args) {
        Direction[] dArr = Direction.values();
        for (Direction d : dArr) {
            System.out.println("d.getDeclaringClass() = " + d.getDeclaringClass());
            System.out.println("d.name() = " + d.name());
            System.out.println("d.ordinal() = " + d.ordinal());
        }

        System.out.println("Direction.valueOf(\"WEST\") = " + Direction.valueOf("WEST"));
        System.out.println("Direction.valueOf(Direction.class,\"EAST\") = " + Direction.valueOf(Direction.class,"EAST"));

    }
}





