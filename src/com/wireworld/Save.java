package com.wireworld;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Save extends Component {
    private int[][] tab;
    private int row;
    private int coll;

    public Save(int[][] tab, int row, int coll) {
        this.row = row;
        this.coll = coll;
        this.tab = tab;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < coll; j++) {
                for (int x = 0; x < tab.length; x++) {
                    this.tab[x] = tab[x].clone();
                }
            }
        }
    }

    public void save() {
        JFileChooser fc = new JFileChooser();
        fc.showSaveDialog(this);
        File f = fc.getSelectedFile();
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < coll; j++) {

                    if ((tab[i][j]) == 1) {
                        String text = "Yellow i=" + i + ", j=" + j + ";";
                        fw.write(text);
                        fw.append('\n');
                        fw.flush();
                    }
                    if ((tab[i][j]) == 2) {
                        String text = "Red i=" + i + ", j=" + j + ";";
                        fw.write(text);
                        fw.append('\n');
                        fw.flush();
                    }
                    if ((tab[i][j]) == 3) {
                        String text = "Blue i=" + i + ", j=" + j + ";";
                        fw.write(text);
                        fw.append('\n');
                        fw.flush();
                    }

                }
            }

        } catch (IOException e) {
            System.out.println("Error:" +e);
        }
    }
}