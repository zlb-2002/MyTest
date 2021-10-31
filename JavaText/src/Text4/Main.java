package Text4;

import java.awt.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(new ChessPiece(0,0));
        chessBoard.initKey();
        int[][] key = chessBoard.getArrayKey();
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 8; i1++) {
                System.out.print(key[i][i1]);
            }
            System.out.println();
        }

    }

}

class ChessPiece {
    private int X;
    private int Y;

    public ChessPiece(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}

class ChessBoard {
    private final ChessPiece point;
    private final int[][] arrayKey;
    private int[][] array;
    private int step;

    public ChessBoard(ChessPiece point) {
        this.point = point;
        arrayKey = new int[8][8];
        array = new int[8][8];
        step = 1;
        array[point.getX()][point.getY()]  = step;
        ++step;
    }

    public int[][] getArrayKey () {
        return arrayKey;
    }

    public void initKey () {
        int i,j;
        for (i = 0;i < 8;i++) {
            for (j = 0;j < 8;j++) {
                int x = 0;
                if (i-2 >= 0 && i-2 < 8 && j+1 < 8 && j+1 >= 0) ++x;
                if (i-1 >= 0 && i-1 < 8 && j+2 < 8 && j+2 >= 0) ++x;
                if (i+1 >= 0 && i+1 < 8 && j+2 < 8 && j+2 >= 0) ++x;
                if (i+2 >= 0 && i+2 < 8 && j+1 < 8 && j+1 >= 0) ++x;
                if (i+2 >= 0 && i+2 < 8 && j-1 < 8 && j-1 >= 0) ++x;
                if (i+1 >= 0 && i+1 < 8 && j-2 < 8 && j-2 >= 0) ++x;
                if (i-1 >= 0 && i-1 < 8 && j-2 < 8 && j-2 >= 0) ++x;
                if (i-2 >= 0 && i-2 < 8 && j-1 < 8 && j-1 >= 0) ++x;
                arrayKey[i][j] = x;
            }
        }
    }

    public void updateAdvanceKey () {
        int i,j;
        i = point.getX();
        j = point.getY();
        if (i-2 >= 0 && i-2 < 8 && j+1 < 8 && j+1 >= 0) arrayKey[i-2][j+1]--;
        if (i-1 >= 0 && i-1 < 8 && j+2 < 8 && j+2 >= 0) arrayKey[i-1][j+2]--;
        if (i+1 >= 0 && i+1 < 8 && j+2 < 8 && j+2 >= 0) arrayKey[i+2][j+1]--;
        if (i+2 >= 0 && i+2 < 8 && j+1 < 8 && j+1 >= 0) arrayKey[i+1][j+2]--;
        if (i+2 >= 0 && i+2 < 8 && j-1 < 8 && j-1 >= 0) arrayKey[i+2][j-1]--;
        if (i+1 >= 0 && i+1 < 8 && j-2 < 8 && j-2 >= 0) arrayKey[i+1][j-2]--;
        if (i-1 >= 0 && i-1 < 8 && j-2 < 8 && j-2 >= 0) arrayKey[i-2][j-1]--;
        if (i-2 >= 0 && i-2 < 8 && j-1 < 8 && j-1 >= 0) arrayKey[i-1][j-2]--;
    }

    public void updateBackupKey () {
        int i,j;
        i = point.getX();
        j = point.getY();
        if (i-2 >= 0 && i-2 < 8 && j+1 < 8 && j+1 >= 0) ++arrayKey[i-2][j+1];
        if (i-1 >= 0 && i-1 < 8 && j+2 < 8 && j+2 >= 0) ++arrayKey[i-1][j+2];
        if (i+1 >= 0 && i+1 < 8 && j+2 < 8 && j+2 >= 0) ++arrayKey[i+2][j+1];
        if (i+2 >= 0 && i+2 < 8 && j+1 < 8 && j+1 >= 0) ++arrayKey[i+1][j+2];
        if (i+2 >= 0 && i+2 < 8 && j-1 < 8 && j-1 >= 0) ++arrayKey[i+2][j-1];
        if (i+1 >= 0 && i+1 < 8 && j-2 < 8 && j-2 >= 0) ++arrayKey[i+1][j-2];
        if (i-1 >= 0 && i-1 < 8 && j-2 < 8 && j-2 >= 0) ++arrayKey[i-2][j-1];
        if (i-2 >= 0 && i-2 < 8 && j-1 < 8 && j-1 >= 0) ++arrayKey[i-1][j-2];
    }

    private int findNext (int x, int y) {
        int[] a = new int[8];
        int k = 0;
        if (x -2 >= 0 && x -2 < 8 && y +1 < 8 && y +1 >= 0) a[k] = arrayKey[x -2][y +1];
        k++;
        if (x -1 >= 0 && x -1 < 8 && y +2 < 8 && y +2 >= 0) a[k] = arrayKey[x -1][y +2];
        k++;
        if (x +1 >= 0 && x +1 < 8 && y +2 < 8 && y +2 >= 0) a[k] = arrayKey[x +2][y +1];
        k++;
        if (x +2 >= 0 && x +2 < 8 && y +1 < 8 && y +1 >= 0) a[k] = arrayKey[x +1][y +2];
        k++;
        if (x +2 >= 0 && x +2 < 8 && y -1 < 8 && y -1 >= 0) a[k] = arrayKey[x +2][y -1];
        k++;
        if (x +1 >= 0 && x +1 < 8 && y -2 < 8 && y -2 >= 0) a[k] = arrayKey[x +1][y -2];
        k++;
        if (x -1 >= 0 && x -1 < 8 && y -2 < 8 && y -2 >= 0) a[k] = arrayKey[x -2][y -1];
        k++;
        if (x -2 >= 0 && x -2 < 8 && y -1 < 8 && y -1 >= 0) a[k] = arrayKey[x -1][y -2];
        int [] b = new int[8];
        for (int t = 0; t < 8; t++) b[t] = a[k];
        Arrays.sort(a);
        int t;
        for (t = 0; t < 8; t++) {
            if (b[t] == a[0]) {
                break;
            }
        }
        return t;
    }

    public void move () {
        int x = point.getX();
        int y = point.getY();
        int t = findNext(x,y);
        switch (t) {
            case 0 -> {
                point.setX(point.getX() - 2);
                point.setY(point.getY() + 1);
            }
            case 1 -> {
                point.setX(point.getX() - 1);
                point.setX(point.getX() + 2);
            }
            case 2 -> {
                point.setX(point.getX() + 1);
                point.setX(point.getX() + 2);
            }
            case 3 -> {
                point.setX(point.getX() + 2);
                point.setX(point.getX() + 1);
            }
            case 4 -> {
                point.setX(point.getX() + 2);
                point.setX(point.getX() - 1);
            }
            case 5 -> {
                point.setX(point.getX() + 1);
                point.setX(point.getX() - 2);
            }
            case 6 -> {
                point.setX(point.getX() - 1);
                point.setX(point.getX() - 2);
            }
            case 7 -> {
                point.setX(point.getX() - 2);
                point.setX(point.getX() - 1);
            }
        }
        array[point.getX()][point.getY()] = step++;
        updateAdvanceKey();
    }
}