package com.wireworld;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.Timer;

public class GUI implements Runnable {

    JFrame frame;
    JButton stepB, clearB, saveB, loadB;
    JSlider fastS;
    JComboBox strBox;

    Board board;
    Process process;
    Diodes diode;

    final int boardSize = 60;
    final int pointSize = 10;
    final int[][] tab = new int[boardSize][boardSize];
    final int mouseButtonLeft = 1;
    final int mouseButtonRight = 3;
    final int frameSize = (boardSize + 1) * pointSize + 3;
    final int maxSpeed = 700;
    String [] structures = {"Normal", "diodeLeft", "diodeRight", "diodeUp", "diodeDown", "OR", "AND", "XOR", "AND-NOT"};
    int Speed = 350;
    private final JToggleButton playB = new JToggleButton("Play");
    List<String> struct = new ArrayList<>();

    @Override
    public void run() {
        createGUI();
        System.out.println(SwingUtilities.isEventDispatchThread());
    }

    private void createGUI() {
        frame = new JFrame("WireWorld");
        frame.setSize(frameSize + 3, frameSize + 105);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("heart.png"));
            frame.setIconImage(icon);
        } catch (Exception e) {
            System.out.println("Can't set/find icon image - setting default icon");
        }
        options();
        setupBoard();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        }


    private void options() {
        stepB = new JButton("Step");
        stepB.addActionListener(new ButtonStep());
        clearB = new JButton("Clear");
        clearB.addActionListener(new ButtonClear());
        saveB = new JButton("Save");
        saveB.addActionListener(new ButtonSave());
        loadB = new JButton("Load");
        loadB.addActionListener(new ButtonLoad());
        strBox = new JComboBox(structures);
        fastS = new JSlider(JSlider.HORIZONTAL, 1, maxSpeed, 350);
        playB.addItemListener(new ButtonPlay());

        Hashtable lTable = new Hashtable();
        lTable.put(50, new JLabel("Slow"));
        lTable.put(650, new JLabel("Fast"));
        fastS.setLabelTable(lTable);
        fastS.setPaintLabels(true);

        fastS.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                Speed = (maxSpeed+1)-source.getValue();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(stepB);
        controlPanel.add(fastS);
        controlPanel.add(playB);
        controlPanel.add(clearB);

        JPanel optFilePanel = new JPanel();
        optFilePanel.add(saveB);
        optFilePanel.add(loadB);
        optFilePanel.add(strBox);


        frame.getContentPane().add(BorderLayout.NORTH ,controlPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, optFilePanel);

    }

    private void setupBoard() {
        board = new Board(tab, boardSize, boardSize, pointSize);
        board.setBackground(Color.white);
        diode = new Diodes();

        board.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int x = e.getX() / pointSize;
                int y = e.getY() / pointSize;
                if (e.getButton() == mouseButtonLeft) {
                    switch (strBox.getSelectedIndex()) {
                        case 1: diode.addDiodeLeft(tab, x, y);
                                struct.add("DiodeLeft x=" + x + ", y=" + y +";");
                        break;
                        case 2: diode.addDiodeRight(tab, x, y);
                                struct.add("DiodeRight x=" + x + ", y=" + y +";");
                        break;
                        case 3: diode.addDiodeUp(tab, x, y);
                                struct.add("DiodeUp x=" + x + ", y=" + y +";");
                        break;
                        case 4: diode.addDiodeDown(tab, x, y);
                                struct.add("DiodeDown x=" + x + ", y=" + y +";");
                        break;
                        case 5: diode.addOR(tab, x, y);
                                struct.add("ORgate x=" + x + ", y=" + y +";");
                        break;
                        case 6: diode.addAND(tab, x, y);
                                struct.add("ANDgate x=" + x + ", y=" + y +";");
                        break;
                        case 7: diode.addXOR(tab, x, y);
                                struct.add("GateXOR x=" + x + ", y=" + y +";");
                        break;
                        case 8: diode.addANDNOT(tab, x, y);
                                struct.add("ANDNOTgate x=" + x + ", y=" + y +";");
                        break;
                        default:
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
                            } else
                                tab[x][y] = 0;
                    }
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

        frame.getContentPane().add(BorderLayout.CENTER, board);
    }

    Timer t;
    public class ButtonPlay implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            playB.setText(playB.isSelected() ? "Stop" : "Play");
            if (playB.isSelected()) {
                t = new Timer();
                t.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        process = new Process(tab, boardSize, boardSize, board);
                        process.processOfWorld();
                    }
                }, 0, Speed);
            }
            else t.cancel();
        }
    }
    public class ButtonStep implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            process = new Process(tab, boardSize, boardSize, board);
            process.processOfWorld();
        }
    }
    public class ButtonClear implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            Clear CLEAR = new Clear(tab, boardSize, boardSize, board);
            CLEAR.CLEAR();
            struct.clear();
        }
    }
    public class ButtonSave implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            Save saveF = new Save(tab, boardSize, boardSize, struct);
            saveF.save();
        }
    }
    public class ButtonLoad implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            Load loadFile = new Load(tab, board, struct);
            loadFile.load();
        }
    }
}
