import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    private int[][] tab;
    private int row;
    private int coll;

    public Save(int[][] tab, int row, int coll, Board board) {
        this.tab = tab;
        this.row = row;
        this.coll = coll;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < coll; j++) {
                for (int x = 0; x < tab.length; x++) {
                    this.tab[x] = tab[x].clone();
                }
            }
        }
    }

    public void save() {
        File myFile = new File("example.txt");
        try {
            FileWriter writer = new FileWriter(myFile);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < coll; j++) {
                    if ((tab[i][j]) == 1) {
                        String text = "Yellow i=" + i + ", j=" + j + ";";
                        writer.write(text);
                        writer.append('\n');
                        writer.flush();
                    }
                    if ((tab[i][j]) == 2) {
                        String text = "Red i=" + i + ", j=" + j + ";";
                        writer.write(text);
                        writer.append('\n');
                        writer.flush();
                    }
                    if ((tab[i][j]) == 3) {
                        String text = "Blue i=" + i + ", j=" + j + ";";
                        writer.write(text);
                        writer.append('\n');
                        writer.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

