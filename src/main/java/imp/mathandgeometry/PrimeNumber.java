package imp.mathandgeometry;

public class PrimeNumber {

	public static void main(String[] args) {
        System.out.println(checkPrime(67));
        System.out.println(checkPrimeNum(67));
        System.out.println(checkPrimeN(67));
	}

    //TC: O(N)
	private static boolean checkPrime(int num) {
		boolean flag= true;
		for(int i=2; i<=num/2;i++) {
			if ((num % i == 0)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

    //O(sqr(n) TC
    private static boolean checkPrimeNum(int num) {
        if(num<=1) return false;

        for(int i=2; i<=Math.sqrt(num);i++) {
            if ((num % i == 0)) {
                return false;
            }
        }
        return true;
    }

    //O(sqr(n) TC
    private static boolean checkPrimeN(int num) {
        int count =0;

        for(int i=1; i<=Math.sqrt(num);i++) {
                if(num%i==0) {
                    count++;
                    if(num/i !=i) {    //avoid duplicates
                        count++;
                    }
                }
        }
        if(count ==2 ) {     //if no is divisible by 1 and no itself then its prime no
            return true;
        }

        return false;
    }
}
