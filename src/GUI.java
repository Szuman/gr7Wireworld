import javax.swing.*;

public class GUI {
JFrame frame;

public void createGUI() {
    frame = new JFrame("WireWorld");
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    }
}
