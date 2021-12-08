package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * ͼ���ڽӾ���ı�ʾ����
 */

public class Graph {

    private ArrayList<String> vertexList;        //�洢���㼯��
    private int [][] edges;                     //�洢ͼ��Ӧ���ڽӾ���
    private int numOfEdges;                     //��ʾ�ߵ���Ŀ
    private boolean[] isVisited;

    public Graph(int n) {
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

    //��ӡ�ڽӾ���
    public void showGraph () {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     *
     * @param index
     * @return  ������ھͷ��ض�Ӧ���±꣬�����ھͷ���-1
     */
    public int getFistNeighbor (int index) {
        for (int i = 0;i < vertexList.size();i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //����ǰһ���ڽӽ����±�����ȡ��һ���ڽӽ��
    public int getNextNeighbor (int v1, int v2) {
        for (int i = v2+1;i < vertexList.size();i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //�����������
    private void dfs(boolean[] isVisited, int i) {
        //���ȷ��ʸýڵ�
        System.out.print(getValueByIndex(i) + " ");
        //���˽ڵ�����Ϊ�ѷ���
        isVisited[i] = true;
        //���ҽ��i�ĵ�һ���ڽӽ��
        int w = getFistNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    //�����������
    public void dfs() {
        System.out.println("�������������");
        isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }


    //�����������
    private void bfs(boolean[] isVisited, int i) {
        int u;
        int w;
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(getValueByIndex(i)+ " ");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFistNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + " ");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);  //���ֳ������������
            }

        }
    }

    //�����������
    public void bfs () {
        isVisited = new boolean[getNumOfVertex()];
        System.out.println("�������������");
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    //�������
    public int outDegree (String vertex) {
        int count = 0;
        for (int i = 0;i < getNumOfVertex();i++) {
            if (edges[vertexList.indexOf(vertex)][i] != 0) {
                count++;
            }
        }
        return count;
    }

    //�������
    public int inDegree (String vertex) {
        int count = 0;
        for (int i = 0;i < getNumOfVertex();i++) {
            if (edges[i][vertexList.indexOf(vertex)] != 0) {
                count++;
            }
        }
        return count;
    }
}
