package happysubin.javapractice.lab.redis.websocket;

public class Data {

    private final int id;
    private final String content;

    public Data(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
