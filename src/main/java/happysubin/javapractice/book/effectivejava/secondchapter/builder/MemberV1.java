package happysubin.javapractice.book.effectivejava.secondchapter.builder;

public class MemberV1 {
    private  String email = ""; //필수.
    private  String password = ""; //필수.
    private  String nickname;
    private  String school;
    private  String sex;
    private  String phoneNumber;

    public MemberV1() {

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
