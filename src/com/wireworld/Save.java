package com.wireworld;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.List;

public class Save extends Component {
    private final int[][] tab;
    private final int row;
    private final int coll;
    private final List<String> structs;

    public Save(int[][] tab, int row, int coll, List<String> structs) {
        this.row = row;
        this.coll = coll;
        this.tab = tab;
        this.structs = structs;
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
        if (f == null)
            return;
        try {
            FileWriter fw = new FileWriter(f);
            for (String s : structs) {
                fw.write(s);
                fw.append('\n');
                fw.flush();
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < coll; j++) {
                    if ((tab[i][j]) == 2) {
                        String text = "ElectronHead x=" + i + ", y=" + j + ";";
                        fw.write(text);
                        fw.append('\n');
                        fw.flush();
                    }
                    if ((tab[i][j]) == 3) {
                        String text = "ElectronTail x=" + i + ", y=" + j + ";";
                        fw.write(text);
                        fw.append('\n');
                        fw.flush();
                    }
                    if ((tab[i][j]) == 1) {
                        String text = "Conductor x=" + i + ", y=" + j + ";";
                        fw.write(text);
                        fw.append('\n');
                        fw.flush();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }
}