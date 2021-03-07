package IharKoshman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Random;

public class BubblePanel extends JPanel {
    Random rand = new Random();
    ArrayList<Bubble> bubbleList;
    int size = 20;

    public BubblePanel() {
        bubbleList = new ArrayList<Bubble>();
        setBackground(Color.BLACK);
        //testBubbles();
        addMouseListener(new BubbleListener());
        addMouseMotionListener(new BubbleListener());
        addMouseWheelListener(new BubbleListener());
    }

    public void paintComponent (Graphics canvas) {
        super.paintComponent(canvas);
        for (Bubble bubble : bubbleList) {
            bubble.draw(canvas);
        }
    }

    public void testBubbles() {
        for (int i = 0; i < 100; ++i) {
            int x = rand.nextInt(1500);
            int y = rand.nextInt(1000);
            int size = rand.nextInt(50);
            bubbleList.add(new Bubble(x, y, size));
        }
        repaint();
    }

    public class BubbleListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            bubbleList.add(new Bubble(e.getX(), e.getY(), size));
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            bubbleList.add(new Bubble(e.getX(), e.getY(), size));
            repaint();
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            size += e.getUnitsToScroll();
        }
    }

    private class Bubble {
        private int x;
        private int y;
        private int size;
        private Color color;

        public Bubble(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.color = new Color(rand.nextInt(256),
                                    rand.nextInt(256),
                                    rand.nextInt(256));
        }

        public void draw (Graphics canvas) {
            canvas.setColor(color);
            canvas.fillOval(x - size/2, y - size/2, size, size);
        }
    }
}
