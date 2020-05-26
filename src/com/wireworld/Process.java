package com.wireworld;

public class Process {
    private final int [][]tab;
    private final int row;
    private final int coll;
    private final Board board;


    public Process (int[][] tab, int row, int coll, Board board) {
        this.tab = tab;
        this.row = row;
        this.coll = coll;
        this.board = board;
    }
    int neighborhood_counter(int x, int y)
    {
        if (x < 0 || x >= row || y < 0 || y >= coll || tab[x][y] != 2)
            return 0;
        else
            return 1;
    }

    public void processOfWorld() {
        int[][] tab2 = new int[row][coll];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < coll; j++) {
               tab2[i][j] = tab[i][j];
               if (tab[i][j] == 2)
                   tab2[i][j] = 3;
               if (tab[i][j] == 3)
                    tab2[i][j] = 1;
               if (tab[i][j] == 1) {
                   int counter = 0;
                   counter += neighborhood_counter( i, j-1);
                   counter += neighborhood_counter( i, j+1);
                   counter += neighborhood_counter(i-1, j-1);
                   counter += neighborhood_counter(i-1, j);
                   counter += neighborhood_counter(i-1, j+1);
                   counter += neighborhood_counter(i+1, j-1);
                   counter += neighborhood_counter(i+1, j);
                   counter += neighborhood_counter(i+1, j+1);
                   if (counter == 1 || counter == 2)
                       tab2[i][j] = 2;
               }

            }
        }
        for (int x = 0; x < row; x++)
            System.arraycopy(tab2[x], 0, tab[x], 0, row);
        board.repaint();
    }
}
