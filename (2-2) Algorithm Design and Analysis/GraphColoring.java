public class GraphColoring
{
    int V = 4;
    int[] color;

    boolean isSafe(int v, int graph[][], int c)
    {
        for (int i = 0; i < V; i++)
        {
            if (graph[v][i] == 1 && color[i] == c)
            {
                return false;
            }
        }

        return true;
    }

    boolean graphColor(int graph[][], int m, int v)
    {
        if (v == V)
        {
            return true;
        }

        for (int c = 1; c <= m; c++)
        {
            if (isSafe(v, graph, c))
            {
                color[v] = c;

                if (graphColor(graph, m, v + 1))
                {
                    return true;
                }

                color[v] = 0; // backtracking
            }
        }

        return false;
    }

    void solve(int graph[][], int m)
    {
        color = new int[V];

        if (graphColor(graph, m, 0))
        {
            System.out.println("Solution Exists");

            for (int i = 0; i < V; i++)
            {
                System.out.println("Vertex " + i + " -> Color " + color[i]);
            }
        }
        else
        {
            System.out.println("Solution does not exist");
        }
    }

    public static void main(String[] args)
    {
        GraphColoring g = new GraphColoring();

        int graph[][] = {
            {0,1,1,1},
            {1,0,1,0},
            {1,1,0,1},
            {1,0,1,0}
        };

        int m = 3;

        g.solve(graph, m);
    }
}