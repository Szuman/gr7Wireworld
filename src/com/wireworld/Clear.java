package com.wireworld;

public class Clear {
    private int[][] tab;
    private int row;
    private int coll;
    private Board boardPanel;

    public Clear(int[][] tab, int row, int coll, Board boardPanel) {
        this.tab = tab;
        this.row = row;
        this.coll = coll;
        this.boardPanel = boardPanel;
    }

    public void CLEAR() {
for (int i = 0; i < row ; i++) {
            for (int j = 0; j < coll; j++) {
                tab[i][j] = 0;
            }
        }
    boardPanel.repaint();
    }

}

