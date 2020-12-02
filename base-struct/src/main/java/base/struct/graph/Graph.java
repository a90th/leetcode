package base.struct.graph;

import java.util.LinkedList;

//无向图
public class Graph {

    public int count;//顶点的个数
    public LinkedList<Integer>[] linked;

    public Graph(int count) {
        this.count = count;
        linked = new LinkedList[count];
        for (int i = 0; i < count; i++) {
            linked[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        linked[s].add(t);
        linked[t].add(s);
    }


    public static Graph getATestGraph() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(6, 7);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        return graph;
    }
}
