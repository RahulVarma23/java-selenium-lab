package multithreading;

public class Testing {

    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {

        s=s.replaceAll("//s+", "").replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if(s.length()<=1) {
            return true;
        }

        int start =0;
        int end = s.length()-1;

        while(start<end) {
            if(s.charAt(start++) !=s.charAt(end--)) return false;
        }
        return true;
    }
}
