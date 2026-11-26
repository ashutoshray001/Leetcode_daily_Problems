class Solution {
    public void dfs(int i, int[][] adj, boolean vis[]) {
        int n = adj.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (q.size() != 0) {
            int front = q.remove();
            for (int j = 0; j < n; j++) {
                if (adj[front][j] == 1 && vis[j] == false) {
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, isConnected, vis);
                count++;
            }
        }
        return count;
    }
}