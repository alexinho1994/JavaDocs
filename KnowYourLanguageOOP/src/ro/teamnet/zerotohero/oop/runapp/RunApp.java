package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.exceptions.MyException;
import ro.teamnet.zerotohero.oop.exceptions.PosException;
import ro.teamnet.zerotohero.oop.exceptions.RadiusException;
import ro.teamnet.zerotohero.oop.graphicshape.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Alexandru.Grameni on 7/4/2017.
 */
public class RunApp {

    public static void main(String args[]) throws Exception {
        Circles c = new Circles();
        System.out.println("The default circle area is " + c.getAreaPub());
        c.getAreaDef();
        Canvas canv = new Canvas();

        Shape sh = new Circle(10);
        sh.area();
        ShapeBehaviour sb = new Square(10);
        sb.area();

       // Square square = new Square(-1);

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));


        ImmutableClass fg = new ImmutableClass(4, 10);

        try{
            Square sq = new Square(10, 4, 2);
        }
        finally{
            System.out.println("try/finally statement");
        }

        /*try(BufferedReader br = new BufferedReader(new FileReader(""))){
            br.read();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }*/

        try {
            Circle crc = new Circle(-1, 3, -2);
        }
        catch(RadiusException | PosException e)
        {
            e.printStackTrace();
        }
        /*catch (PosException e)
        {
            e.printStackTrace();
        }*/

    }

}
