package happysubin.javapractice.book.effectivejava.secondchapter.builder;


public class Member {
    private  Long id;
    private  String loginId;
    private  String password;
    private  String nickname;
    private  String school;
    private  String email;
    private  String sex;
    private  String phoneNumber;

    public static class Builder{
        private  Long id;
        private  String loginId;
        private  String password;
        private  String nickname;
        private  String school;
        private  String email;
        private  String phoneNumber;
        private  String sex;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder loginId(String loginId){
            this.loginId = loginId;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder nickname(String nickname){
            this.nickname = nickname;
            return this;
        }

        public Builder school(String school){
            this.school = school;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder sex(String sex){
            this.sex = sex;
            return this;
        }

        public Member build(){
            return new Member(this);
        }
    }

    public Member(Builder builder) {
        this.id =       builder.id;
        this.loginId =  builder.loginId;
        this.password = builder.password;
        this.nickname = builder.nickname;
        this.school =   builder.school;
        this.email =    builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.sex = builder.sex;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", school='" + school + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
