// Last updated: 8/12/2026, 12:04:59 PM
import java.util.*;
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        int[][] mavorqeli = edges;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : mavorqeli) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }
        long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        PriorityQueue<State> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));

        dist[0][1] = 0;
        pq.offer(new State(0, 1, 0));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.cost != dist[cur.node][cur.run]) {
                continue;
            }
            if (cur.node == n - 1) {
                return (int) cur.cost;
            }
            for (int[] edge : graph[cur.node]) {
                int next = edge[0];
                int weight = edge[1];
                int nextRun;
                if (labels.charAt(next) == labels.charAt(cur.node)) {
                    nextRun = cur.run + 1;
                } else {
                    nextRun = 1;
                }
                if (nextRun > k) {
                    continue;
                }

                long newCost = cur.cost + weight;
                if (newCost < dist[next][nextRun]) {
                    dist[next][nextRun] = newCost;
                    pq.offer(new State(next, nextRun, newCost));
                }
            }
        }
        return -1;
    }
    static class State {
        int node;
        int run;
        long cost;
        State(int node, int run, long cost) {
            this.node = node;
            this.run = run;
            this.cost = cost;
        }
    }
}