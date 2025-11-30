package mathandgeometry;

public class SelfDividingNumber {


    public static boolean isNumberSelfDividing(int number) {

        String s = String.valueOf(number);

        for(int i=0;i<s.length();i++) {

            int num;
            num = Integer.parseInt(String.valueOf(s.charAt(i)));

            if(number % num !=0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumberSelfDividing(128));
    }


}
