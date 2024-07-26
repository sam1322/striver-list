package Striver.Graph;

import java.util.*;

class Pair {
    int node;
    int distance;

    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}

public class DijkstraAlgo {
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        int maxVal = (int) (1e9);
        Arrays.fill(dist, maxVal);
        dist[S] = 0;
        pq.add(new Pair(0, S));
        while (!pq.isEmpty()) {
            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for(List<Integer> list : adj.get(node)){
                int edgeWeight = list.get(1);
                int adjNode = list.get(0);
                if(distance + edgeWeight < dist[adjNode]){
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        return dist;
    }


    public static int[] dijkstraUsingSet(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        TreeSet<Pair> set = new TreeSet<>(Comparator.comparingInt(a -> a.distance));

        int[] dist = new int[V];
        int maxVal = (int) (1e9);
        Arrays.fill(dist, maxVal);
        dist[S] = 0;
        set.add(new Pair(0, S));
        while (!set.isEmpty()) {
            Pair it = set.pollFirst();
            int distance = it.distance;
            int node = it.node;
//            System.out.println(set);
//            System.out.println("nodes : " + adj.get(node));
            for(List<Integer> list : adj.get(node)){
                int edgeWeight = list.get(1);
                int adjNode = list.get(0);
                int totaldist = distance + edgeWeight;
//                System.out.println("adj node : "+ adjNode + ", current dist : " + dist[adjNode] + ", new dist : " + totaldist);
                if(distance + edgeWeight < dist[adjNode]){
                    if (dist[adjNode] != maxVal) {
                        set.remove(new Pair(dist[adjNode], adjNode));
                    }

                    dist[adjNode] = distance + edgeWeight;
                    set.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        return dist;
    }


    public static void main(String[] args) {
        int V = 3, E=3,S=2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };


        //add final values of adj here.
        int[] res= dijkstra(V,adj,S);
        int[] res2 = dijkstraUsingSet(V,adj,S);

        for(int i=0;i<V;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();

        for(int i=0;i<V;i++){
            System.out.print(res2[i]+" ");
        }
        System.out.println();
    }
}
