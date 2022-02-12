package competitive;

//Sample input: abbaaacdddd
//Output: a2b3ac4d
public class FormatString {
    public static void main(String[] args) {
        System.out.println(FormatString.format("a")); //a
        System.out.println(FormatString.format("")); //
        System.out.println(FormatString.format("abbaaacdddd")); //a2b3ac4d
    }

    static String format(String s) {

        String formattedString = "";
        if (s == null || s.trim().isEmpty() || (s.trim().length() == 1)) return s;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i - 1);
            int count = 1;
            while (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
                i++;
            }

            if (count > 1) {
                formattedString += "" + count + c;
            } else {
                formattedString += "" + c;
            }
        }

        return formattedString;
    }

}
