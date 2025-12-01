package imp.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        String s = "abbccdd";
        System.out.println(reorganizeString(s));
    }

    //TC: O(nlogK) , SC: O(n)
    private static String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for(char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        // Max heap ordered by frequency
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a,b)-> b.getValue() - a.getValue()
        );

        pq.addAll(freq.entrySet());

        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;

        while(!pq.isEmpty()) {

            //get most frequent char
            Map.Entry<Character, Integer> curr = pq.poll();
            result.append(curr.getKey());

            //decrease frequency
            curr.setValue(curr.getValue()-1);

            // Reinsert the previous character if it still has remaining count
            if(prev !=null && prev.getValue()>0) {
                pq.add(prev);
            }

            // Current char becomes previous for next round
            prev = curr;
        }

       return s.length()==result.length() ? result.toString():"";
    }
}
