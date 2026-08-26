import java.util.*;

class KruskalAlgo {

  static int V = 6;
  static int[] parent = new int[V];
  static int INF = Integer.MAX_VALUE;

  // Find set of vertex
  static int find(int x) {
    while (parent[x] != x)
      x = parent[x];
    return x;
  }

  // Union of two sets
  static void union1(int i, int j) {
    int a = find(i);
    int b = find(j);
    parent[a] = b;
  }

  // Kruskal Algorithm
  static void kruskalMST(int cost[][]) {

    int mincost = 0;

    for (int i = 0; i < V; i++)
      parent[i] = i;

    System.out.println("Edge  : Weight");

    int edge_count = 0;

    while (edge_count < V - 1) {

      int min = INF;
      int a = -1, b = -1;

      for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {

          // FIXED CONDITION
          if (i != j && cost[i][j] != INF && find(i) != find(j)) {
            if (cost[i][j] < min) {
              min = cost[i][j];
              a = i;
              b = j;
            }
          }

        }
      }

      // Perform union
      union1(a, b);
      edge_count++;

      System.out.println((char)(a + 65) + " - " + (char)(b + 65) + " : " + min);

      mincost += min;
    }

    System.out.println("Minimum cost = " + mincost);
  }

  public static void main(String[] args) {

    int Graph[][] = {
        {INF,5,3,INF,INF,7},
        {5,INF,6,2,4,INF},
        {3,6,INF,3,INF,8},
        {INF,2,3,INF,2,INF},
        {INF,4,INF,2,INF,INF},
        {7,INF,8,INF,INF,INF}
    };

    kruskalMST(Graph);
  }
}