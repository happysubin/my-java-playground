package happysubin.javapractice.lecture.the_java.how_to_manipulate_code.bytecode;

import happysubin.javapractice.lecture.the_java.how_to_manipulate_code.bytecode.Moim;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MoimTest {

    @Test
    public void isFull(){
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnrollment = 10;

        Assertions.assertThat(moim.isEnrollmentFull()).isFalse();
    }

}