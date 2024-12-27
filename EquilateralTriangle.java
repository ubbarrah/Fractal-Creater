public class EquilateralTriangle extends Triangle implements RegularPolygon{

    private double sideLength;

    /**
    * The EquilateralTriangle constructor
    * @param center the center of the equilateral triangle
    * @param sideLength the length of each side of the equilateral triangle.
    */
    public EquilateralTriangle(Point center, double sideLength){
        super(new Point(center.getX(), center.getY()-((Math.sqrt(3)*sideLength)/3)), 
            new Point(center.getX()+(sideLength/2), center.getY()+(Math.sqrt(3)*sideLength)/6),
            new Point(center.getX()-(sideLength/2), center.getY()+(Math.sqrt(3)*sideLength)/6));
        this.sideLength = sideLength;
    }
    /**
    * Returns the current sideLength of this EquilateralTriangle
    * @return a double recording the sideLength of the EquilateralTriangle
    */
    public double getSideLength(){
        return sideLength;
    }
    /**
    * Sets the sideLength of EquilateralTriangle to a new value
    * @param newSideLength the new sideLength the EquilateralTriangle's sideLength will be changed to
    */
    public void setSideLength(double newSideLength){
        getPoints()[1].setX(newSideLength/2+getCenter().getX());
        getPoints()[1].setY(getPoints()[0].getY()+(Math.sqrt(3)*newSideLength/2));
        getPoints()[2].setX(newSideLength/2-getCenter().getX());
        getPoints()[2].setY(getPoints()[0].getY()+(Math.sqrt(3)*newSideLength/2));
        sideLength = newSideLength;
    }
}