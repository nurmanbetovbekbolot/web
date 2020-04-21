package kg.itacademy.exceptions;

public class PaymentWasAlreadyProcessedException extends Exception {
    private static final String message = "Transaction was already validated!";

    public PaymentWasAlreadyProcessedException() {
        super(message);
    }
}
