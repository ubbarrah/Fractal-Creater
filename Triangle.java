public class Triangle extends Polygon{
    private Point point1;
    private Point point2;
    private Point point3;
    /**
    * The Triangle constructor
    * @param point1 the first, uppermost point in the triangle (unrotated)
    * @param point2 the second, bottom right point in the triangle (unrotated)
    * @param point3 the third, bottom left point in the triangle (unrotated)
    */
    public Triangle(Point point1, Point point2, Point point3){
        super(new Point[] {new Point(point1.getX(), point1.getY()), 
            new Point(point2.getX(), point2.getY()), new Point (point3.getX(), point3.getY())});
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    /**
    * Returns the center Point of the Triangle
    * @return a Point that is the Triangle's center
    */
    @Override
    public Point getCenter(){
        Point midPoint1 = new Point ((this.getPoints()[1].getX()+this.getPoints()[2].getX())/2,
        (this.getPoints()[1].getY()+this.getPoints()[2].getY())/2);
        Point midPoint2 = new Point ((this.getPoints()[2].getX()+this.getPoints()[0].getX())/2,
        (this.getPoints()[2].getY()+this.getPoints()[0].getY())/2);

        double x1 = this.getPoints()[0].getX();
        double x2 = midPoint1.getX();
        double x3 = this.getPoints()[1].getX();
        double x4 = midPoint2.getX();

        double y1 = this.getPoints()[0].getY();
        double y2 = midPoint1.getY();
        double y3 = this.getPoints()[1].getY();
        double y4 = midPoint2.getY();

        double centerX = ((x1*y2 - y1*x2)*(x3-x4) - (x1-x2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        double centerY = ((x1*y2 - y1*x2)*(y3-y4) - (y1-y2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        return new Point(centerX, centerY);

    }
    /**
    * Returns the number of sides this Triangle has
    * @return an int of how many sides this Triangle has
    */
    public int getNumSides(){
        return 3;
    }

}
