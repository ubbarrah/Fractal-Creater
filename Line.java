public class Line {

    private Point firstPoint;
    private Point secondPoint;
    /**
    * Create a Line containing the given first Point object and another Point object
    * @param firstPoint the first Point object starting the line
    * @param secondPoint the second Point object ending the line
    */
    public Line (Point firstPoint, Point secondPoint){
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    /**
    * Returns the first Point in the Line
    * @return the first Point in the Line
    */
    public Point getFirstPoint() {
        return firstPoint;
    }
    /**
    * Returns the second Point in the Line
    * @return the second Point in the Line
    */
    public Point getSecondPoint() {
        return secondPoint;
    }
    /**
    * Changes the Point the Line uses as its first Point
    * @param newFirstPoint the new Point for the Line's first Point
    */
    public void setFirstPoint(Point newFirstPoint) {
        this.firstPoint = newFirstPoint;
    }
    /**
    * Changes the Point the Line uses as its second Point
    * @param newSecondPoint the new Point replacing the Line's second Point
    */
    public void setSecondPoint(Point newSecondPoint) {
        this.secondPoint = newSecondPoint;
    }
    /**
    * Returns an array of Line objects composing this Line, which is just itself
    * @return the array of Line objects
    */
    public Line[] getLines(){
        Line[] lines = {this};
        return lines;
    }
}
