package Striver.Greedy;

import java.util.Arrays;
import java.util.Scanner;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }

}

public class FractionalKnapsack {

    public static double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        double ans = 0.0;
        Arrays.sort(arr, (a, b) -> {
            double valB = (double) b.value / (double) b.weight;
            double valA = (double) a.value / (double) a.weight;
            return Double.compare(valB, valA);
        });
//        Arrays.sort(arr, (a, b) -> (b.value * a.weight) - (a.value * b.weight));
        int totalWeight = 0;
        int i = 0;
        for (; i < n && totalWeight <= w; ++i) {
            int currentValue = arr[i].value;
            int currentWeight = arr[i].weight;
            if (totalWeight + currentWeight <= w) {
                totalWeight += currentWeight;
                ans += currentValue;
            } else if (totalWeight < ans) {
                int rem = w - totalWeight;
                totalWeight += rem;
                ans += (double) (rem * currentValue) / currentWeight;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int n = 3;
//        int w = 50;
//        int[] value = {60, 100, 120};
//        int[] weight = {10, 20, 30};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int[] value = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; ++i) value[i] = scanner.nextInt();
        for (int j = 0; j < n; ++j) weight[j] = scanner.nextInt();
//        n = value.length;
        Item[] itemArr = new Item[n];
        for (int i = 0; i < n; ++i) {
            itemArr[i] = new Item(value[i], weight[i]);
        }
        System.out.println("Answer " + fractionalKnapsack(w, itemArr, n));

    }
}
