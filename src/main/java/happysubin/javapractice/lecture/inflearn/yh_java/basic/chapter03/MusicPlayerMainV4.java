package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter03;

public class MusicPlayerMainV4 {

    public static void main(String[] args) {
        MusicPlayerDataV2 data = new MusicPlayerDataV2();
        data.on();
        data.volumeUp();
        data.volumeUp();
        data.volumeDown();
        data.showStatus();
        data.off();
    }
}
