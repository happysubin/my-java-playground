package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter03;

public class MusicPlayerMainV3 {

    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();
        on(data);
        volumeUp(data);
        volumeUp(data);
        volumeDown(data);
        showStatus(data);
        off(data);
    }


    private static void volumeDown(MusicPlayerData data) {
        data.volume--;
        printVolume(data.volume);
    }

    private static void volumeUp(MusicPlayerData data) {
        data.volume++;
        printVolume(data.volume);
    }

    private static void printVolume(int volume) {
        System.out.println("음악 플레이어 볼륨:" + volume);
    }

    static void on(MusicPlayerData data) { data.isOn = true;
        System.out.println("음악 플레이어를 시작합니다");
    }
    static void off(MusicPlayerData data) { data.isOn = false;
        System.out.println("음악 플레이어를 종료합니다");
    }

    private static void showStatus(MusicPlayerData data) {
        System.out.println("음악 플레이어 상태 확인");
        if (data.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + data.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }
}
