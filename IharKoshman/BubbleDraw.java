package IharKoshman;

import javax.swing.*;
import java.awt.*;

public class BubbleDraw extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ihar's BubbleDraw App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BubblePanel());
        frame.setSize(new Dimension(1500, 1000));
        frame.setVisible(true);
    }
}
