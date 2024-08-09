package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDefense {
    //    public static int minCost(int[][] W) {
//        int N = W.length;
//        int totalStates = 1 << N;
//        int[][] dp = new int[N + 1][totalStates];
//
//        for (int i = 0; i <= N; i++) {
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//        }
//
//        dp[0][0] = 0;
//
//        for (int i = 1; i <= N; i++) {
//            for (int mask = 0; mask < totalStates; mask++) {
//                // Ally with species i
//                dp[i][mask | (1 << (i - 1))] = Math.min(dp[i][mask | (1 << (i - 1))], dp[i - 1][mask]);
//
//                // Defeat species i using current arsenal
//                if ((mask & (1 << (i - 1))) != 0) {
//                    dp[i][mask] = Math.min(dp[i][mask], dp[i - 1][mask] + 0); // Cost of defeating with own weapons is 0
//                }
//
//                // Defeat species i using ally's weapons
//                for (int j = 0; j < i - 1; j++) {
//                    if ((mask & (1 << j)) != 0 && W[i - 1][j] != 1) {
//                        dp[i][mask | (1 << (i - 1))] = Math.min(dp[i][mask | (1 << (i - 1))], dp[i - 1][mask] + W[i - 1][j]);
//                    }
//                }
//            }
//        }
//
//        int minCost = Integer.MAX_VALUE;
//        for (int mask = 0; mask < totalStates; mask++) {
//            if (Integer.bitCount(mask) == N) {
//                minCost = Math.min(minCost, dp[N][mask]);
//            }
//        }
//
//        return minCost == Integer.MAX_VALUE ? -1 : minCost;
//    }
    public static int minCost(int[][] W) {
        int n = W.length;
        int[][] dp = new int[n][1 << n];

        // Initialize dp array with a large number
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // Try allying with each species
        for (int i = 0; i < n; i++) {
            dp[i][1 << i] = 0;
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) continue;
                for (int j = 0; j < n; j++) {
                    if ((mask & (1 << j)) != 0 || W[i][j] == -1) continue;
                    int nextMask = mask | (1 << j);
                    dp[j][nextMask] = Math.min(dp[j][nextMask], dp[i][mask] + W[i][j]);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, dp[i][(1 << n) - 1]);
        }

        return minCost;
    }

//    public static int minBudgetToDefendAll(int N, int[][] W) {
//        int minCost = Integer.MAX_VALUE;
//
//        // Try allying with each species
//        for (int ally = 0; ally < N; ally++) {
//            // Use a boolean array to track defeated species
//            boolean[] defeated = new boolean[N];
//            defeated[ally] = true; // Start with the allied species
//            int totalCost = 0;
//
//            // BFS Queue
//            Queue<Integer> queue = new LinkedList<>();
//            queue.offer(ally);
//
//            // While we can defeat species
//            while (!queue.isEmpty()) {
//                int current = queue.poll();
//
//                // Attempt to defeat other species
//                for (int j = 0; j < N; j++) {
//                    // Can defeat species j with current species
//                    if (!defeated[j] && W[current][j] != -1) {
//                        defeated[j] = true; // Defeat species j
//                        totalCost += W[current][j]; // Increment total cost
//                        queue.offer(j); // Add to queue for further defeating
//                    }
//                }
//            }
//
//            // Check if all species have been defeated
//            boolean allDefeated = true;
//            for (boolean d : defeated) {
//                if (!d) {
//                    allDefeated = false;
//                    break;
//                }
//            }
//
//            // If all species are defeated, update minimum cost
//            if (allDefeated) {
//                minCost = Math.min(minCost, totalCost);
//            }
//        }
//
//        // Return the minimum cost or -1 if not possible
//        return minCost == Integer.MAX_VALUE ? -1 : minCost;
//    }

    public static int minBudgetToDefendAll(int N, int[][] W) {
        int INF = Integer.MAX_VALUE / 2;
        int[][] dp = new int[1 << N][N];

        // Initialize the dp array with a large number (infinity)
        for (int i = 0; i < (1 << N); i++) {
            Arrays.fill(dp[i], INF);
        }

        // Try allying with each species
        for (int i = 0; i < N; i++) {
            dp[1 << i][i] = 0; // No cost to ally with a species
        }

        // Iterate over all possible subsets of species
        for (int mask = 0; mask < (1 << N); mask++) {
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) == 0) continue; // If i is not in the current subset, skip it
                for (int j = 0; j < N; j++) {
                    if ((mask & (1 << j)) != 0 || W[i][j] == -1)
                        continue; // If j is already in the subset or i cannot defeat j, skip it
                    int nextMask = mask | (1 << j);
                    dp[nextMask][j] = Math.min(dp[nextMask][j], dp[mask][i] + W[i][j]);
                }
            }
        }

        // Find the minimum cost to defeat all species
        int minCost = INF;
        for (int i = 0; i < N; i++) {
            minCost = Math.min(minCost, dp[(1 << N) - 1][i]);
        }

        return minCost == INF ? -1 : minCost;
    }

    public static int bfs(int S, int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[V];
        int maxVal = (int) (1e9);
        Arrays.fill(dist, maxVal);
        dist[S] = 0;
        int cnt = 0;
        q.add(S);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                int node = q.poll();
                for (ArrayList<Integer> list : adj.get(node)) {
                    int adjNode = list.get(0);
                    int distance = list.get(1);
                    if (cnt == 0) {
                        dist[adjNode] = 0;
                    } else {
                        dist[adjNode] = Math.min(dist[adjNode], distance);
                    }
                    q.add(adjNode);
                }
            }
            cnt++;
        }
        for (int i = 0; i < V; ++i) {
            if (dist[i] == maxVal) return -1;
            ans += dist[i];
        }
        return ans;
    }

    public static int minBudgetDefense(int n, int[][] w) {
        int ans = Integer.MAX_VALUE;
        ArrayList<ArrayList<ArrayList<Integer>>> edgeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
            edgeList.add(list1);
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j || w[i][j] == -1) continue;
                ArrayList<Integer> list = new ArrayList<>();
//                list.add(i);
                list.add(j);
                list.add(w[i][j]);
                edgeList.get(i).add(list);
            }
        }


        for (int i = 0; i < n; ++i) {
            int mn = bfs(i, n, edgeList);
            if (mn == -1) continue;
            ans = Math.min(ans, mn);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    public static void main(String[] args) {
        // Example usage:
        int[][] W = {{0, 2, 3}, {1, 0, 4}, {2, 1, 0}};
//        System.out.println(minCost(W)); // Output: 3
        System.out.println(minBudgetDefense(W.length, W)); // Output: 3

        W = new int[][]{{0, 2, -1, 1}, {2, 0, 2, 1}, {-1, 2, 0, 1}, {1, 1, 1, 0}};
//        System.out.println(minCost(W)); // Output: 0
//        System.out.println(minBudgetToDefendAll(W.length,W)); // Expected Output: 0 , Actual Output : 3
        System.out.println(minBudgetDefense(W.length, W)); // Expected Output: 0 , Actual Output : 3


    }
}
