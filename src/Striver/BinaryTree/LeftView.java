package Striver.BinaryTree;

import java.util.*;

public class LeftView {
    public static ArrayList<Integer> leftView(Node root) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            if (n > 0) ans.add(q.peek().data);
            for (int i = 0; i < n; ++i) {
                Node cur = q.poll();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return ans;
    }

    private static void dfs(Node root, int width, int height, Map<Integer, Integer[]> mp) {
        if (root == null) return;
        if (!mp.containsKey(width)) {
            mp.put(width, new Integer[]{height, root.data});
        } else {
            Integer[] arr = mp.get(width);
            int h = arr[0];
            if (h < height) {
                mp.put(width, new Integer[]{height, root.data});
            }
        }
        dfs(root.left, width - 1, height + 1, mp);
        dfs(root.right, width + 1, height + 1, mp);

    }

    public static ArrayList<Integer> bottomView1(Node root) {
        Map<Integer, Integer[]> mp = new HashMap<>();
        dfs(root, 0, 0, mp);
        ArrayList<Integer> sortedKeys = new ArrayList<>(mp.keySet());

        Collections.sort(sortedKeys);
        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer i : sortedKeys) {
            arr.add(mp.get(i)[1]);
        }
        return arr;
    }

    public static ArrayList<Integer> bottomView(Node root) {
        Map<Integer, Integer> mp = new HashMap<>();
        Queue<Object[]> q = new LinkedList<>();
        if (root != null) q.add(new Object[]{root, 0});
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                Object[] obj = q.poll();
                Node curr = (Node) obj[0];
                Integer width = (Integer) obj[1];
                mp.put(width, curr.data);
                if (curr.left != null) q.add(new Object[]{curr.left, width - 1});
                if (curr.right != null) q.add(new Object[]{curr.right, width + 1});
            }
        }
        ArrayList<Integer> sortedKeys = new ArrayList<>(mp.keySet());

        Collections.sort(sortedKeys);
        ArrayList<Integer> arr = new ArrayList<>();
//        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
//            arr.add(entry.getValue());
//        }

        for (Integer i : sortedKeys) {
//            System.out.println(i+" : " + mp.get(i));
            arr.add(mp.get(i));
        }
        return arr;
    }

}
