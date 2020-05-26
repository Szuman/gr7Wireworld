import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Load extends Component {
    private int[][] tab;
    private Board board;

    public Load(int[][] tab, Board board) {
        this.tab = tab;
        this.board = board;
    }

    public void load() {
        JFileChooser fc = new JFileChooser();
        fc.showSaveDialog(this);
        File f = fc.getSelectedFile();
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(fc.getSelectedFile()));
            Pattern pY = Pattern.compile(".*Yellow i=(\\d+), j=(\\d+)");
            Pattern pR = Pattern.compile(".*Red i=(\\d+), j=(\\d+)");
            Pattern pB = Pattern.compile(".*Blue i=(\\d+), j=(\\d+)");
            while (((line = br.readLine()) != null)) {
                Matcher mY = pY.matcher(line);
                Matcher mR = pR.matcher(line);
                Matcher mB = pB.matcher(line);
                if (mY.find()) {
                    int i = Integer.parseInt(mY.group(1));
                    int j = Integer.parseInt(mY.group(2));
                    tab[i][j] = 1;
                }
                if (mR.find()) {
                    int i = Integer.parseInt(mR.group(1));
                    int j = Integer.parseInt(mR.group(2));
                    tab[i][j] = 2;
                }
                if (mB.find()) {
                    int i = Integer.parseInt(mB.group(1));
                    int j = Integer.parseInt(mB.group(2));
                    tab[i][j] = 3;
                }
            }
        } catch (IOException e) {
            System.out.println("Error:" +e);
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error:" +e);
            }
        }
        board.repaint();
    }
}
