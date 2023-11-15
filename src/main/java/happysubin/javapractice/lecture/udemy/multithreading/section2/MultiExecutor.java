package happysubin.javapractice.lecture.udemy.multithreading;

import net.bytebuddy.description.method.ParameterList;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

    List<Thread> threads = new ArrayList<>();

    public MultiExecutor(List<Runnable> tasks) {
        for (Runnable task : tasks) {
            threads.add(new Thread(task));
        }
    }

    public void executeAll() {
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
