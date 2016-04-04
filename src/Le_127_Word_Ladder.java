import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Le_127_Word_Ladder {
	/*******************************************************************
	 * 此题可以理解为是一种状态图，从而进行bfs查找
	 *  
	 *******************************************************************/
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null){
            return 0;
        } else if(beginWord.equals(endWord)){
            return 0;
        }
        
        int count = 1;
        Queue<String> q = new LinkedList<String>();
        HashSet<String> visited =  new HashSet<String>();
        q.offer(beginWord);
        visited.add(beginWord);
        wordList.add(endWord);
        
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i = 0; i < size; ++i){
                String str = q.poll();
                for(String s : findWords(str, wordList)){
                    if(visited.contains(s)){
                        continue;
                    }
                    if(s.equals(endWord)){
                        return count;
                    }
                    visited.add(s);
                    q.offer(s);
                }
            }
        }
        
        return 0;
    }
    
    
    public ArrayList<String> findWords(String str, Set<String> wordList){
        ArrayList<String> list = new ArrayList<String>();
        char[] array = str.toCharArray();
        for(int i = 0; i < array.length; ++i){
            char temp = array[i];
            for(char c = 'a'; c <= 'z'; ++c){
                if(c == temp){
                    continue;
                }
                array[i] = c;
                String newWord = new String(array);
                if(wordList.contains(newWord)){
                    list.add(newWord);
                }
            }
            array[i] = temp;
        }
        return list;
    }
}
