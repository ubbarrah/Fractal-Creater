public class NGon implements RegularPolygon, BasicShape{
    private Point center;
    private int numSides;
    private Point[] points;



    /**
    * Create a NGon containing the given center and an arbitrary number of sides. For odd numbers of sides, the polyogn appears upside-down.
    * @param center the center of the NGon
    * @param numSides the number of sides to be used for the NGon
    */
    public NGon(Point center, int numSides){
        double defaultLength = 100;
        Point[] initialPoints = new Point[numSides];
        initialPoints[0] = new Point(center.getX()-(defaultLength)/2, 
        center.getY()-(defaultLength));
        initialPoints[1] = new Point(center.getX()+(defaultLength)/2, 
        center.getY()-(defaultLength));
        for (int i = 2 ; i < numSides; i++){
            initialPoints[i] = new Point(initialPoints[i-1].getX()+(initialPoints[i-1].getX() - initialPoints[i-2].getX()),
            initialPoints[i-1].getY()+(initialPoints[i-1].getY() - initialPoints[i-2].getY()));

            initialPoints[i].rotateAbout(initialPoints[i-1], 2*Math.PI/numSides);
            
        }
        this.points = initialPoints;
        this.center = center;
        this.numSides = numSides;

    }
    /**
    * Returns the current sideLength of this NGon
    * @return a double recording the sideLength of the NGon
    */
    public double getSideLength(NGon n){
       return Math.sqrt((this.getPoints()[1].getX() - this.getPoints()[0].getX()) * (this.getPoints()[1].getX() - this.getPoints()[0].getX()) +
       (this.getPoints()[1].getY() - this.getPoints()[0].getY()) * (this.getPoints()[1].getY() - this.getPoints()[0].getY()));
       
    }
    
    /**
    * Returns the center Point of the NGon
    * @return a Point that is the NGon's center
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
    * Returns an array of all the Line objects of this NGon
    * @return an array of all the NGon objects
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
    * Returns an array of all the Point objects of this NGon
    * @return an array of all the Point objects
    */
    public Point[] getPoints(){
        return this.points;
    }
    /**
    * Returns the number of sides this NGon has
    * @return an int of how many sides this NGon has
    */
    public int getNumSides(){
        return this.numSides;
    }

    /**
    * Sets the sideLength of NGon to a new value
    * @param newSideLength the new sideLength the NGon's sideLength will be changed to
    */
    public void setSideLength(double newSideLength){
        getPoints()[1].setX(getPoints()[0].getX() + newSideLength);
        for (int i = 2; i < numSides; i++){
            getPoints()[i].setX(getPoints()[i-1].getX() + (getPoints()[i-1].getX() - getPoints()[i-2].getX()));
            getPoints()[i].setY(getPoints()[i-1].getY() + (getPoints()[i-1].getY() - getPoints()[i-2].getY()));
            getPoints()[i].rotateAbout(getPoints()[i-1], -360/getNumSides());

        }
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