package happysubin.javapractice.book.effectivejava.secondchapter.builder;

public class MemberApplication {
    public static void main(String[] args) {
        Member member = new Member.Builder()
                .id(1L)
                .loginId("12345")
                .password("123456789")
                .nickname("debin")
                .school("school")
                .email("123@gmail.com")
                .phoneNumber("123-456-789")
                .sex("male")
                .build();

        //System.out.println("member = " + member.toString());

        MemberV0 memberV0 = new MemberV0("123", "123");
        System.out.println(memberV0.toString());

    }
}
