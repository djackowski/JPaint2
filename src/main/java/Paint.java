import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;

public class Paint {
    private static JButton lineColor;
    private static JButton lineThick;
    private static JButton lineStyle;
    private static JButton fillStyle;
    private static JButton fillColor;
    private static JButton undo;
    private static JButton redo;
    private static JButton addPlugin;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrawFrame();
            }
        });

      /*  JFrame f = new JFrame("Draw a Red Line");
        f.setSize(300, 300);
        f.setLocation(300, 300);
        f.setResizable(false);
        JPanel p = new JPanel() {
            Point pointStart = null;
            Point pointEnd   = null;
            {
                addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        pointStart = e.getPoint();
                    }

                    public void mouseReleased(MouseEvent e) {
                        pointStart = null;
                    }
                });
                addMouseMotionListener(new MouseMotionAdapter() {
                    public void mouseMoved(MouseEvent e) {
                        pointEnd = e.getPoint();
                    }

                    public void mouseDragged(MouseEvent e) {
                        pointEnd = e.getPoint();
                        repaint();
                    }
                });
            }
            public void paint(Graphics g) {
                super.paint(g);
                if (pointStart != null) {
                    g.setColor(Color.RED);
                    g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
                }
            }
        };
        f.add(p);
        f.setVisible(true);*/


    }

    private static void show() {
        JFrame frame = new JFrame("JPaint");

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

       /* DrawArea drawArea = new DrawArea();
        container.add(drawArea, CENTER);*/
        DrawLine drawLine = new DrawLine();
        container.add(drawLine, CENTER);

        JPanel controls = new JPanel();

        lineColor = new JButton("Line Color");
        lineThick = new JButton("Line Thick");
        lineStyle = new JButton("Line Style");
        fillStyle = new JButton("Fill Style");
        fillColor = new JButton("Fill Color");
        undo = new JButton("Undo");
        redo = new JButton("Redo");
        addPlugin = new JButton("Line Color");

        controls.add(lineColor);
        controls.add(lineThick);
        controls.add(lineStyle);
        controls.add(fillStyle);
        controls.add(fillColor);
        controls.add(undo);
        controls.add(redo);
        controls.add(addPlugin);


        container.add(controls, BorderLayout.NORTH);

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
