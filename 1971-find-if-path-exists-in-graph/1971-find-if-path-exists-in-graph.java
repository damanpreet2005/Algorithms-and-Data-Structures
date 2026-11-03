class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n]; 

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == destination) {
                return true;
            }

            for (int neighbour : graph[curr]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }

        return false;

    }
}