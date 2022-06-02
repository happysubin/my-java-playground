package happysubin.javapractice.book.realworld.thirdchapter;

import java.util.ArrayList;
import java.util.List;

//오류를 수집하는 클래스
public class Notification {
    private final List<String> errors = new ArrayList<>();

    public void addError(String message){
        errors.add(message);
    }

    public boolean hasErrors(){
        return !errors.isEmpty();
    }

    public String errorMessage(){
        return errors.toString();
    }

    public List<String> getErrors() {
        return errors;
    }
}
