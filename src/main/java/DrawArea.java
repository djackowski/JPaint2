import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;


public class DrawArea extends JComponent{

    private Image image;
    private Graphics2D graphics2D;
    private int currentX;
    private int currentY;
    private int oldX;
    private int oldY;

    public DrawArea() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();

                if(graphics2D != null) {
//                    graphics2D.drawLine(oldX, oldY, currentX, currentY);
                    graphics2D.draw(new Line2D.Double(40, oldY, currentX, currentY));
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }

            }
        });
    }

    protected void paintComponent(Graphics graphics) {
        if(image == null) {
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        graphics.drawImage(image, 0, 0, null);
    }

    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

   /* public void red() {
        graphics2D.setPaint(Color.red);
    }

    public void black() {
        graphics2D.setPaint(Color.black);
    }

    public void green() {
        graphics2D.setPaint(Color.green);
    }

    public void blue() {
        graphics2D.setPaint(Color.blue);
    }

*/
}
