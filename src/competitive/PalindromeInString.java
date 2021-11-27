package competitive;

import java.util.HashSet;
import java.util.Set;

public class PalindromeInString {

    static final String S1 = "HELLOMADAMHOWAREYOU";
    static final String S2 = "INTENET";

    public static void main(String[] args) {
        System.out.println(findPalindrome(S1));
        System.out.println(findPalindrome(S2));
    }

    static Set<String> findPalindrome(String s) {
        String palindromeString;
        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char chi = s.charAt(i);
            for (int j = s.length() - 1; j > i + 1; j--) {
                char chj = s.charAt(j);
                if (chi == chj) {
                    palindromeString = checkPalindrome(s.substring(i,j+1)) ? s.substring(i,j+1) : null;
                    if(null != palindromeString) {
                        palindromes.add(palindromeString);
                        i+=palindromeString.length()/2;
                        break;
                    }
                }
            }

        }
        return palindromes;
    }

    static boolean checkPalindrome(String s){
        for(int k = 0; k < s.length()/2; k++){
            if(s.charAt(k) != s.charAt(s.length() - k - 1)){
                return false;
            }
        }
        return true;
    }

}
