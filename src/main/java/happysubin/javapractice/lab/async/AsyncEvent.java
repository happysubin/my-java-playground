package happysubin.javapractice.lab.async;

import happysubin.javapractice.lab.multi_tx.main.Data;

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
