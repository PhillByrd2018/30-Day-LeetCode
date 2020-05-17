package Challenger;

import java.util.regex.Pattern;

public class StringToInteger {

    public static int myAtoi(String str) {

        String regex = "([-+]?\\d+)([\\s+-.\\da-zA-Z]*)";
        Pattern pattern = Pattern.compile(regex);
        
        str = str.trim();       
       
        java.util.regex.Matcher matcher = pattern.matcher(str);
        boolean match = matcher.matches();       
                 
        if(match) {                
                       	
                String value = matcher.group(1);
                boolean isNegative = false;
                if(str.startsWith("-")) {
                    isNegative = true;
                }              

                try {
                    int intValue = Integer.parseInt(value);				
                    return intValue;				
                } catch (Exception e) {
                    if(isNegative) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }

                }
        } else {
                return 0;
            }    
    }

    public static void main(String[] args) {
        // System.out.println("Expected: 42 :: Actual: " + myAtoi("42"));
        System.out.println("Expected: -42 :: Actual: " + myAtoi("-42"));
        System.out.println("Expected: -42 :: Actual: " + myAtoi("         -42"));
        System.out.println("Expected: 0 :: Actual: " + myAtoi("gfdgfdsgfsdg42"));
        System.out.println("Expected: 42 :: Actual: " + myAtoi("42gfdgsfgs"));
        System.out.println("Expected: 42 :: Actual: " + myAtoi("42gfdgsfgs"));
        System.out.println("Expected: 0 :: Actual: " + myAtoi("+"));
    }
}