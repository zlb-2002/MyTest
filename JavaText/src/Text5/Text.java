package Text5;

/*
    1.表示不能走
    2.表示可以走
    3.表示已经走过，但走不通
 */
public class Text {

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.init();
        maze.printMaze();
        setWay(maze.getMap(), 1, 1);
        maze.printMaze();
    }

    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i-1, j)) {  // 向上走
                    return true;
                } else if (setWay(map, i, j+1)) {  //向右走
                    return true;
                } else if (setWay(map, i+1, j)) {  //向下走
                    return true;
                } else if (setWay(map, i, j-1)) {  //向左走
                    return false;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }

        }
    }


}

class Maze {

    private int[][] array = new int[8][7];

    public void init () {
        for (int i = 0; i < 8;i++) {
            array[i][0] = 1;
            array[i][6] = 1;
        }

        for (int i = 0;i < 7;i++) {
            array[0][i] = 1;
            array[7][i] = 1;
        }

        array[3][1] = 1;
        array[3][2] = 1;
        array[2][2] = 1;

    }

    public void printMaze () {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getMap() {
        return array;
    }

}
