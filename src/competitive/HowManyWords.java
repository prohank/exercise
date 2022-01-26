package competitive;

/**
 * Hackerrank
 * 23/01/2022 - Solution tested with limited cases
 * A sentence is made up of a group of words. Each word is a sequence of letters, ('a'-'z', 'A'-'Z),
 * that may contain one or more hyphens and may end in a punctuation mark: period (.), comma (), question mark (?), or exclamation point (!).
 * Words will be separated by one or more white space characters.
 * Hyphens join two words into one and should be retained while the other punctuation marks should be stripped.
 * Determine the number of words in a given sentence.
 * Example
 * s = 'How many eggs are in a half-dozen, 13?'
 * The list of words in the string is ['How', 'many', 'eggs', 'are', in', 'a', 'half-dozen']
 * and the number of words is 7.
 * Notice that the numeric string, '13', is not a word because it is not within the allowed character set.
 * <p>
 * Function Description
 * Complete the function howMany in the editor below.
 * howMany has the following parameter(s):
 * sentence: a string
 * Returns:
 * int: an integer that represents the number of words in the string
 * Constraints
 * • 0 < length of s <= 10^5
 */
public class HowManyWords {
    public static void main(String[] args) {
        System.out.println(HowManyWords.howMany("How many eggs are in a half-dozen, 13?")); //7
        System.out.println(HowManyWords.howMany("He is a good developer! -Then all his test-case-s should pass-, right? or- wr0ng.")); //10
        System.out.println(HowManyWords.howMany("-")); //0
        System.out.println(HowManyWords.howMany("a")); //1
        System.out.println(HowManyWords.howMany("?")); //0
    }

    public static int howMany(String sentence) {
        String[] strArr = sentence.split(" ");
        int count = 0;
        for (String s : strArr) {
            boolean validString = true;
            int j = 0;
            while (j < s.length()) {
                if (j == 0 && !Character.isLetter(s.charAt(j))) {
                    validString = false;
                    break;
                }
                if (j == (s.length() - 1) && s.charAt(j) == '-') {
                    validString = false;
                    break;
                }
                if (j < (s.length() - 1)) {
                    if (s.charAt(j) == '-' && !Character.isLetter(s.charAt(j + 1))) {
                        validString = false;
                        break;
                    }
                    if (s.charAt(j) != '-' && !Character.isLetter(s.charAt(j))) {
                        validString = false;
                        break;
                    }
                }
                j++;
            }
            if (validString) {
                count++;
            }
        }
        return count;
    }
}
