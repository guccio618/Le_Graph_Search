import java.util.ArrayList;
import java.util.List;

/*******************************************************************
 * (1). 图和搜索的常见方法为BFS, DFS, 引入辅助visited set或者visited 矩阵，
 *      或者采用memoSearch方法(如题329)降低重复计算。
 * (2). 需要注意的是visited add元素的时机有两种，1是在将neighbor加入队列之前，
 *      2是在q.poll之后
 * (3). 注意题型：126, 127, *130(如何将二维矩阵压入队列的方法！！！)，*133, 207, **261, *269, 
 * 		**301, **310, 329, **332, 341, 
 *  
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

class NestedInteger{
	int val;
	List<NestedInteger> list;
	
	public NestedInteger(int v){
		val = v;
		list = null;
	}
	
	public NestedInteger(List<NestedInteger> l){
		list = l;
	}
	
	public boolean isInteger(){
		return list == null;
	}
	
	public int getInteger(){
		return val;
	}
	
	public List<NestedInteger> getList(){
		return list;
	}
}


