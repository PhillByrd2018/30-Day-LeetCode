package Challenger;

import java.util.*;
import java.util.stream.Collectors;


public class RockBreaker {

    public static int[] testCase1 = { 2, 7, 4, 1, 8, 1 };
    public static int[] testCase2 = { 239,198,980,404,413,804,912,546,849,506,917,837,210,837,917,6,723,929,506,438,267,225,533,312,568,596,82,685,138,276 };

    public static int breakSomeRocks(int[] rocks) {
        int ans = 0;
    
        if (rocks.length == 0 || rocks == null){
            return 0;
        }

        Arrays.sort(rocks);
        List<Integer> rocksList = Arrays.stream(rocks).boxed().collect(Collectors.toList());
        int length = rocksList.size();

        while(length > 1) {
            Integer biggestRock = rocksList.get(length-1);
            Integer secondBiggestRock = rocksList.get(length-2);
            
            if (biggestRock.intValue() == secondBiggestRock.intValue()) {
                rocksList.remove(length-1);
                rocksList.remove(length-2);
                length -= 2;
            } else if (biggestRock.intValue() > secondBiggestRock.intValue()) {
                Integer newBiggestRockSize = biggestRock - secondBiggestRock;
                rocksList.remove(length-1);
                rocksList.remove(length-2);
                length--;
                rocksList.add(length-1, newBiggestRockSize);
            }
            Collections.sort(rocksList);
        }

        if (length == 1) {
            ans =  rocksList.get(0);
        }
        return ans;
    }

    public static void main(String[] args) {
        
        System.out.println("Expected: 1 :: Actual: " + breakSomeRocks(testCase1));
        System.out.println("Expected: 1 :: Actual: " + breakSomeRocks(testCase2));
    }

}