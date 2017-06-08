import java.awt.*;

public class DrawRectangle extends Shape {
    public DrawRectangle(int x1, int y1, int x2, int y2, Color color, String currentLineThick, boolean currentShapeFilled, Color currentShapeFilledColor) {
        super(x1, y1, x2, y2, color, currentLineThick, currentShapeFilled, currentShapeFilledColor);
    }

    public void draw(Graphics g) {
        super.draw(g);
        if(currentShapeFilled) {
            g.setColor(getCurrentShapeFilledColor());
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        } else {
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }

    public int getUpperLeftX() {
        return Math.min(getX1(), getX2());
    }

    public int getUpperLeftY() {
        return Math.min(getY1(), getY2());
    }

    public int getWidth() {
        return Math.abs(getX1() - getX2());
    }

    public int getHeight() {
        return Math.abs(getY1() - getY2());
    }
}
