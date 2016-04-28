import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class Le_341_Flatten_Nested_List_Iterator {
	private Stack<NestedInteger> stack = new Stack<NestedInteger>();

    public Le_341_Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return ;
        }
        
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

//    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

//    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger current = stack.peek();
            if(current.isInteger() == true){
                return true;
            }
            
            stack.pop();
            List<NestedInteger> curList = current.getList();
            
            for(int i = curList.size() - 1; i >= 0; i--){
                stack.push(curList.get(i));
            }
        }
        
        return false;
    }
}

