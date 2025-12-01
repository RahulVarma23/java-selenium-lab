package imp.heap;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharsByFrequency {

    //TC: 0(nlogn) SC: O(n)
    public static String frequencySortByList(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        List<Character> chars = new ArrayList<>(freq.keySet());

        //chars.sort((a, b) -> freq.get(b) - freq.get(a)); // sort by frequency desc

        List<Character> list = chars.stream().sorted((a,b)-> freq.get(b)-freq.get(a)).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (char c : list)
            sb.append(String.valueOf(c).repeat(freq.get(c)));

        return sb.toString();
    }

    //TC: 0(nlogk) SC: O(n)
    public static String frequencySortByPriorityQueue(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a,b)-> freq.get(b)-freq.get(a)
        );

        pq.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            char c = pq.poll();
            sb.append(String.valueOf(c).repeat(freq.get(c)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySortByList("tree"));
        System.out.println(frequencySortByPriorityQueue("tree"));
    }
}
