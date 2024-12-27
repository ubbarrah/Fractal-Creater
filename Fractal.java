public abstract class Fractal<T extends Polygon> implements BasicShape{
    
    public Point[] basePoints;
    
    public Fractal (Point[] basePoints){
        this.basePoints = new Point[basePoints.length];
        for(int i=0; i < basePoints.length; i++){
            this.basePoints[i] = basePoints[i];
        }
    }

    public Point getCenter(){
        double sumX = 0;
        double sumY = 0;
        for (int i = 0; i < getPoints().length; i++){
            sumX+= getPoints()[i].getX();
            sumY+= getPoints()[i].getY();
        }
        return new Point (sumX/getPoints().length, sumY/getPoints().length);
    }

    public void setCenter(Point newCenterPoint){
        Point saveCenter = getCenter();
        for (int i = 0; i < getPoints().length; i++){
            getPoints()[i].setX(getPoints()[i].getX() - (saveCenter.getX()-newCenterPoint.getX()));
            getPoints()[i].setY(getPoints()[i].getY() - (saveCenter.getY()-newCenterPoint.getY()));
        }
    }

    public Line[] getLines(){
        Line[] lines = new Line[getPoints().length];
        for (int i = 0; i < lines.length-1; i++){
            lines[i] = new Line(getPoints()[i], getPoints()[i+1]);
        }
        lines[lines.length-1] = new Line(getPoints()[lines.length-1], getPoints()[0]);
        return lines;
    }

    public abstract Point[] getPoints();

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
