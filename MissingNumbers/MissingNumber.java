package MissingNumbers;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static int MissingNumberArray(int[] nums){
        java.util.Arrays.sort(nums);
        int length = nums.length;

        if (nums[length-1] != nums.length-1) {
            return length;
        } else if (nums[0]!= 0) {
            return 0;
        }

        for (int i=1; i< length; i++) {
            int expectedNum = nums[i-1]+1;
            if(nums[i]!=expectedNum){
                return expectedNum;
            }
        }

        return -1;
    }


    public static int MissingNumberSet(int[] nums){
        Set<Integer> numSet = new HashSet<>();

        for(int num : nums){
            numSet.add(num);
        }

        int expectedCount = numSet.size();
        for (int number = 0; number< expectedCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }

        return expectedCount;
    }


    public static void main(String args[]){
        int[] testCase1 = new int[]{0};
        int[] testCase2 = new int[]{1};
        int[] testCase3 = new int[]{0,1,2,3,4,5,6};
        int[] testCase4 = new int[]{3,5,2,1,0};

     
        System.out.println("expected output: 1 :: Actual: " + MissingNumberArray(testCase1));

        System.out.println("expected output: 0 :: Actual: " + MissingNumberArray(testCase2));

        System.out.println("expected output: 7 :: Actual: " + MissingNumberArray(testCase3));
        
        System.out.println("expected output: 4 :: Actual: " + MissingNumberArray(testCase4));

        System.out.println("==============================================================");

        System.out.println("expected output: 1 :: Actual: " + MissingNumberSet(testCase1));

   
        System.out.println("expected output: 0 :: Actual: " + MissingNumberSet(testCase2));

     
        System.out.println("expected output: 7 :: Actual: " + MissingNumberSet(testCase3));

     
        System.out.println("expected output: 4 :: Actual: " + MissingNumberSet(testCase4));


        
    }

}