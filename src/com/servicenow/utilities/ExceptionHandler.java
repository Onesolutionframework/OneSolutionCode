package com.servicenow.utilities;
/**
 * Created by Muni on 5/4/17.
 */
public class ExceptionHandler extends Exception {

    private static final long serialVersionUID = 1L;

    public ExceptionHandler() {
    }

    public ExceptionHandler(String message) {
        super(message);
        Report.log("fail", message);
    }

    public ExceptionHandler(Throwable cause) {
        super(cause);
        Report.log("fail", cause.getMessage());
    }

    public ExceptionHandler(String message, Throwable cause) {
        super(message, cause);
        Report.log("fail", message);
    }

    public ExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ExceptionHandler(Exception e)  {
        super(e.getMessage());
        Report.log("fail", e.getMessage());
    }
}

