public class SnowflakeFractal<T extends RegularPolygon> extends Fractal<Polygon>{

    private Point[] fractalPoints;
    private int numSides;
    private int baseNumSides;
    private T baseShape;
    private int levels;


    public SnowflakeFractal(T baseShape, int levels){
        super(baseShape.getPoints());
        this.baseShape = baseShape;
        this.levels = levels;

        baseNumSides = baseShape.getPoints().length;
        numSides = baseNumSides;
        //fractalPoints = new Point[(int)Math.pow(numSides, levels+1)];
        fractalPoints = new Point[baseNumSides];
        // for (int i = 0; i < numSides; i++){
        //     fractalPoints[(int)Math.pow(numSides,1) * i] = baseShape.getPoints()[i];
        // }
        for (int i=0; i < numSides; i++){
            fractalPoints[i] = baseShape.getPoints()[i];
        }
        System.out.println(fractalPoints.length);
        for (int h = 0 ; h < levels ; h++){
            Point[] save = fractalPoints;
            fractalPoints = new Point[baseNumSides*(int)Math.pow(4, h+1)];
            for (int i = 0; i < save.length; i++){
                fractalPoints[4 * i] = save[i]; 
            }
            

            for (int i=0; i < numSides; i++){
                fractalPoints[i*4+1] = new Point(
                fractalPoints[4*i].getX()+(fractalPoints[4*(i+1) % fractalPoints.length].getX() -fractalPoints[4*i % fractalPoints.length].getX())/3, 
                fractalPoints[4*i].getY()+(fractalPoints[4*(i+1) % fractalPoints.length].getY() -fractalPoints[4*i % fractalPoints.length].getY())/3);
                fractalPoints[i*4+2] = new Point(
                fractalPoints[4*i].getX()+2*(fractalPoints[4*(i+1) % fractalPoints.length].getX() -fractalPoints[4*i % fractalPoints.length].getX())/3, 
                fractalPoints[4*i].getY()+2*(fractalPoints[4*(i+1) % fractalPoints.length].getY() -fractalPoints[4*i % fractalPoints.length].getY())/3);
                fractalPoints[i*4+2].rotateAbout(fractalPoints[(i*4+1) % fractalPoints.length], -Math.PI/3);
                fractalPoints[i*4+3] = new Point(
                fractalPoints[4*i].getX()+2*(fractalPoints[4*(i+1) % fractalPoints.length].getX() -fractalPoints[4*i % fractalPoints.length].getX())/3, 
                fractalPoints[4*i].getY()+2*(fractalPoints[4*(i+1) % fractalPoints.length].getY() -fractalPoints[4*i % fractalPoints.length].getY())/3);
                
            }
            numSides *= 4;

        }
        
        //for 

    }

    public Point[] getPoints(){
        return fractalPoints;
    }

    public T getBaseShape(){
        return baseShape;
    }

    public int getNumLevels(){
        return levels;
    }

    public void setNumLevels(int newLevels){
        if (newLevels > this.levels){
            for (int h = this.levels ; h < newLevels ; h++){
                Point[] save = fractalPoints;
                fractalPoints = new Point[baseNumSides * (int)Math.pow(4, h+1)];
                for (int i = 0; i < save.length; i++){
                    fractalPoints[4 * i] = save[i]; 
                }
                

                for (int i=0; i < numSides; i++){
                    fractalPoints[i*4+1] = new Point(
                    fractalPoints[4*i].getX()+(fractalPoints[4*(i+1) % fractalPoints.length].getX() -fractalPoints[4*i % fractalPoints.length].getX())/3, 
                    fractalPoints[4*i].getY()+(fractalPoints[4*(i+1) % fractalPoints.length].getY() -fractalPoints[4*i % fractalPoints.length].getY())/3);
                    fractalPoints[i*4+2] = new Point(
                    fractalPoints[4*i].getX()+2*(fractalPoints[4*(i+1) % fractalPoints.length].getX() -fractalPoints[4*i % fractalPoints.length].getX())/3, 
                    fractalPoints[4*i].getY()+2*(fractalPoints[4*(i+1) % fractalPoints.length].getY() -fractalPoints[4*i % fractalPoints.length].getY())/3);
                    fractalPoints[i*4+2].rotateAbout(fractalPoints[(i*4+1) % fractalPoints.length], -Math.PI/3);
                    fractalPoints[i*4+3] = new Point(
                    fractalPoints[4*i].getX()+2*(fractalPoints[4*(i+1) % fractalPoints.length].getX() -fractalPoints[4*i % fractalPoints.length].getX())/3, 
                    fractalPoints[4*i].getY()+2*(fractalPoints[4*(i+1) % fractalPoints.length].getY() -fractalPoints[4*i % fractalPoints.length].getY())/3);
                    
                }
                numSides *= 4;

            }
        } else if (newLevels < this.levels) {
            for (int h = 0; h < this.levels - newLevels; h++){
                Point[] save = fractalPoints;
                fractalPoints = new Point[save.length/4];
                for (int i = 0; i < fractalPoints.length; i++){
                    fractalPoints[i] = save[4*i];
                }
            }
            this.levels = newLevels;
        }
    }




}