package com.wireworld;

public class Diodes {
    public void addDiodeRight(int [][]tab, int x, int y) {
        try {
            tab[x][y] = 1;
            tab[x + 1][y] = 1;
            tab[x + 2][y] = 1;
            tab[x + 3][y] = 0;
            tab[x + 3][y - 1] = 1;
            tab[x + 3][y + 1] = 1;
            tab[x + 4][y] = 1;
            tab[x + 4][y - 1] = 1;
            tab[x + 4][y + 1] = 1;
            tab[x + 5][y] = 1;
            tab[x + 6][y] = 1;
            tab[x + 7][y] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't put it on board");
        }
    }
    public void addDiodeLeft(int [][] tab, int x, int y) {
        try {
            tab[x][y] = 1;
            tab[x+1][y] = 1;
            tab[x+2][y] = 1;
            tab[x+3][y] = 1;
            tab[x+3][y-1] = 1;
            tab[x+3][y+1] = 1;
            tab[x+4][y] = 0;
            tab[x+4][y-1] = 1;
            tab[x+4][y+1] = 1;
            tab[x+5][y] = 1;
            tab[x+6][y] = 1;
            tab[x+7][y] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't put it on board");
        }
    }
    public void addDiodeUp(int [][] tab, int x, int y) {
        try {
            tab[x][y] = 1;
            tab[x][y+1] = 1;
            tab[x][y+2] = 1;
            tab[x][y+3] = 1;
            tab[x-1][y+3] = 1;
            tab[x+1][y+3] = 1;
            tab[x][y+4] = 0;
            tab[x-1][y+4] = 1;
            tab[x+1][y+4] = 1;
            tab[x][y+5] = 1;
            tab[x][y+6] = 1;
            tab[x][y+7] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't put it on board");
        }
    }
    public void addDiodeDown(int [][] tab, int x, int y) {
        try {
            tab[x][y] = 1;
            tab[x][y+1] = 1;
            tab[x][y+2] = 1;
            tab[x][y+3] = 0;
            tab[x-1][y+3] = 1;
            tab[x+1][y+3] = 1;
            tab[x][y+4] = 1;
            tab[x-1][y+4] = 1;
            tab[x+1][y+4] = 1;
            tab[x][y+5] = 1;
            tab[x][y+6] = 1;
            tab[x][y+7] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't put it on board");
        }
    }
    public void addOR(int [][] tab, int x, int y){
        try {
            tab[x][y] = 1;
            tab[x + 1][y] = 1;
            tab[x + 2][y] = 1;
            tab[x + 3][y] = 1;
            tab[x + 4][y] = 1;
            tab[x + 5][y] = 1;
            tab[x + 6][y] = 1;
            tab[x + 7][y] = 1;
            tab[x - 1][y] = 1;
            tab[x][y + 1] = 1;
            tab[x][y - 1] = 1;
            tab[x - 1][y + 2] = 1;
            tab[x - 1][y - 2] = 1;
            tab[x - 2][y + 2] = 1;
            tab[x - 2][y - 2] = 1;
            tab[x - 3][y + 1] = 1;
            tab[x - 3][y - 1] = 1;
            tab[x - 4][y + 1] = 1;
            tab[x - 4][y - 1] = 1;
            tab[x - 5][y + 1] = 1;
            tab[x - 5][y - 1] = 1;
            tab[x - 6][y + 1] = 1;
            tab[x - 6][y - 1] = 1;
            tab[x - 7][y + 1] = 1;
            tab[x - 7][y - 1] = 1;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't put it on board");
        }
    }
    public void addAND(int [][] tab, int x, int y){
        try {
            tab[x][y] = 1;
            tab[x+1][y] = 1;
            tab[x+2][y] = 1;
            tab[x+3][y] = 1;
            tab[x+4][y] = 1;
            tab[x+5][y] = 1;
            tab[x+6][y] = 1;
            tab[x+7][y] = 1;
            tab[x+8][y] = 1;
            tab[x+9][y] = 1;
            tab[x+10][y] = 1;
            tab[x+11][y] = 1;
            tab[x+12][y+1] = 1;
            tab[x+13][y+1] = 1;
            tab[x+14][y+1] = 1;
            tab[x+15][y+2] = 1;
            tab[x+15][y+3] = 1;
            tab[x+15][y+4] = 1;
            tab[x+15][y+6] = 1;
            tab[x+16][y+6] = 1;
            tab[x+17][y+5] = 1;
            tab[x+18][y+4] = 1;
            tab[x+19][y+4] = 1;
            tab[x+20][y+4] = 1;
            tab[x+21][y+4] = 1;
            tab[x+22][y+4] = 1;
            tab[x+14][y+5] = 1;
            tab[x+13][y+5] = 1;
            tab[x+12][y+5] = 1;
            tab[x+13][y+4] = 1;
            tab[x+13][y+6] = 1;
            tab[x+11][y+4] = 1;
            tab[x+11][y+2] = 1;
            tab[x+9][y+2] = 1;
            tab[x+9][y+3] = 1;
            tab[x+9][y+4] = 1;
            tab[x+10][y+3] = 1;
            tab[x+8][y+3] = 1;
            tab[x+7][y+4] = 1;
            tab[x+7][y+5] = 1;
            tab[x+7][y+6] = 1;
            tab[x+6][y+7] = 1;
            tab[x+5][y+4] = 1;
            tab[x+5][y+5] = 1;
            tab[x+5][y+6] = 1;
            tab[x][y+3] = 1;
            tab[x+1][y+3] = 1;
            tab[x+2][y+3] = 1;
            tab[x+3][y+3] = 1;
            tab[x+4][y+3] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't put it on board");
        }
    }
    public void addXOR(int [][] tab, int x, int y) {
        try {
            tab[x][y] = 1;
            tab[x+1][y] = 1;
            tab[x+2][y] = 1;
            tab[x+3][y] = 1;
            tab[x+4][y] = 1;
            tab[x][y+2] = 1;
            tab[x+1][y+2] = 1;
            tab[x+2][y+2] = 1;
            tab[x+3][y+2] = 1;
            tab[x+4][y+2] = 1;
            tab[x+5][y+3] = 1;
            tab[x+6][y+4] = 1;
            tab[x+7][y+4] = 1;
            tab[x+8][y+3] = 1;
            tab[x+7][y+2] = 1;
            tab[x+8][y+2] = 1;
            tab[x+9][y+2] = 1;
            tab[x+10][y+2] = 1;
            tab[x+7][y+1] = 1;
            tab[x+9][y+1] = 1;
            tab[x+10][y+1] = 1;
            tab[x+11][y+1] = 1;
            tab[x+12][y+1] = 1;
            tab[x+13][y+1] = 1;
            tab[x+14][y+1] = 1;
            tab[x+7][y] = 1;
            tab[x+8][y] = 1;
            tab[x+9][y] = 1;
            tab[x+10][y] = 1;
            tab[x+8][y-1] = 1;
            tab[x+7][y-2] = 1;
            tab[x+6][y-2] = 1;
            tab[x+5][y-1] = 1;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't put it on board");
        }
    }
    public void addANDNOT(int [][] tab, int x, int y) {
        try {
            tab[x][y] = 1;
            tab[x+1][y] = 1;
            tab[x+2][y] = 1;
            tab[x+3][y] = 1;
            tab[x+4][y] = 1;
            tab[x+5][y] = 1;
            tab[x+6][y] = 1;
            tab[x][y+6] = 1;
            tab[x+1][y+6] = 1;
            tab[x+2][y+6] = 1;
            tab[x+3][y+6] = 1;
            tab[x+4][y+6] = 1;
            tab[x+5][y+5] = 1;
            tab[x+6][y+4] = 1;
            tab[x+7][y+3] = 1;
            tab[x+7][y+2] = 1;
            tab[x+7][y+1] = 1;
            tab[x+6][y+2] = 1;
            tab[x+8][y+2] = 1;
            tab[x+9][y+3] = 1;
            tab[x+10][y+3] = 1;
            tab[x+11][y+3] = 1;
            tab[x+12][y+3] = 1;
            tab[x+13][y+3] = 1;
            tab[x+14][y+3] = 1;
            tab[x+15][y+3] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't put it on board");
        }
    }
}
