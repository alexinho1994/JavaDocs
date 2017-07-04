package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class Shape extends AbstractShape implements ShapeBehaviour{

    protected int color;
    protected float saturation;

    public int getColor() {
        return color;
    }

    public float getSaturation() {
        return saturation;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    public double area() {
        return 2.0;
    }
}
