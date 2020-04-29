package Challenger;

public class DefangIP {

    public static String defangIPaddrReplaceAll(String address) {
        return address.replace(".", "[.]");
    }

    public static String defangIPaddr(String address) {
        StringBuilder ans = new StringBuilder();
        for (char c: address.toCharArray()){
            if (c != '.') {
                ans.append(c);
            } else { 
                ans.append("[.]");
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddrReplaceAll("1.1.1.1"));
        System.out.println(defangIPaddr("1.1.1.1"));
    }
}