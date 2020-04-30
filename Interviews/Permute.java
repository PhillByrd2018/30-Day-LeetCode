package Interviews;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public static List<List<Integer>> permute(int[] nums) {
        
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        
        permuteHelper(ans, row, nums);
        return ans;
    }

    public static void permuteHelper(List<List<Integer>> ans, List<Integer> row, int[] nums) { 
    
        if (row.size() == nums.length) {
            ans.add(new ArrayList<>(row));
        } else {
            for (int j=0; j< nums.length; j++) {
                if (row.contains(nums[j])) {
                    continue;
                }
                row.add(nums[j]);
                permuteHelper(ans, row, nums);
                row.remove(row.size()-1);
            }
        }
    
    }
    public static void printAns(List<List<Integer>> ans) {

        ans.forEach(System.out::println);

    }
    

    public static void main(String[] args) {
        int[] test = {1, 2, 3};
        List<List<Integer>> testCase1 = permute(test);
        printAns(testCase1);
    }
    
}