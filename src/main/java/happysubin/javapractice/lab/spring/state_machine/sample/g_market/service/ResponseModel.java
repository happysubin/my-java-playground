package happysubin.javapractice.lab.spring.state_machine.sample.g_market.service;

public class ResponseModel {
    public int insertedCents;
    public String beverage;
    public String currentState;

    public ResponseModel(int insertedCents, String beverage, String currentState) {
        this.insertedCents = insertedCents;
        this.beverage = beverage;
        this.currentState = currentState;
    }
}
