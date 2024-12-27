
public interface BasicShape {

    /**
    * Returns an array of all the Line objects of this BasicShape
    * @return an array of all the Line objects 
    */
    public abstract Line[] getLines();

    /**
    * Returns an array of all the Point objects of this BasicShape
    * @return an array of all the Point objects 
    */
    public abstract Point[] getPoints();

    /**
    * Returns the center Point of the BasicShape
    * @return a Point that is the BasicShape's center
    */
    public abstract Point getCenter();

    /**
    * Rotates a this instance of BasicShape by a specified angle about its center
    * @param b this instance of BasicShape
    * @param angle the angle, in radians, to rotate all the points around by the shape's center.
    */
    public default void rotate(BasicShape b, double angle){
        Point saveCenter = getCenter();
        for (int i = 0; i < b.getLines().length; i++){
            b.getLines()[i].getFirstPoint().rotateAbout(saveCenter, angle);
            System.out.println();
        }
    }

}