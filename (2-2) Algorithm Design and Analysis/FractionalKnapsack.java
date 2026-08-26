import java.util.*;

class Item {
    int weight, profit, index;

    Item(int w, int p, int i) {
        weight = w;
        profit = p;
        index = i;
    }
}

public class FractionalKnapsack {

    public static void solve(Item[] items, int capacity) {

        int n = items.length;

        double[] fraction = new double[n];

        // Sort by profit/weight ratio (descending)
        Arrays.sort(items, (a, b) ->
                Double.compare((double)b.profit / b.weight,
                               (double)a.profit / a.weight));

        double totalProfit = 0;

        for (int i = 0; i < n; i++) {

            if (capacity >= items[i].weight) {
                capacity -= items[i].weight;
                totalProfit += items[i].profit;
                fraction[items[i].index] = 1; // store in original index
            } else {
                double frac = (double) capacity / items[i].weight;
                totalProfit += items[i].profit * frac;
                fraction[items[i].index] = frac;
                capacity = 0;
                break;
            }
        }

        // Print in original order
        System.out.print("Fractions taken : ( ");
        for (int i = 0; i < n; i++) {
            System.out.print(fraction[i] + " ,");
        }
        System.out.println(")");

        System.out.println("Maximum Profit: " + totalProfit);
    }

    public static void main(String[] args) {

        Item[] items = {
            new Item(10, 60, 0),
            new Item(20, 100, 1),
			new Item(30, 120, 2),
            new Item(40, 10, 3)
        };

        int capacity = 50;

        solve(items, capacity);
    }
}