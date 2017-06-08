import java.awt.*;

public class Line extends Shape {

    public Line(int x1, int y1, int x2, int y2, Color color, String currentLineThick, boolean o, Color o1) {
        super(x1, y1, x2, y2, color, currentLineThick, o, o1);

    }

    public void draw(Graphics g) {
        super.draw(g);
        g.drawLine(x1, y1, x2, y2);
    }
}
