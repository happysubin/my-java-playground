package happysubin.javapractice.lab;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @PostMapping("/json")
    public Request json(@RequestBody Request request) {
        System.out.println("request = " + request);
        return request;
    }

    @PostMapping("/model")
    public Request model(@ModelAttribute Request request) {
        System.out.println("request = " + request);
        return request;
    }

    static class Request {
        private final String message;
        private final int age;

        //생성자일때
        //게터만있을때
        public Request(String message, int age) {
            this.message = message;
            this.age = age;
        }

        public String getMessage() {
            return message;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Request{" +
                    "message='" + message + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
