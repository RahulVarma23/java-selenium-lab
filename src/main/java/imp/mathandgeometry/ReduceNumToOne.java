package imp.mathandgeometry;

public class ReduceNumToOne {

    public static boolean checkOddEven(int num){
        return num % 2 == 0;
    }

    public static void reduceNumbertoOne(int num){

        System.out.print(num);
            while(num!=1){
                boolean flag=checkOddEven(num);
                if(flag){
                    num=num/2;
                }
                else{
                    num=(num*3)+1;
                }
                System.out.print(" "+num);
            }
    }

    public static void main(String[] args) {
        reduceNumbertoOne(7);
    }
}
