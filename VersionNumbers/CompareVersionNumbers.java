public class CompareVersionNumbers {

    public static String testCase1 = "7.5.2.4";
    public static String testCase2 = "7.5.3";
    public static String testCase3 = "0.1";
    public static String testCase4 = "1.1";
    public static String testCase5 = "0.0000001";
    public static String testCase6 = "0.001";
    public static String testCase7 = "1.1";
    public static String testCase8 = "1.0.1";
    public static String testCase9 = "1";
    


    public static int compareVersion(String version1, String version2) {

        String[] versions1 = version1.split("[.]");
        String[] versions2 = version2.split("[.]");
        
        for (int i = 0; i < Math.min(versions1.length, versions2.length); i++) {
            if (processVersions(versions1[i]) > processVersions(versions2[i])) {
                return 1;
            } else if (processVersions(versions2[i]) > processVersions(versions1[i])) {
                return -1;
            }
        }

        if ( (versions1.length > versions2.length) && (processVersions(versions1[versions1.length-1]) != 0) ) {
            return 1;
        } else if ((versions2.length > versions1.length) && (processVersions(versions2[versions2.length-1]) != 0)) {
            return -1;
        }

        return 0;
    }

    public static int processVersions(String S) {

        S.replaceAll("0", "");

        return Integer.parseInt(S);
    }


    public static int slickSolution(String version1, String version2) {

        String[] versions1 = version1.split("[.]");
        String[] versions2 = version2.split("[.]");

        int lengthV1 = versions1.length;
        int lengthV2 = versions2.length;

        int ver1Spot, ver2Spot;
        for (int i = 0; i < Math.max(lengthV1, lengthV2); ++i) {
            ver1Spot = i < lengthV1 ? Integer.parseInt(versions1[i]) : 0;
            ver2Spot = i < lengthV2 ? Integer.parseInt(versions2[i]) : 0;

            if (ver1Spot != ver2Spot) {
                return ver1Spot > ver2Spot ? 1 : -1;
            }
        }

        return 0;

    } 

    public static void main(String[] args) {

        System.out.println("Expected: -1 :: Actual: " + compareVersion(testCase1, testCase2));
        System.out.println("Expected: -1 :: Actual: " + compareVersion(testCase3, testCase4));
        System.out.println("Expected: 1 :: Actual: " + compareVersion(testCase1, testCase4));
        System.out.println("Expected: 0 :: Actual: " + compareVersion(testCase5, testCase6));
        System.out.println("Expected: 1 :: Actual: " + compareVersion(testCase8, testCase9));
        System.out.println("==============================================================");


        System.out.println("Expected: -1 :: Actual: " + slickSolution(testCase1, testCase2));
        System.out.println("Expected: -1 :: Actual: " + slickSolution(testCase3, testCase4));
        System.out.println("Expected: 1 :: Actual: " + slickSolution(testCase1, testCase4));
        System.out.println("Expected: 0 :: Actual: " + slickSolution(testCase5, testCase6));
        System.out.println("Expected: 1 :: Actual: " + slickSolution(testCase8, testCase9));
        
        
    }
}