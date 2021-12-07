package Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ͼ���ڽӾ���ı�ʾ����
 */

public class Graph1 {

    private ArrayList<String> vertexList;        //�洢���㼯��
    private int [][] edges;                     //�洢ͼ��Ӧ���ڽӾ���
    private int numOfEdges;                     //��ʾ�ߵ���Ŀ

    public Graph1(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    //����ڵ�
    public void insertVertex (String vertex) {
        vertexList.add(vertex);
    }

    /**     �����
     *    A -> B
     * @param v1      ��ʾA����±�
     * @param v2      ��ʾB����±�
     * @param weight  ��ʾȨֵ
     */
    public void insertEdge (int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //�ڵ�ĸ���
    public int getNumOfVertex () {
        return vertexList.size();
    }


    //�ߵĸ���
    public int getNumOfEdges () {
        return numOfEdges;
    }

    //���i��Ӧ������
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //����v1��v2��Ȩֵ
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
