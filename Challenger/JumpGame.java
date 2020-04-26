package Challenger;

import javax.swing.text.Position;

public class JumpGame {

    public static int[] testCase1 = { 2, 3, 1, 1, 4 };
    public static int[] testCase2 = { 3, 2, 1, 0, 4 };
    public static int[] testCase3 = { 3000, 2, 1, 0, 4 };

    public static boolean canJump(int[] nums) {

        if (nums.length < 2) {
            return true;
        }

        return canJumpFromCurrentPosition(0, nums);

    }

    public static boolean canJumpFromCurrentPosition(int currentPosition, int[] nums) {

        int endPosition = nums.length - 1;

        // if the current position is at the end, we are done and can return true
        if (currentPosition == endPosition) {
            return true;
        }

        // otherwise we take the current position and add the jump from the value at the
        // position or the end of the array if it is smaller.
        int nextJumpFurthest = Math.min(currentPosition + nums[currentPosition], endPosition);

        // we then loop from the current position out to the next furthest possible jump
        // to see if we make it to the end.
        for (int nextPossible = nextJumpFurthest; nextPossible > currentPosition; nextPossible--) {

            // we call the method recursively and if at any point we reach the end of the
            // array, we return true;
            if (canJumpFromCurrentPosition(nextPossible, nums)) {
                return true;
            }
        }

        return false;
    }

    public static boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        // System.out.println("Expected: true :: Actual: " + canJump(testCase1));
        // System.out.println("Expected: false :: Actual: " + canJump(testCase2));
        // System.out.println("Expected: true :: Actual: " + canJump(testCase3));
        System.out.println("===============================================");
        System.out.println("Expected: true :: Actual: " + canJumpGreedy(testCase1));
        System.out.println("Expected: true :: Actual: " + canJumpGreedy(testCase2));
        System.out.println("Expected: true :: Actual: " + canJumpGreedy(testCase3));
    }
}