public class HamiltonianCycle
{
    int V = 5;
    int path[];

    boolean isSafe(int v, int graph[][], int pos)
    {
        if (graph[path[pos - 1]][v] == 0)
        {
            return false;
        }

        for (int i = 0; i < pos; i++)
        {
            if (path[i] == v)
            {
                return false;
            }
        }

        return true;
    }

    boolean hamCycleUtil(int graph[][], int pos)
    {
        if (pos == V)
        {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < V; v++)
        {
            if (isSafe(v, graph, pos))
            {
                path[pos] = v;

                if (hamCycleUtil(graph, pos + 1))
                {
                    return true;
                }

                path[pos] = -1; // backtracking
            }
        }

        return false;
    }

    void solve(int graph[][])
    {
        path = new int[V];

        for (int i = 0; i < V; i++)
        {
            path[i] = -1;
        }

        path[0] = 0;

        if (hamCycleUtil(graph, 1))
        {
            System.out.println("Hamiltonian Cycle Exists");

            for (int i = 0; i < V; i++)
            {
                System.out.print(path[i] + " ");
            }

            System.out.println(path[0]);
        }
        else
        {
            System.out.println("Solution does not exist");
        }
    }

    public static void main(String[] args)
    {
        HamiltonianCycle h = new HamiltonianCycle();

        int graph[][] = {
            {0,1,0,1,0},
            {1,0,1,1,1},
            {0,1,0,0,1},
            {1,1,0,0,1},
            {0,1,1,1,0}
        };

        h.solve(graph);
    }
}