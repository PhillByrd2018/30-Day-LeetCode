import java.util.Arrays;

public class MoveZeroes {

    public static int[] testCase1 = {0,1,0,3,12}; // [1,3,12,0,0]
    public static int[] testCase2 = {0,0,1,12,3}; // [1,3,12,0,0]
    public static int[] testCase3 = {1,0,0,3,0,12}; // [1,3,12,0,0]
    public static int[] testCase4 = {1,5,0,0,3,0,12}; // [1, 5, 3, 12, 0, 0, 0]

    public static int[] moveZeroesWhile(int[] nums) {
        int indexOfZero = 0;
        int l = 0;
        int r = nums.length;

        while (l < r) {
            if (nums[l] != 0) {
                int temp = nums[indexOfZero];
                nums[indexOfZero++] = nums[l];
                nums[l] = temp;
            }
            l++;
        }
        
        return nums;
    }

 public static void main(String[] args) {
   
    System.out.println("Expected output: [1, 3, 12, 0, 0] :: actual: " + Arrays.toString(moveZeroesWhile(testCase1)));
    System.out.println("Expected output: [1, 12, 3, 0, 0] :: actual: " + Arrays.toString(moveZeroesWhile(testCase2)));
    System.out.println("Expected output: [1, 3, 12, 0, 0, 0] :: actual: " + Arrays.toString(moveZeroesWhile(testCase3)));
    System.out.println("Expected output: [1, 5, 3, 12, 0, 0, 0] :: actual: " + Arrays.toString(moveZeroesWhile(testCase4)));
    }
}