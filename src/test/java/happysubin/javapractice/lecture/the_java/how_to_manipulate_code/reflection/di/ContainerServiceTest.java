package happysubin.javapractice.lecture.the_java.how_to_manipulate_code.reflection.di;

import happysubin.javapractice.lecture.inflearn.the_java.how_to_manipulate_code.reflection.di.ContainerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainerServiceTest {

    @Test
    public void getObject_BookRepository(){
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        Assertions.assertThat(bookRepository).isNotNull();
    }

    @Test
    public void getObject_BookService(){
        BookService bookService = ContainerService.getObject(BookService.class);

        Assertions.assertThat(bookService).isNotNull();
        Assertions.assertThat(bookService.bookRepository).isNotNull();
    }

}