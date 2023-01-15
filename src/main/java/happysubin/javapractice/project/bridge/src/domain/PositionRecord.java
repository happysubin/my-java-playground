package happysubin.javapractice.project.bridge.src.domain;

public class PositionRecord {

    private final Pass pass;
    private final String position;

    public PositionRecord(String position, Pass pass) {
        this.pass = pass;
        this.position = position;
    }

    public Pass getPass() {
        return pass;
    }

    public String getPosition() {
        return position;
    }
}
