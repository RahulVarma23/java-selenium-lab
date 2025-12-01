package imp.recursion;

public class Factorial {

    public int findFactorial(int num) {
        if(num==0 || num ==1){
            return 1;
        }
        return num * findFactorial(num - 1);
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println( f.findFactorial(5));
    }
}
