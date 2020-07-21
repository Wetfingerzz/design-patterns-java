package com.example.patterns2.facade.api;

public class OrderProcessingException extends Exception {

    public static String ERR_NOT_AUTHORISED = "User is not authorised";
    public static String ERR_PAYMENT_REJECTED = "Payment rejected!";
    public static String ERR_VERIFICATION_ERROR = "Verification Error";
    public static String ERR_SUBMITTING_ERROR = "Cannot submit order";

    public OrderProcessingException(String message) {
        super(message);
    }
}
