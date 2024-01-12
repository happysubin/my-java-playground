package happysubin.javapractice.lab.async;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class AsyncEvent  {

    private Data data;


    public AsyncEvent(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return "AsyncEvent{" +
                "data=" + data +
                '}';
    }
}
