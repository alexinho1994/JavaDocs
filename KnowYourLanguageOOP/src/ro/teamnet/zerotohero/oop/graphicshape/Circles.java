package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class Circles {

    public double getAreaPub()
    {
        Circle cerc = new Circle();
        return cerc.area();
    }

    public void getAreaDef()
    {
        Circle c = new Circle();
        int a = 3;
        float b = 5;
        c.fillColour();
        c.fillColour(a);
        c.fillColour(b);
    }

}
