package ua.edu.ukma.stasiuk.nativeplayground.exception;

public class SubscriptionServiceNameIsNotUniqueException extends RuntimeException {

    private final static String MESSAGE = "Subscription for service named \"%s\" is already registered";

    public SubscriptionServiceNameIsNotUniqueException(String serviceName, Throwable cause) {
        super(String.format(MESSAGE, serviceName), cause);
    }
}
