public abstract class Polygon implements BasicShape {
    private Point[] points;
    /**
    * The Polygon constructor
    * @param points the list of Point objects the Polygon will be initialized to have
    */
    public Polygon (Point[] points){
        this.points = new Point[points.length];
        for(int i=0; i < points.length; i++){
            this.points[i] = points[i];
        }
    }

    /**
    * Returns the center Point of the polygon
    * @return a Point that is the polygon's center
    */
    public Point getCenter(){
        int sumX = 0;
        int sumY = 0;
        for (int i = 0; i < getPoints().length; i++){
            sumX+= getPoints()[i].getX();
            sumY+= getPoints()[i].getY();
        }
        return new Point (sumX/getPoints().length, sumY/getPoints().length);
    }
    
    /**
    * Changes the polygon's center point to a new, specified point
    * @param newCenterPoint the new Point to be treated as the polygon's new center
    */
    public void setCenter(Point newCenterPoint){
        Point saveCenter = getCenter();
        for (int i = 0; i < getPoints().length; i++){
            getPoints()[i].setX(getPoints()[i].getX() - (saveCenter.getX()-newCenterPoint.getX()));
            getPoints()[i].setY(getPoints()[i].getY() - (saveCenter.getY()-newCenterPoint.getY()));
        }
    }

     /**
    * Returns an array of all the Line objects of this polygon
    * @return an array of all the Line objects
    */
    public Line[] getLines(){
        Line[] lines = new Line[getPoints().length];
        for (int i = 0; i < lines.length-1; i++){
            lines[i] = new Line(getPoints()[i], getPoints()[i+1]);
        }
        lines[lines.length-1] = new Line(getPoints()[lines.length-1], getPoints()[0]);
        return lines;
    }

    /**
    * Returns an array of all the Point objects of this polygon
    * @return an array of all the Point objects
    */
    public Point[] getPoints(){
        return points;
    }


    /**
    * Returns whether the point "equals" another point, if the distance between the two is less than or equal to .000001
    * @param o the Polygon that we are comparing the current instance of polygon to
    * @return a boolean stating if two polygons have all equal points
    */
    @Override
    public boolean equals(Object o){
        for (int i = 0; i < getPoints().length; i++){
            if (o instanceof Polygon){
                Polygon p = (Polygon)o;
                if (!getPoints()[i].equals(p.getPoints()[i])){
                    
                    return false;
                }
            }   
        }
        return true;
    }
    
}   
