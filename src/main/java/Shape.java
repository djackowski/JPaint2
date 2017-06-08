import java.awt.*;

public abstract class Shape {
    protected int x1, x2, y1, y2;
    protected Color color;
    private String currentLineThick;
    protected boolean currentShapeFilled;
    private Color currentShapeFilledColor;


    public Shape(int x1, int y1, int x2, int y2, Color color, String currentLineThick, boolean currentShapeFilled, Color currentShapeFilledColor) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
        this.currentLineThick = currentLineThick;
        this.currentShapeFilled = currentShapeFilled;
        this.currentShapeFilledColor = currentShapeFilledColor;
    }


    public Color getCurrentShapeFilledColor() {
        return currentShapeFilledColor;
    }

    public void setCurrentShapeFilledColor(Color currentShapeFilledColor) {
        this.currentShapeFilledColor = currentShapeFilledColor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void draw(Graphics g ) {
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        int thickInteger = ThickConverter.getThickInteger(currentLineThick);
        g2.setStroke(new BasicStroke(thickInteger));
    }
}
