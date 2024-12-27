import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
public class DrawingPad {
    private int width;
    private int height;
    private JFrame frame;
    private Canvas canvas;
    private JPanel jpanel;
    private Graphics graphicsContext;
    public DrawingPad (int width, int height){
        this.width = width;
        this.height = height;
        this.frame = new JFrame();
        this.canvas = new Canvas();
        canvas.setSize(this.width, this.height);
        canvas.setBackground(Color.WHITE);
        this.jpanel = new JPanel();
        jpanel.add(this.canvas);
        frame.add(this.jpanel);
        frame.pack();
        frame.setVisible(true);
    }

    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public Canvas getCanvas(){
        return canvas;
    }
    public Graphics getGraphicsContext(){
        if (graphicsContext == null){
            this.graphicsContext = getCanvas().getGraphics();
            if (graphicsContext != null){
                graphicsContext.setColor(Color.BLACK);
            }
        }
        return this.graphicsContext;
    }

    public void draw(BasicShape[] allShapes){
        System.out.println(this.getGraphicsContext());
        for (BasicShape shape : allShapes){
            for (Line line : shape.getLines()){
                getGraphicsContext().drawLine((int)line.getFirstPoint().getX(), (int)line.getFirstPoint().getY(), 
                (int)line.getSecondPoint().getX(), (int)line.getSecondPoint().getY());
            }
        }
    }

    public void erase(){
        getGraphicsContext();
        getGraphicsContext().setColor(Color.WHITE);
        getGraphicsContext().fillRect(0, 0, getWidth(), getHeight());
        getGraphicsContext().setColor(Color.BLACK);
    }
}

