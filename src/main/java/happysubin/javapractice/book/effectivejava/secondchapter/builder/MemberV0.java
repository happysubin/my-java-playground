package happysubin.javapractice.book.effectivejava.secondchapter.builder;

public class MemberV0 {
    //필수 필드
    private final String email;
    private final String password;

    //선택 필드
    private final String nickname;
    private final String school;
    private final String sex;
    private final String phoneNumber;

    public MemberV0(String email, String password) {
        this(email, password, null);
    }

    public MemberV0(String email, String password, String nickname) {
        this(email, password, nickname, null);
    }

    public MemberV0(String email, String password, String nickname, String school) {
        this(email, password, nickname, school, null);
    }

    public MemberV0(String email, String password, String nickname, String school, String sex) {
        this(email, password, nickname, school, sex, null);
    }

    public MemberV0(String email, String password, String nickname, String school, String sex, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.school = school;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "MemberV0{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", school='" + school + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
