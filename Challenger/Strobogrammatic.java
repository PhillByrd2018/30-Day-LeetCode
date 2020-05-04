package Challenger;

import java.util.HashMap;
import java.util.Map;

public class Strobogrammatic {


    public static boolean isStrobogrammatic(String num) {
        
        if (num == null) {
            return true;
        }
        
    
        if (num.isEmpty()) {
            return true;
        }
        
        int start = 0;
        int end = num.length()-1;
        
        Map<Character, Character> stroboMap = new HashMap<>();
        stroboMap.put('0','0');
        stroboMap.put('1','1');
        stroboMap.put('8','8');
        
        if (num.length() == 1 ) {
            if (stroboMap.keySet().contains(num.charAt(start))) {
                return true;
            } else {
                return false;
            }
            
        }
        
        stroboMap.put('9','6');
        stroboMap.put('6','9');
        
        while(start <= end){
            if (start == end) {
             if (num.charAt(start) != '0' && num.charAt(start) != '1' && num.charAt(start) != '8') {
                 return false;
             }
            }
            if (!stroboMap.keySet().contains(num.charAt(start)) || !stroboMap.keySet().contains(num.charAt(end))) {
                return false;
            }
            if (stroboMap.get(num.charAt(start)) != num.charAt(end)) {
                return false;
            }
            start++;
            end--;
            
        }
        return true;
        
    }
    public static void main(String[] args) {
        System.out.println("Expected: false :: Actual: " + isStrobogrammatic("6963"));
        System.out.println("Expected: true :: Actual: " + isStrobogrammatic("69"));
        System.out.println("Expected: true :: Actual: " + isStrobogrammatic("0"));
        System.out.println("Expected: true :: Actual: " + isStrobogrammatic("888888888888888888888888888888888888"));
        System.out.println("Expected: false :: Actual: " + isStrobogrammatic("2"));
    }
    
}