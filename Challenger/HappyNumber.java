
package Challenger;
import java.util.HashSet;
import java.util.Set;

/*
*
*   Date: 04-02-2020
*
*   Prompt : Write an algorithm to determine if a number is "happy".
*            A happy number is a number defined by the following process:
*            Starting with any positive integer, replace the number by the sum of the squares of its digits,
*            and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
*            Those numbers for which this process ends in 1 are happy numbers
*
*   Input: 19
*   Output: true
*    Explanation: 
*        12 + 92 = 82
*        82 + 22 = 68
*        62 + 82 = 100
*        12 + 02 + 02 = 1
*
*
*
*/

public class HappyNumber {

    public static boolean isNumberHappyBrute(int numberToTest){
        
        int one = (numberToTest/1)% 10;
        int ten = (numberToTest/10)% 10;
        int hundred = (numberToTest/100)% 10;
        int thousand = (numberToTest/1000)% 10;
        int ans = (int)Math.pow(one, 2) + (int)Math.pow(ten, 2) + (int)Math.pow(hundred, 2) + (int)Math.pow(thousand, 2);

        while(ans != 1) {

            one = (ans/1)% 10;
            ten = (ans/10)% 10;
            hundred = (ans/100)% 10;
            thousand = (ans/1000)% 10;  
            ans = (int)Math.pow(one, 2) + (int)Math.pow(ten, 2) + (int)Math.pow(hundred, 2) + (int)Math.pow(thousand, 2); 
            if (ans == numberToTest){
                return false;
            }
        }

        return true;
    }

    public static int getNext(int n) {
        
        int totalSum = 0;

        while(n > 0){
            int d = n % 10;
            n = n/10;
            totalSum += d*d;
        }

        return totalSum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> numSet = new HashSet<>();

        while(n != 1 && !numSet.contains(n)) {
            numSet.add(n);
            n = getNext(n);
        }
        return n == 1;
    }


    public static void main(String[] args){
        System.out.println("Expected: true :: actual: "+ isNumberHappyBrute(19));
        System.out.println("Expected: false :: actual: "+ isNumberHappyBrute(20));
        System.out.println("=================================================");
        System.out.println("Expected: true :: actual: "+ isHappy(19));
        System.out.println("Expected: false :: actual: "+ isHappy(20));
    }

}