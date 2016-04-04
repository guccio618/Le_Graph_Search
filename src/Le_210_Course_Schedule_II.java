import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Le_210_Course_Schedule_II {
	/*******************************************************************
	 * 此题为207题的follow up， 需要记录上课的顺序
	 *  
	 *******************************************************************/

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    
        HashSet<Integer>[] graph = new HashSet[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        int[] ans = new int[numCourses];
        int index = 0;
        
        for(int i = 0; i < numCourses; ++i){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int row = 0; row < prerequisites.length; ++row){
            if(graph[prerequisites[row][1]].contains(prerequisites[row][0])){   
        		continue;
        	}
            graph[prerequisites[row][1]].add(prerequisites[row][0]);
            if(map.containsKey(prerequisites[row][0])){
                map.put(prerequisites[row][0], map.get(prerequisites[row][0]) + 1);
            } else {
                map.put(prerequisites[row][0], 1);
            }
        }
        
        for(int i = 0; i < graph.length; ++i){
            if(!map.containsKey(i)){
                q.offer(i);
            }
        }
        
        if(q.isEmpty()){
            return new int[0];
        }
        
        while(!q.isEmpty()){
            int temp = q.poll();
            ans[index++] = temp;
            for(int nextClass : graph[temp]){
                if(map.containsKey(nextClass)){
                    int count = map.get(nextClass);
                    if(count == 1){
                        map.remove(nextClass);
                        q.offer(nextClass);
                    } else {
                        map.put(nextClass, count - 1);
                    }
                }
            }
        }
        
        return map.size() == 0 ? ans : new int[0];
    }
}
