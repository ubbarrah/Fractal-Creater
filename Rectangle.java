public class Rectangle extends Polygon{
    private double width;
    private double height;
    private Point center;
    
    /**
    * The Rectangle constructor
    * @param center the list of Point objects the Rectangle will be initialized to have
    * @param width the desired width of the Rectangle
    * @param height the desired height of the Rectangle
    */
    public Rectangle(Point center, double width, double height){
        super(new Point[] {new Point(center.getX()-width/2, center.getY()-height/2), new Point (center.getX()+width/2, center.getY()-height/2),
            new Point(center.getX()+width/2, center.getY()+height/2), new Point (center.getX()-width/2, center.getY()+height/2)});
            
        this.center = center;
        this.width = width;
        this.height = height;
    }

    /**
    * Returns the width of the rectangle
    * @return a double recording the width of the rectangle
    */
    public double getWidth(){
        return this.width;
    }
    /**
    * Returns the height of the rectangle
    * @return a double recording the height of the rectangle
    */
    public double getHeight(){
        return this.height;
    }
    /**
    * Changes the width of the rectangle to a new value
    * @param newWidth the new width to be treated as the rectangle's new width    
    */
    public void setWidth(double newWidth){
        this.width = newWidth;
        getPoints()[1].setX(getPoints()[0].getX()+newWidth);
        getPoints()[2].setX(getPoints()[0].getX()+newWidth);
    }
    /**
    * Changes the height of the rectangle to a new value
    * @param newHeight the new height to be treated as the rectangle's new height    
    */
    public void setHeight(double newHeight){
        this.height = newHeight;
        getPoints()[2].setY(getPoints()[0].getY()+newHeight);
        getPoints()[3].setY(getPoints()[0].getY()+newHeight);
    }

}