package com.wireworld;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private int[][] tab;
    private int row;
    private int coll;
    private Board boardPanel;
    private int pointSize;

    public Board(int [][] tab, int row, int coll, Board boardPanel, int pointSize) {
        this.row = row;
        this.coll = coll;
        this.tab = tab;
        this.boardPanel = boardPanel;
        this.pointSize = pointSize;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < coll; j++) {
                if (tab[i][j] == 0) {
                    g.setColor(Color.black);
                    g.fillRect(i * pointSize, j * pointSize, pointSize, pointSize);
                }
                else if (tab[i][j] == 1) {
                    g.setColor(Color.yellow);
                    g.fillRect(i * pointSize, j * pointSize, pointSize, pointSize);
                }
                else if (tab[i][j] == 2) {
                    g.setColor(Color.blue);
                    g.fillRect(i * pointSize, j * pointSize, pointSize, pointSize);
                }
                else if (tab[i][j] == 3) {
                    g.setColor(Color.red);
                    g.fillRect(i * pointSize, j * pointSize, pointSize, pointSize);
                }
            }
        }
    }
}
