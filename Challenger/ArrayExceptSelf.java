import java.util.Arrays;

public class ArrayExceptSelf {

    public static int[] testCase1 = {1,2,3,4};

    //this is a N^2 solution
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = findProduct(nums, i);
        }
        return ans;
    }

    public static int findProduct(int[] nums, int indexToExclude) {
        int product = 1;
        for(int j=0; j< nums.length; j++) {
            if (j != indexToExclude) {
                product *= nums[j];
            }
        }
        return product;
    }

    public static int[] findProductExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;

        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println("Expected: :: Actual: " + Arrays.toString(productExceptSelf(testCase1)));

        System.out.println("=====================================================================");

        System.out.println("Expected: :: Actual: " + Arrays.toString(findProductExceptSelf(testCase1)));
    }
}


//create array that is the length of the input array
//create a variable that holds the product of all the elements in the input array
    //create a signature that takes in an array and an int that excludes a single element in the array