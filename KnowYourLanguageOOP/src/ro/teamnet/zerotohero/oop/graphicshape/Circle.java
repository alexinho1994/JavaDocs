package ro.teamnet.zerotohero.oop.graphicshape;

import ro.teamnet.zerotohero.oop.exceptions.PosException;
import ro.teamnet.zerotohero.oop.exceptions.RadiusException;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class Circle extends Shape{

    private int xPos;
    private int yPos;
    private int radius;

    public Circle() {

        this.xPos = 0;
        this.yPos = 0;
        this.radius = 5;
    }

    public Circle(int radius) {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = radius;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = 5;
    }

    public Circle(int xPos, int yPos, int radius) throws RadiusException, PosException {
        if(radius < 0)
            throw new RadiusException();
        if(xPos < 0 || yPos < 0)
            throw new PosException();
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    public double area()
    {
        return radius*radius* Math.PI;
    }

    public String toString()
    {
        return "center  = (" + this.xPos + ", " + this.yPos + ") and radius = " + this.radius;
    }

    public void fillColour()
    {
        System.out.println("The circle color is now " + super.getColor());
    }

    public void fillColour(int color)
    {
        super.setColor(color);
        System.out.println("The circle color is " + super.getColor());
    }

    public void fillColour(float saturation)
    {
        super.setSaturation(saturation);
    }
}
