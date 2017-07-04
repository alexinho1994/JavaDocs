package ro.teamnet.zerotohero.oop.exceptions;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class MyException extends Exception {

    public MyException(String message)
    {
        super(message);
    }

    public MyException() {
        super();
    }
}
