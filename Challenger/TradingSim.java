package Challenger;
public class TradingSim {

    public static int[] testCase1 = {7,1,5,3,6,4}; // 7
    public static int[] testCase2 = {1,2,3,4,5}; // 4
    public static int[] testCase3 = {7,6,4,3,1}; // 0
    public static int[] testCase4 = {1,6,4,3,7,11}; // 13
    public static int[] testCase5 = {1,11,1,1,21,1,1}; //
    public static int[] testCase6 = {4,5,8,3,5,6}; // 7

    public static int findBestTradeBruteForce(int[] prices) {
        int maxProfForDay = 0;
        if (prices.length < 2) {
            return 0;
        }
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int currCal = prices[j] - prices[i];
                maxProfForDay = Math.max(currCal, maxProfForDay);
            }
        }
        return maxProfForDay;
    }

    public static int findBestTradeSinglePass(int[] prices) {

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i -1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        System.out.println("Expected: 5 :: Actual: " + findBestTradeBruteForce(testCase1));
        System.out.println("Expected: 4 :: Actual: " + findBestTradeBruteForce(testCase2));
        System.out.println("Expected: 0 :: Actual: " + findBestTradeBruteForce(testCase3));

        System.out.println("============================================================");

        System.out.println("Expected: 7 :: Actual: " + findBestTradeSinglePass(testCase1));
        System.out.println("Expected: 4 :: Actual: " + findBestTradeSinglePass(testCase2));
        System.out.println("Expected: 0 :: Actual: " + findBestTradeSinglePass(testCase3));
        System.out.println("Expected: 13 :: Actual: " + findBestTradeSinglePass(testCase4));
        System.out.println("Expected: 30 :: Actual: " + findBestTradeSinglePass(testCase5));
        System.out.println("Expected: 7 :: Actual: " + findBestTradeSinglePass(testCase6));


    }
}