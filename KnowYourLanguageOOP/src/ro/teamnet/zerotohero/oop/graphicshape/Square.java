package ro.teamnet.zerotohero.oop.graphicshape;

import ro.teamnet.zerotohero.oop.exceptions.MyException;
import ro.teamnet.zerotohero.oop.exceptions.SecondException;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class Square extends Shape {

    private int side;
    private int centerX;
    private int centerY;

    public Square(int side) throws MyException {

        this.doStuff();
        this.side = side;
    }

    public Square(int side, int centerX, int centerY) throws SecondException, MyException {
        this(side);
        try{
            this.doStuff();
        }
        catch(MyException e)
        {
            if(centerX < 0 && centerY < 0)
                throw new SecondException("invalid center");
        }
        finally {
            System.out.println("finally statement");
        }
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public void doStuff() throws MyException{
        if(side < 0)
            throw new MyException("side less than 0");
    }

    public double area()
    {
        return side*side;
    }
}
