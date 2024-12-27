
public class Tester{

  public static void main (String[] args){
    Point p = new Point(100, 100);
    Point p3 = new Point (500, 500);
    EquilateralTriangle t = new EquilateralTriangle(p3, 300);
    Square s = new Square(p3, 300);
    NGon n = new NGon(p3,7);
    DrawingPad dr = new DrawingPad(700, 700);
    SnowflakeFractal<NGon> f = new SnowflakeFractal<NGon>(n, 4);
    //f.setNumLevels(1);
    BasicShape[] b = {f};
    dr.draw(b);

    for (Point poi : f.getBaseShape().getPoints()){
      System.out.println(poi.getY() + "  X: " + poi.getX());

    }
    System.out.println(f.getCenter().getX() +" Y: " +f.getCenter().getY());
  

    /*(From upper left corner clockwise, with default size 100)
      expected: 200 250
      200 350
      286.6 400
      373.2 350
      373.2 250
      286.6 200

    
    */

  }
      
  
    
}