

import java.util.ArrayList;
import java.util.List;

/**
 * This static method will take in a string and return a boolean if it is a palindrome
 */
public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length()==0) {
            return false;
        }else if (s.length()==1) {
            return true;
        } else {

            List<Character> listOfParameterChars = new ArrayList<>();
            List<Character> listOfParameterChars2 = new ArrayList<>();
            
            for (char c : s.toCharArray()){
                listOfParameterChars.add(c);
            }

            for (int i=listOfParameterChars.size()-1; i>=0; i--){
                listOfParameterChars2.add(listOfParameterChars.get(i));
            }

            for (int j = 0; j< listOfParameterChars.size();j++) {
                if (!listOfParameterChars.get(j).equals(listOfParameterChars2.get(j))) {
                    return false;
                }
            }   
        }
        return true;
    }

    public static void main(String[] args) {
    
       String s = "deed";
       System.out.println("This is the practice env. Ready for development");
       System.out.println("Testing deed: " + isPalindrome(s));

    }
}