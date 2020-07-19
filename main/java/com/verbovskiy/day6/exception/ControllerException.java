package com.verbovskiy.day6.exception;

public class ControllerException extends Exception{
    public ControllerException() {
        super();
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ControllerException(Throwable throwable) {
        super(throwable);
    }
}
