package imp.mathandgeometry;

public class Divisors {

    public static void main(String[] args) {
        int n =36;

        /*
         1 -> 36  , i -> n/i
         2-> 18
         3-> 12
         4-> 9
         6-> 6
         */
        //tc - O(sqrt(n))
        for(int i=1; i<=Math.sqrt(n) ;i++) {

            if(n%i==0) {
                System.out.println(i);
                if(n/i !=i) {                  // will avoid duplicating 6
                    System.out.println(n/i);
                }
            }

        }
    }
}
