import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {

    private List<Shape> shapes;
    private List<Shape> clearedShapes;
    private Shape currentShape;
    private ShapeType currentShapeType;
    private Color currentShapeColor;
    private String currentLineThick;
    private boolean currentShapeFilled;
    private int currentX;
    private int currentY;
    private int oldX;
    private int oldY;
    private Color currentShapeFilledColor;


    public DrawPanel() {
        shapes = new ArrayList<Shape>();
        clearedShapes = new ArrayList<Shape>();

        currentShapeType = ShapeType.LINE;

        MouseHandler mouseHandler = new MouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : shapes) {
            shape.draw(g);
        }
        if (currentShape != null)
            currentShape.draw(g);

    }

    public void clearLast() {
        if (!shapes.isEmpty()) {
            clearedShapes.add(shapes.remove(shapes.size() - 1));
            repaint();
        }
    }

    public void redoLast() {
        if (!clearedShapes.isEmpty()) {
            shapes.add(clearedShapes.remove(clearedShapes.size() - 1));
            repaint();
        }
    }

    public void clearDrawing() {
        shapes.clear();
        clearedShapes.clear();
        repaint();
    }

    public void setCurrentShapeColor(Color color) {
        currentShapeColor = color;
    }

    public void setCurrentLineThick(String lineThickOption) {
        currentLineThick = lineThickOption;
    }

    public void setCurrentShapeFilled(boolean checkFill) {
        currentShapeFilled = checkFill;
    }

    public void setCurrentShapeFilledColor(Color color) {
        currentShapeFilledColor = color;
    }
    private class MouseHandler extends MouseAdapter {

        public void mousePressed(MouseEvent event) {
            oldX = event.getX();
            oldY = event.getY();
            System.out.println(event.getX() + " " + event.getY());
            switch (currentShapeType) {
                case LINE:
                    currentShape = new Line(event.getX(), event.getY(),
                            event.getX(), event.getY(), currentShapeColor, currentLineThick, false, null);
//                    System.out.println(event.getX() + "  " + event.getY());
                    break;
                case RECTANGLE:
                    currentShape = new DrawRectangle(event.getX(), event.getY(),
                            event.getX(), event.getY(), currentShapeColor, currentLineThick, currentShapeFilled, currentShapeFilledColor);
                    break;
                case OVAL:
                    currentShape = new DrawElipse(event.getX(), event.getY(),
                            event.getX(), event.getY(), currentShapeColor, currentLineThick, currentShapeFilled, currentShapeFilledColor);
//                    System.out.println(event.getX() + "  " + event.getY());
                    break;

            }
        }

        public void mouseReleased(MouseEvent event) {
            currentShape.setX2(currentX);
            currentShape.setY2(currentY);

            shapes.add(currentShape);

            currentShape = null;
            clearedShapes.clear();
            repaint();

        }

        public void mouseDragged(MouseEvent event) {
            currentX = event.getX();
            currentY = event.getY();

            currentShape.setX2(currentX);
            currentShape.setY2(currentY);

            repaint();

        }

    }

    public void setCurrentShapeType(int i) {
        switch (i) {
            case 0:
                currentShapeType = ShapeType.LINE;
                break;
            case 1:
                currentShapeType = ShapeType.RECTANGLE;
                break;
            case 2:
                currentShapeType = ShapeType.OVAL;
                break;

        }
    }

    public enum ShapeType {
        LINE,
        OVAL,
        RECTANGLE
    }
}
