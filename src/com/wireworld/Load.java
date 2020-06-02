package com.wireworld;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Load extends Component {
    private final int[][] tab;
    private final Board board;
    private List<String> structs;

    public Load(int[][] tab, Board board, List<String> structs) {
        this.tab = tab;
        this.board = board;
        this.structs = structs;
    }

    Diodes diodes = new Diodes();

    public void load() {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        if (fc.getSelectedFile() == null)
            return;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = 0;
            }
        }
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(fc.getSelectedFile()));
            Pattern pY = Pattern.compile(".*Conductor x=(\\d+), y=(\\d+)");
            Pattern pR = Pattern.compile(".*ElectronTail x=(\\d+), y=(\\d+)");
            Pattern pB = Pattern.compile(".*ElectronHead x=(\\d+), y=(\\d+)");
            Pattern dL = Pattern.compile(".*DiodeLeft x=(\\d+), y=(\\d+)");
            Pattern dR = Pattern.compile(".*DiodeRight x=(\\d+), y=(\\d+)");
            Pattern dU = Pattern.compile(".*DiodeUp x=(\\d+), y=(\\d+)");
            Pattern dD = Pattern.compile(".*DiodeDown x=(\\d+), y=(\\d+)");
            Pattern og = Pattern.compile(".*ORgate x=(\\d+), y=(\\d+)");
            Pattern ag = Pattern.compile(".*ANDgate x=(\\d+), y=(\\d+)");
            Pattern xg = Pattern.compile(".*GateXOR x=(\\d+), y=(\\d+)");
            Pattern ng = Pattern.compile(".*ANDNOTgate x=(\\d+), y=(\\d+)");
            while (((line = br.readLine()) != null)) {
                Matcher mY = pY.matcher(line);
                Matcher mR = pR.matcher(line);
                Matcher mB = pB.matcher(line);
                Matcher dLe = dL.matcher(line);
                Matcher dRi = dR.matcher(line);
                Matcher dUp = dU.matcher(line);
                Matcher dDo = dD.matcher(line);
                Matcher oRg = og.matcher(line);
                Matcher aNg = ag.matcher(line);
                Matcher xOg = xg.matcher(line);
                Matcher nAg = ng.matcher(line);
                if (mY.find()) {
                    int i = Integer.parseInt(mY.group(1));
                    int j = Integer.parseInt(mY.group(2));
                    tab[i][j] = 1;
                }
                if (mR.find()) {
                    int i = Integer.parseInt(mR.group(1));
                    int j = Integer.parseInt(mR.group(2));
                    tab[i][j] = 3;
                }
                if (mB.find()) {
                    int i = Integer.parseInt(mB.group(1));
                    int j = Integer.parseInt(mB.group(2));
                    tab[i][j] = 2;
                }
                if (dLe.find()) {
                    int i = Integer.parseInt(dLe.group(1));
                    int j = Integer.parseInt(dLe.group(2));
                    diodes.addDiodeLeft(tab, i, j);
                    structs.add("DiodeLeft x=" + i + ", y=" + j +";");
                }
                if (dRi.find()) {
                    int i = Integer.parseInt(dRi.group(1));
                    int j = Integer.parseInt(dRi.group(2));
                    diodes.addDiodeRight(tab, i, j);
                    structs.add("DiodeRight x=" + i + ", y=" + j +";");
                }
                if (dUp.find()) {
                    int i = Integer.parseInt(dUp.group(1));
                    int j = Integer.parseInt(dUp.group(2));
                    diodes.addDiodeUp(tab, i, j);
                    structs.add("DiodeUp x=" + i + ", y=" + j +";");
                }
                if (dDo.find()) {
                    int i = Integer.parseInt(dDo.group(1));
                    int j = Integer.parseInt(dDo.group(2));
                    diodes.addDiodeDown(tab, i, j);
                    structs.add("DiodeDown x=" + i + ", y=" + j +";");
                }
                if (oRg.find()) {
                    int i = Integer.parseInt(oRg.group(1));
                    int j = Integer.parseInt(oRg.group(2));
                    diodes.addOR(tab, i, j);
                    structs.add("ORgate x=" + i + ", y=" + j +";");
                }
                if (aNg.find()) {
                    int i = Integer.parseInt(aNg.group(1));
                    int j = Integer.parseInt(aNg.group(2));
                    diodes.addAND(tab, i, j);
                    structs.add("ANDgate x=" + i + ", y=" + j +";");
                }
                if (xOg.find()) {
                    int i = Integer.parseInt(xOg.group(1));
                    int j = Integer.parseInt(xOg.group(2));
                    diodes.addXOR(tab, i, j);
                    structs.add("GateXOR x=" + i + ", y=" + j +";");
                }
                if (nAg.find()) {
                    int i = Integer.parseInt(nAg.group(1));
                    int j = Integer.parseInt(nAg.group(2));
                    diodes.addANDNOT(tab, i, j);
                    structs.add("ANDNOTgate x=" + i + ", y=" + j +";");
                }
            }
        } catch (IOException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error:" + e);
            }
        }
        board.repaint();
    }
}
