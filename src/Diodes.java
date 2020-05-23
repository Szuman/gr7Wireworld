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
}
