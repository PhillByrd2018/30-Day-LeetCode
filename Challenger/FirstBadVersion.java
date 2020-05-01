package Challenger;

import java.util.HashMap;
import java.util.Map;

public class FirstBadVersion {

    public static Map<Integer, Boolean> versions;

    public static int firstBadVersion(int n) {
        int start = 0;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }

        return start;
    }

    public static boolean isBadVersion(int versionToCheck){

       return versions.get(versionToCheck);

    }

    public static Map<Integer, Boolean> makeVersionsMap(int length, int firstBadVersion){
        versions = new HashMap<>();
        int i =1;
        boolean isBad = false;
        while (i<=length) {
            isBad = (i==firstBadVersion) ? true : false;
            versions.put(i, isBad);
            i++;
        }
         return versions;
    }

    public static void main(String[] args) {

        makeVersionsMap(15, 7);
        System.out.println("Expected: 7 :: Actual: " + firstBadVersion(15));

        makeVersionsMap(150, 46);
        System.out.println("Expected: 46 :: Actual: " + firstBadVersion(150));
    }
}