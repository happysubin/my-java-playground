package happysubin.javapractice.lecture.the_java.how_to_manipulate_code.bytecode;

public class Moim {

    int maxNumberOfAttendees;
    int numberOfEnrollment;

    public boolean isEnrollmentFull(){
        if(maxNumberOfAttendees == 0){
            return false;
        }

        if(numberOfEnrollment < maxNumberOfAttendees){
            return false;
        }

        return true;
    }
}

/**
 * https://docs.gradle.org/current/userguide/jacoco_plugin.html
 * jacoco 적용 *
 * https://techblog.woowahan.com/2661/
 */


/**
 * ByteBuddy 바이트 코드 조작 라이브러리. 이걸 선장님이 추천해주심.
 */