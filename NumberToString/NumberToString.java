package NumberToString;

public class NumberToString {
    // https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/481/

    public static int testCase1 = 315;

    public static String convertNumToString(int num){
        String ans = "";

        String numString = String.valueOf(num);
        int length = numString.length();

        for (int i = 0; i < length; i++) {

        }


        return ans;
    }

    public static void main(String[] args) {
        
        System.out.println("Expected Three Hundred and fifteen :: Actual: " + convertNumToString(testCase1));
    }
}