import java.util.HashSet;
import java.util.Set;

/*
*
*   Date: 04-02-2020
*
*   Prompt : Given a non-empty array of integers, every element appears twice except for one. Find that single one.
*
*   Input: [2,2,1]
*   Output: 1
*
*
*
*/

public class SingleNumber {

    public static int GetSingleNumber(int[] nums){

        Set<Integer> numSet = new HashSet<>();

        for(int num : nums){
            if (numSet.contains(num)) {
                numSet.remove(num);
            } else {
                numSet.add(num);
            }
        }
        
        return numSet.stream().findFirst().orElse(-1);
    }


    public static void main(String[] args) {

        int[] testCase1 = new int[]{1,3,2,3,2,4,1};
        int[] testCase2 = new int[]{1,3,5,2,3,2,4,1,4};

        System.out.println("Expected output: 4 :: actual: " + GetSingleNumber(testCase1));
        System.out.println("Expected output: 5 :: actual: " + GetSingleNumber(testCase2));

    }
}