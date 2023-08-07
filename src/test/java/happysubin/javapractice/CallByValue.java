package happysubin.javapractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallByValue {

    @Test
    public void whenModifyingObjects_thenOriginalObjectChanged() {
        Foo a = new Foo(1);
        Foo b = new Foo(1);

        // Before Modification
        assertEquals(a.num, 1);
        assertEquals(b.num, 1);

        modify(a, b);

        // After Modification
        assertEquals(a.num, 2);
        assertEquals(b.num, 1);

        System.out.println("======");

        System.out.println(b.toString()); //Foo@3337d04c
        System.out.println(b.num);
    }

    public static void modify(Foo a1, Foo b1) { //스
        a1.num++;

        b1 = new Foo(1); //b1
        b1.num++;

        System.out.println(b1.toString()); //Foo@2f521c4
        System.out.println(b1.num);
    }

    static class Foo {
        public int num;

        public Foo(int num) {
            this.num = num;
        }
    }
}
