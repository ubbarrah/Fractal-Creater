
public class Point {
    private double x;
    private double y;
    /**
    * Create a Point containing the given X and Y position
    * @param x the x position of the Point
    * @param y the y position of the Point
    */
    public Point (double x,double y){

        this.x = x;
        this.y = y;
    }
    /**
    * Return the X position of the Point
    * @return the X poisition of the Point
    */
    public double getX(){
        return this.x;
    }
    /**
    * Return the Y position of the Point
    * @return the Y position of the Point
    */
    public double getY(){
        return this.y;
    }
    /**
    * Change the X position of the Point
    * @param newX the new X position of the Point
    */
    public void setX(double newX){
        this.x = newX;
    }
    /**
    * Change the Y position of the Point
    * @param newY the new Y position of the Point
    */
    public void setY(double newY){
        this.y = newY;
    }
    /**
    * Rotates the Point about another point according to a given angle counterclockwise
    * @param originPoint the Point that this Point is rotated about
    * @param angle the angle, in radians, by which we rotate this point around the originPoint counterclockwise
    */
    public void rotateAbout(Point originPoint, double angle){
        double saveX = this.getX();
        double saveY = this.getY();
        this.setX(originPoint.getX()+ ((saveX-originPoint.getX())*Math.cos(angle) - (saveY-originPoint.getY())*Math.sin(angle)));
        this.setY(originPoint.getY()+((saveX-originPoint.getX())*Math.sin(angle) + (saveY-originPoint.getY())*Math.cos(angle)));
        
        //+ (this.getY()-originPoint.getY())*Math.cos(angle));
    }

    @Override
    public boolean equals (Object o){
        if (o instanceof Point){
            Point p = (Point)o;
            return Math.sqrt((this.getX() - p.getX())*(this.getX() - p.getX()) 
            + (this.getY() - p.getY())*(this.getY() - p.getY())) <= .000001;
        }
        return false;
    }

        
}
