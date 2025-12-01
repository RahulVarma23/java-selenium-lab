package imp.heap;

import java8.PredicateDemo;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int [] nums = {1,2,2,3,3,3,4,4,4,4,4};

        System.out.println(Arrays.toString(topKFrequentByMinHeap(nums, 3)));
    }

    private  static int [] topKFrequentBySorting(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        List <Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b)-> map.get(b)-map.get(a));

        int [] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }

        return ans;
//        return map.entrySet().stream()
//                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
//                .limit(k)
//                .mapToInt(Map.Entry::getKey)
//                .toArray();
    }

    private  static int [] topKFrequentByMinHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        // min-heap (smallest frequency at top)
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            minHeap.add(entry);
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }

        int [] ans = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()) {
            ans[i++] = minHeap.poll().getKey();
        }

        return ans;
    }
}
