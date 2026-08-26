import java.util.*;

class PrimsGraph {

  public void Prim(int G[][], int V) {

    int INF = 999;
    int no_edge = 0;

    boolean[] selected = new boolean[V];
    Arrays.fill(selected, false);

    selected[0] = true;

    int cost = 0;

    System.out.println("Edge  : Weight");

    char arr[] = {'A','B','C','D','E','F','G'};

    while (no_edge < V - 1) {

      int min = INF;
      int x = 0, y = 0;

      for (int i = 0; i < V; i++) {
        if (selected[i]) {
          for (int j = 0; j < V; j++) {

            if (!selected[j] && G[i][j] != 0) {
              if (G[i][j] < min) {
                min = G[i][j];
                x = i;
                y = j;
              }
            }

          }
        }
      }

      System.out.println(arr[x] + " - " + arr[y] + " : " + G[x][y]);

      cost += G[x][y];

      selected[y] = true;
      no_edge++;
    }

    System.out.println("\nMinimum cost = " + cost);
  }

  public static void main(String[] args) {

    PrimsGraph g = new PrimsGraph();

    int V = 7;

    int[][] G = {
        {0,5,3,0,0,0,0},
        {5,0,4,6,2,0,0},
        {3,4,0,5,0,6,0},
        {0,6,5,0,6,6,0},
        {0,2,0,6,0,3,5},
        {0,0,6,6,3,0,4},
        {0,0,0,0,5,4,0}
    };

    g.Prim(G, V);
  }
}