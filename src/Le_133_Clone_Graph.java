import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Le_133_Clone_Graph {
	/*******************************************************************
	 * 此题为深拷贝，考虑dfs来遍历原图；
	 * 	(1). 用两个队列，一个用于原图dfs，另一个用于纪录对应的新图的结构；
	 *  (2). 用一个hashmap纪录已经建了的新图中的node；当访问old graph中的邻居时，
	 *  	 如果此邻居结点已在map中，则直接取出来；否则就需要新建此结点。
	 *  
	 *******************************************************************/
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return node;
        }
        
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> oldQueue = new LinkedList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> newQueue = new LinkedList<UndirectedGraphNode>();
        oldQueue.offer(node);
        newQueue.offer(root);
        map.put(node.label, root);                // map表示已经建立的新图中的结点, 有了map, 相当于visited
        
        while(!oldQueue.isEmpty()){
            UndirectedGraphNode oldNode = oldQueue.poll();
            UndirectedGraphNode newNode = newQueue.poll();
            
            for(UndirectedGraphNode n : oldNode.neighbors){
                if(map.containsKey(n.label)){      // 已经建立的新图中的结点，则无需继续建立
                    newNode.neighbors.add(map.get(n.label));
                } else {
                    UndirectedGraphNode copy = new UndirectedGraphNode(n.label);
                    newNode.neighbors.add(copy);
                    map.put(copy.label, copy);     // map.put的操作放与此处，即当结点建立了，就立即放入map
                    newQueue.offer(copy);
                    oldQueue.offer(n);
                }
            }
        }
        
        return root;
    }
}
