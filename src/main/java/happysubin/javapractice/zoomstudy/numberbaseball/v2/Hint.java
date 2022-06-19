package happysubin.javapractice.zoomstudy.numberbaseball.v2;

public class Hint {
    private String message;

    public Hint(String message) {
        this.message = message;
    }

    public static Hint createHint(int strikeCount, int ballCount){
        if(strikeCount == 3){
            return new Hint("ANSWER");
        }
        if(ballCount == 0 & strikeCount == 0){
            return new Hint("OUT");
        }
        else{
            return new Hint(strikeCount + " strike " + ballCount + " ball");
        }
    }

    public String getMessage() {
        return message;
    }
}
