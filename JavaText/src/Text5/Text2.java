package Text5;

import java.awt.*;
import java.util.ArrayList;

public class Text2 {

    private static final int X = 8;
    private static final int Y = 8;
    private static boolean[] visited;
    private static boolean finished;

    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X*Y];
        long start = System.currentTimeMillis();
        System.out.println("开始进行马踏棋盘");
        traversalChessboard(chessboard, 1, 1, 1);
        long end = System.currentTimeMillis();
        System.out.println( "耗时" + (start-end));
        for (int[] x : chessboard) {
            for (int step : x) {
                System.out.print(step + " ");
            }
            System.out.println();
        }
    }

    public static void traversalChessboard (int[][] chessboard, int i, int j, int step) {
        System.out.println(step);
        chessboard[i][j] = step;
        visited[i*X+j] = true;
        ArrayList<Point> arrayList = next(new Point(j,i));
        while (!arrayList.isEmpty()) {
            Point p = arrayList.remove(0);
            if (!visited[p.y*X + p.x]) {
                traversalChessboard(chessboard, p.y, p.x, step+1);
            }
        }
        if (step < X * Y && !finished) {
            chessboard[i][j] = 0;
            visited[i * X + j] = false;
        } else {
            finished = true;
        }
    }

    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> arrayList = new ArrayList<>();
        Point p1 = new Point();
        if ((p1.x = curPoint.x-2) >= 0 && (p1.y = curPoint.y-1) >= 0) {
            arrayList.add(new Point(p1));
        }
        if ((p1.x = curPoint.x-1) >= 0 && (p1.y = curPoint.y-2) >= 0) {
            arrayList.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+1) < X && (p1.y = curPoint.y-2) >= 0) {
            arrayList.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+2) < X && (p1.y = curPoint.y-1) >= 0) {
            arrayList.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+2) < X && (p1.y = curPoint.y+1) < Y) {
            arrayList.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+1) < X && (p1.y = curPoint.y+2) < Y) {
            arrayList.add(new Point(p1));
        }
        if ((p1.x = curPoint.x-1) >= 0 && (p1.y = curPoint.y+2) < Y) {
            arrayList.add(new Point(p1));
        }
        if ((p1.x = curPoint.x-2) >= 0 && (p1.y = curPoint.y+1) < Y) {
            arrayList.add(new Point(p1));
        }
        return arrayList;
    }


}


