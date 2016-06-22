import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class Le_332_Reconstruct_Itinerary {
	/*******************************************************************
	 * (1). 用map建立目的地＋其能去的地点链表的关系。
	 * (2). 对各自目的地链表排序
	 * (3). dfs
	 * 注意：如何在不知道图中总结点树的情况下，用map来dfs遍历一个图的方法
	 *  
	 *******************************************************************/
	
	public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if(tickets == null || tickets.length == 0 || tickets[0].length == 0){
            return res;
        }
        
        Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        int len = tickets.length;
        
        for(int i = 0; i < len; ++i){
        	if(map.containsKey(tickets[i][0])){
        		map.get(tickets[i][0]).add(tickets[i][1]);
        	} else{
        		LinkedList<String> tempList = new LinkedList<String>();  // 注意只有linkedlist有poll()！！！
        		tempList.add(tickets[i][1]);
        		map.put(tickets[i][0], tempList);
        	}
        }
        
        for(Map.Entry<String, LinkedList<String>> entry : map.entrySet()){
            Collections.sort(entry.getValue());
        }
        
        Stack<String> stack = new Stack<String>();
        stack.add("JFK");
        
        // 以下是深度优先搜索的写法，必须写成这样；注释部分写法不正确
        // stack不断push之后，stack的peek()是不断变化的
        // 如何在不知道图中总结点树的情况下，用map来dfs遍历一个图的方法：
        while (!stack.empty()) {  
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()){
                stack.push(map.get(stack.peek()).poll());
            }
            res.add(0, stack.pop());
            
//            String str = stack.pop();
//            while (map.containsKey(str) && !map.get(str).isEmpty()){
//                stack.push(map.get(str).poll());
//            }
//            res.add(0, str);
        }
        
        return res;
    }
	
	
	public static void main(String[] args){
		Le_332_Reconstruct_Itinerary t = new Le_332_Reconstruct_Itinerary();
		String[][] tickets = {
				{"MUC","LHR"},
				{"JFK","MUC"},
				{"SFO","SJC"},
				{"LHR","SFO"}
		};
		List<String> res = t.findItinerary(tickets);
		for(int i = 0; i < res.size(); ++i){
			System.out.print(res.get(i) + ", ");
		}
	}
}
