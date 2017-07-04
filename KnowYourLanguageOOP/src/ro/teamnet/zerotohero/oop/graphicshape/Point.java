package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class Point {

    private int xPos;
    private int yPos;

    public Point()
    {

    }

    public Point(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null)
            return false;
        if(other instanceof Point)
        {
            Point anotherPoint = (Point) other;
            if(xPos == anotherPoint.getxPos() && yPos == anotherPoint.getyPos())
                return true;
        }
        return false;
    }
}
