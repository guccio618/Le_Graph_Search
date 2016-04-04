import java.util.ArrayList;
import java.util.List;
/*******************************************************************
 * (1). 图和搜索的常见方法为BFS, DFS, 引入辅助visited set或者visited 矩阵，
 *      或者采用memoSearch方法(如题329)降低重复计算。
 * (2). 需要注意的是visited add元素的时机有两种，1是在将neighbor加入队列之前，
 *      2是在q.poll之后
 * (3). 注意题型：126, 130，301，332，178
 *  
 *******************************************************************/

public class Datastructure_Definition {

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;
	
	DirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<DirectedGraphNode>(); 
	}
}
