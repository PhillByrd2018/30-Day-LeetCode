package Challenger;

import java.util.Arrays;

public class ClosestPoint {

    public static int[][] kClosest(int[][] points, int K) {
        // first we create an array to hold the distances from each point to [0,0]
        int N = points.length;
        int[] distances = new int[N];

        // we loop through and calculate each distance
        for (int i = 0; i < N; i++) {
            distances[i] = findDistance(points[i]);
        }
        // we sort for the shortest K distances
        Arrays.sort(distances);

        // we then find the largest distance that within the smallest K distances
        int KSmallestDistance = distances[K - 1];

        // we then make an answer array
        int[][] ans = new int[K][2];

        int t = 0;
        // we then loop through the input 2d array and if that distance is less that the
        // Kth distance we add it to the answer array.
        for (int i = 0; i < N; ++i)
            if (findDistance(points[i]) <= KSmallestDistance)
                ans[t++] = points[i];
        return ans;
    }

    // this formula will find the distance from that point to [0,0]
    public static int findDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        int[][] testCase1 = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        System.out.println("Expected: [[3, 3],[-2, 4]] :: Actual: " + Arrays.deepToString(kClosest(testCase1, 2)));
    }
}