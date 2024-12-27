public class Square extends Rectangle implements RegularPolygon{
    private Point center;
    /**
    * The Square constructor
    * @param center the list of Point objects the Square will be initialized to have
    * @param sideLength the desired length of one side of the square.
    */
    public Square(Point center, double sideLength){
        super(center, sideLength, sideLength);
        this.center = center;
    }
    
    /**
    * Changes the width of the square to a new value
    * @param newWidth the new width to be treated as the square's new width    
    */
    @Override
    public void setWidth(double newWidth){
        super.setWidth(newWidth);
        getPoints()[2].setY(getPoints()[0].getY()+newWidth);
        getPoints()[3].setY(getPoints()[0].getY()+newWidth);
    }

    /**
    * Changes the height of the square to a new value
    * @param newHeight the new height to be treated as the square's new height    
    */
    @Override
    public void setHeight(double newHeight){
        super.setHeight(newHeight);
        getPoints()[1].setX(getPoints()[0].getX()+newHeight);
        getPoints()[2].setX(getPoints()[0].getX()+newHeight);
    }
    public int getNumSides(){
        return 4;
    }
    public void setSideLength(double newSideLength) {
      
    }
}
