package Graph;

import java.util.*;

public class AdjList {

    public static final int MAXVEX = 20;

    private VertexNode[] vertexNode;
    private int vexnum;
    private int arcnum;
    public AdjList(int vexnum, int arcnum) {
        this.vertexNode = new VertexNode[MAXVEX];
        this.vexnum = vexnum;
        this.arcnum = arcnum;
    }

    public class ArcNode {
        int adjvex;
        int weight;
        ArcNode arcNode;
    }

    public class VertexNode {
        char vexdata;
        ArcNode arcNode;
    }


    public static void setVertexNode (AdjList adjList, char[] chars) {
        for (int i = 1;i < chars.length;i++)
            adjList.vertexNode[i].vexdata = chars[i];
    }

    public static void setArcNode (AdjList adjList, List<List<Node>> list) {
        for (int i = 0;i < list.size();i++) {
            for (int j = 0;j < list.get(i).size();j++) {
                adjList.vertexNode[i+1].arcNode.adjvex = list.get(i).get(j).adjvex;
                adjList.vertexNode[i+1].arcNode.weight = list.get(i).get(j).weight;
                        
            }
        }
    }

}
