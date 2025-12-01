package imp.heap;

import java.util.PriorityQueue;

public class LongestHappyString {

    /*
    Use a max-heap (priority queue) to always choose the character with the highest remaining count.
    Before appending the chosen character, check if adding it would cause three consecutive identical letters.
    If it would, try using the next highest count character instead.
    If no alternative is available, the process stops.
     */

    public static void main(String[] args) {
        int a = 3, b = 4, c = 2;
        LongestHappyString longestHappyString = new LongestHappyString();
        System.out.println(longestHappyString.longestDiverseString(a,b,c));
    }

    private String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharCount> maxHeap = new PriorityQueue<>(
                (x,y) -> y.count-x.count
        );

        if(a>0) maxHeap.add(new CharCount('a',a));
        if(b>0) maxHeap.add(new CharCount('b',b));
        if(c>0) maxHeap.add(new CharCount('c',c));

        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            CharCount first = maxHeap.poll();
            int len = result.length();

            if(len>=2 && result.charAt(len-1)==first.ch && result.charAt(len-2)==first.ch) {
                if(maxHeap.isEmpty()) {
                    break;
                }
                CharCount second = maxHeap.poll();
                result.append(second.ch);
                second.count--;
                if(second.count>0) {
                    maxHeap.add(second);
                }
                maxHeap.add(first);
            }else {
                result.append(first.ch);
                first.count--;
                if(first.count>0) {
                    maxHeap.add(first);
                }
            }
        }

        return result.toString();
    }

     class CharCount {
        int count;
        char ch;

        CharCount(char ch, int count){
            this.ch = ch;
            this.count=count;
        }
    }
}
