package Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 图的邻接矩阵的表示方法
 */

public class Graph1 {

    private ArrayList<String> vertexList;        //存储顶点集合
    private int [][] edges;                     //存储图对应的邻接矩阵
    private int numOfEdges;                     //表示边的数目

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

    public static void main(String[] args) {
        int n = 5;
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
     }

}
