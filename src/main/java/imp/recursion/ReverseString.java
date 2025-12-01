package imp.recursion;

public class ReverseString {

    public String reverseString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString("abcsd"));
    }
}
