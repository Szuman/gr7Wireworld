import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Hashtable;

public class GUI implements Runnable {

    JFrame frame;
    Board board;

    final int boardSize = 50;
    final int pointSize = 10;
    final int tab[][] = new int[boardSize][boardSize];
    final int mouseButtonLeft = 1;
    final int mouseButtonRight = 3;
    final int frameSize = (boardSize + 1) * pointSize + 3;

    @Override
    public void run() {
        createGUI();
        System.out.println(SwingUtilities.isEventDispatchThread());
    }

    public void createGUI() {
        frame = new JFrame("WireWorld");
        frame.setSize(frameSize + 3, frameSize + 105);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        options();
        frame.setVisible(true);
        }

    public void options() {
        JButton stepB = new JButton("Step");
        JButton clearB = new JButton("Clear");
        JButton saveB = new JButton("Save");
        JButton loadB = new JButton("Load");
        JToggleButton playB = new JToggleButton("Play");
        JSlider fastS = new JSlider(JSlider.HORIZONTAL, 1, 700, 350);

        Hashtable lTable = new Hashtable();
        lTable.put(50, new JLabel("Slow"));
        lTable.put(650, new JLabel("Fast"));
        fastS.setLabelTable(lTable);
        fastS.setPaintLabels(true);

        if (playB.isSelected())
            playB.setText("Stop");
        else
            playB.setText("Play");

        JPanel controlPanel = new JPanel();
        controlPanel.add(stepB);
        controlPanel.add(fastS);
        controlPanel.add(playB);
        controlPanel.add(clearB);

        JPanel optFilePanel = new JPanel();
        optFilePanel.add(saveB);
        optFilePanel.add(loadB);

        board = new Board(tab, boardSize, boardSize, board, pointSize);
        board.setBackground(Color.white);

        board.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int x = e.getX() / pointSize;
                int y = e.getY() / pointSize;
                if (e.getButton() == mouseButtonLeft) {
                    if (tab[x][y] != 1) {
                        tab[x][y] = 1;
                            board.addMouseMotionListener(new MouseMotionAdapter() {
                                @Override
                                public void mouseDragged(MouseEvent e) {
                                    super.mouseDragged(e);
                                    int x = e.getX() / pointSize;
                                    int y = e.getY() / pointSize;
                                    try {
                                        tab[x][y] = 1;
                                        board.repaint();
                                    } catch (ArrayIndexOutOfBoundsException ew) {
                                        System.out.println("Out of board");
                                    }
                                }
                            });
                    }
                    else
                        tab[x][y] = 0;
                    }
                if (e.getButton() == mouseButtonRight) {
                    if (tab[x][y] != 2)
                        tab[x][y] = 2;
                    else
                        tab[x][y] = 3;
                }
                board.repaint();
            }
        });


        frame.getContentPane().add(BorderLayout.NORTH ,controlPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, optFilePanel);
        frame.getContentPane().add(BorderLayout.CENTER, board);

    }


}
