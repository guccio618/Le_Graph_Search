import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Le_207_Course_Schedule {
	/*******************************************************************
	 * (1). 建图
	 * (2). 拓扑排序
	 *  
	 *******************************************************************/
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites.length == 0 || numCourses <= 0){
            return true;
        }
    
        HashSet<Integer>[] graph = new HashSet[numCourses];
        int n = prerequisites.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<HashSet> q = new LinkedList<HashSet>();
        
        for(int i = 0; i < numCourses; ++i){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int i = 0; i < n; ++i){
            if(!graph[prerequisites[i][1]].contains(prerequisites[i][0])){
                graph[prerequisites[i][1]].add(prerequisites[i][0]);
                
                // 这么写也可以，表示有效的前置课的情况；或者就是遍历每个结点下的每个邻居，同标准拓扑排序一样
                if(!map.containsKey(prerequisites[i][0])){
                    map.put(prerequisites[i][0], 1);
                } else {
                    map.put(prerequisites[i][0], map.get(prerequisites[i][0]) + 1);
                }
            }
        }
        
        for(int i = 0; i < numCourses; ++i){
            if(!map.containsKey(i)){
                q.offer(graph[i]);
            }
        }
        
        if(q.isEmpty()){
            return false;
        }
        
        while(!q.isEmpty()){
            HashSet<Integer> node = q.poll();
            for(int nextClass : node){
                if(map.containsKey(nextClass)){
                    int num = map.get(nextClass);
                    if(num == 1){
                        q.offer(graph[nextClass]);
                            map.remove(nextClass);
                    } else {
                        map.put(nextClass, num - 1);
                    }
                }
            }
        }
        
        return map.size() == 0;
    }
}	
