import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class Le_269_Alien_Dictionary {		
	public String alienOrder(String[] words) {
		if (words == null || words.length == 0){
			return new String();
		}
		
		Queue<Character> q = new LinkedList<Character>();
		Set<Character>[] graph = new Set[256];
		Map<Character, Integer> degree = new HashMap<Character, Integer>();
		StringBuffer result = new StringBuffer();
		
		for (String s : words) {
			for (char c : s.toCharArray()) {
				degree.put(c, 0);
			}
		}
		
		for (int i = 0; i < words.length - 1; i++) {
			String cur = words[i];
			String next = words[i + 1];
			int length = Math.min(cur.length(), next.length());
			
			for (int j = 0; j < length; j++) {
				char c1 = cur.charAt(j);
				char c2 = next.charAt(j);
				if (c1 != c2) {
					if (graph[c1] == null){
						graph[c1] = new HashSet<Character>();
					} 
					
					if (!graph[c1].contains(c2)) {
						graph[c1].add(c2);
						degree.put(c2, degree.get(c2) + 1);
					}
					break;  // 找到第一个不相同的字符
				}
			}
		}
		
		for (char c : degree.keySet()) {
			if (degree.get(c) == 0){
				q.add(c);
			}
		}
		
		while (!q.isEmpty()) {
			char c = q.remove();
			result.append(c);
			if (graph[c] != null) {
				for (char c2 : graph[c]) {
					degree.put(c2, degree.get(c2) - 1);
					if (degree.get(c2) == 0){
						q.add(c2);
					}
				}
			}
		}
		
		if (result.length() != degree.size()){
			return "";
		} else {
		    return result.toString();    
		}
    }
	
	
	public static void main(String[] args){
		Le_269_Alien_Dictionary t = new Le_269_Alien_Dictionary();
//		String[] words = {
//		                 "wrt",
//		                 "wrf",
//		                 "er",
//		                 "ett",
//		                 "rftt"
//						};
		
		String[] words = {"zx","zy"};
		
		System.out.println(t.alienOrder(words));		
	}
}
