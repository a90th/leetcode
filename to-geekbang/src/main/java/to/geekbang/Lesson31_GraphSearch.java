package to.geekbang;

import base.struct.graph.Graph;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Lesson31_GraphSearch {

    public static void bfsSearch(Graph graph, int start, int target) {
        if (start == target) return;
        boolean[] visited = new boolean[graph.count];
        for (int i = 0; i < visited.length; i++) visited[i] = false;
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] prev = new int[graph.count];
        for (int i = 0; i < prev.length; i++) prev[i] = -1;
        while (queue.size() > 0) {
            int current = queue.poll();
            for (int i = 0; i < graph.linked[current].size(); i++) {
                int next = graph.linked[current].get(i);
                if (!visited[next]) {
                    prev[next] = current;
                    if (next == target) {
                        printPath(prev, start, target);
                        return;
                    }
                    visited[next] = true;
                    queue.add(next);
                }

            }
        }
    }

    public static void printPath(int[] prev, int start, int target) {
        if (prev[target] != -1 && target != start) {
            printPath(prev, start, prev[target]);
        }
        System.out.print("-> " + target);
    }

    public static void dfsSearch(Graph graph, int start, int target) {
        boolean found = false;
        boolean[] visited = new boolean[graph.count];
        int[] prev = new int[graph.count];
        for (int i = 0; i < graph.count; i++) {
            visited[i] = false;
            prev[i] = -1;
        }
        found = recurDfs(graph, start, target, visited, prev);
        if (found) printPath(prev, start, target);
        else {
            System.out.print("Not Found");
        }
    }

    public static boolean recurDfs(Graph graph, int start, int target, boolean[] visited, int[] prev) {
        if (start == target) return true;
        visited[start] = true;

        for (int i = 0; i < graph.linked[start].size(); i++) {
            int current = graph.linked[start].get(i);
            if (!visited[current]) {
                visited[current] = true;
                prev[current] = start;
                //交给子问题返回路径检查结果
                //如果子问题的一个分支没有解决问题，继续使用下一个分支——"回溯思想"
                if (recurDfs(graph, current, target, visited, prev)) return true;
            }
        }
        return false;
    }

    /****************************************
     * 回溯的主要思想是，"试探，如果不成功则返回远处，尝试另外一种方案的试探"
     * 回溯问题自然以来其子问题的结果，所以跟递归有着天然的联系
     * 常见的几种算法思想：回溯、贪婪算法、动态规划、分治算法
     ****************************************/


    public static class UnitTest {

        @Test
        public void testDFS() {
            Graph graph = Graph.getATestGraph();
            dfsSearch(graph, 1, 7);
            System.out.println();
            dfsSearch(graph, 2, 7);
            System.out.println();
            dfsSearch(graph, 5, 7);
            System.out.println();
            dfsSearch(graph, 4, 7);
        }


        @Test
        public void testBFS() {
            Graph graph = Graph.getATestGraph();
            bfsSearch(graph, 1, 7);
            System.out.println();
            bfsSearch(graph, 3, 7);
        }
    }
}
