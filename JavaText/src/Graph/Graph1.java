package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图的邻接矩阵的表示方法
 */

public class Graph1 {

    private ArrayList<String> vertexList;        //存储顶点集合
    private int [][] edges;                     //存储图对应的邻接矩阵
    private int numOfEdges;                     //表示边的数目
    private boolean[] isVisited;

    public Graph1(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    //插入节点
    public void insertVertex (String vertex) {
        vertexList.add(vertex);
    }

    /**     插入边
     *    A -> B
     * @param v1      表示A点的下标
     * @param v2      表示B点的下标
     * @param weight  表示权值
     */
    public void insertEdge (int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //节点的个数
    public int getNumOfVertex () {
        return vertexList.size();
    }

    //边的个数
    public int getNumOfEdges () {
        return numOfEdges;
    }

    //结点i对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight (int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph () {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     *
     * @param index
     * @return  如果存在就返回对应的下标，不存在就返回-1
     */
    public int getFistNeighbor (int index) {
        for (int i = 0;i < vertexList.size();i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor (int v1, int v2) {
        for (int i = v2+1;i < vertexList.size();i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //深搜
    private void dfs(boolean[] isVisited, int i) {
        //首先访问该节点
        System.out.print(getValueByIndex(i) + "->");
        //将此节点设置为已访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点
        int w = getFistNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    public void dfs() {
        isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    private void bfs(boolean[] isVisited, int i) {
        int u;
        int w;
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(getValueByIndex(i)+ "->");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFistNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);  //体现出广度优先搜索
            }

        }
    }

    public void bfs () {
        isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    /*public static void main(String[] args) {
        *//*int n = 5;
        String vertexValue[] = {"A", "B", "C", "D", "E"};
        Graph1 graph1 = new Graph1(n);
        for (String value : vertexValue) {
            graph1.insertVertex(value);
        }
        graph1.insertEdge(0, 1, 1);
        graph1.insertEdge(0, 2, 1);
        graph1.insertEdge(1, 2, 1);
        graph1.insertEdge(1, 3, 1);
        graph1.insertEdge(1, 4, 1);
        graph1.showGraph();
        System.out.println("深度优先搜索");
        graph1.dfs();
        System.out.println();
        System.out.println("广度优先搜索");
        graph1.bfs();

        *//*
        Graph1 graph11 = new Graph1(8);
        String[] vertexes = {"1","2","3","4","5","6","7","8"};
        for (String vertex : vertexes) {
            graph11.insertVertex(vertex);
        }
        graph11.insertEdge(0,1,1);
        graph11.insertEdge(0,2,1);
        graph11.insertEdge(1,3,1);
        graph11.insertEdge(0,4,1);
        graph11.insertEdge(3,7,1);
        graph11.insertEdge(4,7,1);
        graph11.insertEdge(2,5,1);
        graph11.insertEdge(2,6,1);
        graph11.insertEdge(5,6,1);
        graph11.showGraph();
        System.out.println("深搜");
        graph11.dfs();
        System.out.println();
        System.out.println("广搜");
        graph11.bfs();
     }*/

}
