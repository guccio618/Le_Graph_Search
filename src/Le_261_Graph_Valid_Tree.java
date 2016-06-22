import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Le_261_Graph_Valid_Tree {
	public boolean validTree(int n, int[][] edges) {
        if(n <= 0){
            return true;
        }
        
        Set<Integer>[] graph = new Set[n];
        Set<Integer> visited = new HashSet<Integer>();
        int branchCount = 0;
        
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        for(int i = 0; i < n; i++){
            if(visited.contains(i)){
                continue;
            } else if(bfs(graph, i, visited) == false){
                return false;
            } 
            branchCount++;
            if(branchCount > 1){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean bfs(Set<Integer>[] graph, int root, Set<Integer> visited){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(root);
        Set<Integer> canReach = new HashSet<Integer>();
        
        while(!q.isEmpty()){
            int num = q.poll();
            Set<Integer> node = graph[num];
            visited.add(num);
            
            if(canReach.contains(num)){     // 注意这里canReach在这里add ！！！
                return false;
            }
            canReach.add(num);
            
            for(int n : node){
                if(visited.contains(n)){
                    continue;
                }
                
                q.offer(n);
            }
        }
        
        return true;
    }
}
