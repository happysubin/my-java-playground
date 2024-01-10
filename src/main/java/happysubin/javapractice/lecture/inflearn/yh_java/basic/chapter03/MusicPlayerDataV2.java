package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter03;

public class MusicPlayerDataV2 {

    private int volume = 0;
    private boolean isOn = false;


    void volumeDown() {
        this.volume--;
        printVolume();
    }

    void volumeUp() {
        this.volume++;
        printVolume();
    }

    private void printVolume() {
        System.out.println("음악 플레이어 볼륨:" + this.volume);
    }

    void on() {
        this.isOn = true;
        System.out.println("음악 플레이어를 시작합니다");
    }
    void off() {
        this.isOn = false;
        System.out.println("음악 플레이어를 종료합니다");
    }

    void showStatus() {
        System.out.println("음악 플레이어 상태 확인");
        if (this.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + this.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }


}
