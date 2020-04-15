package Roman;

public class NumToRoman {

    private static int testCase1 = 100;
    private static int testCase2 = 13;
    private static int testCase3 = 2174;

    public static String NumberToRomanForwards(int numberToConvert){

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder ans = new StringBuilder();

        for (int i=0; i<values.length && numberToConvert>=0; i++) {
             
            while(values[i]<=numberToConvert){
                numberToConvert-=values[i];
                ans.append(symbols[i]);
            }
        }

        return ans.toString();
    }


    public static void main(String[] args) {

        System.out.println(NumberToRomanForwards(testCase1));
        System.out.println(NumberToRomanForwards(testCase2));
        System.out.println(NumberToRomanForwards(testCase3));


    }
}