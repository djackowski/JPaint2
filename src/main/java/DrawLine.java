import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DrawLine extends JComponent {

    private Image image;
    private Graphics2D graphics2D;
    private Point pointStart;
    private Point pointEnd;

    public DrawLine() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pointStart = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pointStart = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                pointEnd = e.getPoint();
                repaint();
            }

            public void mouseMoved(MouseEvent e) {
                pointEnd = e.getPoint();
            }
        });

    }

    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }


    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        graphics.drawImage(image, 0, 0, null);

        if (pointStart != null) {
            graphics.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
        }
    }
}
