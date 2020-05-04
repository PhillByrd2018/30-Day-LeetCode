package Challenger;

public class NumberComplement {
    public static int findComplement(int num) {

        String binaryValue = Integer.toBinaryString(num);
        StringBuilder strBuild = new StringBuilder();
        for (char bin : binaryValue.toCharArray()) {
            if (bin == '0') {
                strBuild.append('1');
            } else if (bin == '1') {
                strBuild.append('0');
            }
        }

        int ans = Integer.parseInt(strBuild.toString(), 2);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Expected: 2 :: Actual : " + findComplement(5));
        System.out.println("Expected: 0 :: Actual : " + findComplement(1));
    }
}