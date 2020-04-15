package Challenger;
public class PerformStringShifts {

    public static int[][] testCase1 = {{0,1}, {1,2}};
    public static String testCase2 = "abc";
    public static int[][] testCase3 = {{1,1}, {1,1}, {0,2}, {1,3}};
    public static String testCase4 = "abcdefg";

    public static String stringShift(String s, int[][] shift) {
        String ans = "";
        int leftMoves = 0;
        int rightMoves = 0;

        //validation
        if (s.length() == 1) {
            return s;
        }

        //step through array and calc total number of moves
        for (int[] moves : shift) {
            if (moves[0] == 0) {
                leftMoves += moves[1];
            } else if (moves[0]==1) {
                rightMoves += moves[1];
            }
        }

        //call our funcs with total number of moves
        ans = moveLeft(s, leftMoves);
        ans = moveRight(ans, rightMoves);

        return ans;
    }

    public static String moveLeft(String s, int moves) {
        StringBuilder ret = new StringBuilder();
        ret.append(s);
        for (int i = moves; i > 0; i--) {
            ret.insert(ret.length(), ret.charAt(0));
            ret.deleteCharAt(0);
        }

        return ret.toString();
    }
    public static String moveRight(String s, int moves) {
        StringBuilder ret = new StringBuilder();
        ret.append(s);
        for (int i = moves; i > 0; i--) {
            ret.insert(0, ret.charAt(ret.length()-1));
            ret.deleteCharAt(ret.length()-1);
        }

        return ret.toString();
    }


    
    
    public static void main(String[] args) {
        System.out.println("Expected: cab :: Actual: " + stringShift(testCase2, testCase1));
        System.out.println("Expected: efgabcd :: Actual: " + stringShift(testCase4, testCase3));
    }
}



//what structs will help us here?
    //I don't think so :/


//validate
    //if length string == 1 
        //return

//loop through the 2d array
    //calculate total number of moves
        //create 2 funcs (Shifting left & right)
        // call each func with total number of moves once
