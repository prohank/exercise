package competitive.leetcode.april;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackspaceCompare {
    public static void main(String[] args) {
        BackspaceCompare bc = new BackspaceCompare();
        System.out.println(bc.backspaceCompare("ab#c", "ad#c"));
        System.out.println(bc.backspaceCompare("ab##", "c#d#"));
        System.out.println(bc.backspaceCompare("a##c", "#a#c"));
        System.out.println(bc.backspaceCompare("a#c", "b"));
        System.out.println(bc.backspaceCompare("xywrrmp", "xywrrmu#p"));
        System.out.println(bc.backspaceCompare("c##vnvr", "#c##vnvr"));
    }

    public boolean backspaceCompare(String S, String T) {
        List<Character> sCharArr = new ArrayList<>();
        List<Character> tCharArr = new ArrayList<>();
        for (Character c : S.toCharArray()) sCharArr.add(c);
        for (Character c : T.toCharArray()) tCharArr.add(c);

        for (int i = sCharArr.size() - 1; i >= 0; i--) {
            while (i >= 0 && sCharArr.get(i) == '#') i--;
            if (i >= 0 && i < sCharArr.size() - 1 && sCharArr.get(i + 1) == '#') {
                sCharArr.remove(i + 1);
                sCharArr.remove(i);
            }
        }
        sCharArr.removeAll(Collections.singleton('#'));
        for (int i = tCharArr.size() - 1; i >= 0; i--) {
            while (i >= 0 && tCharArr.get(i) == '#') i--;
            if (i >= 0 && i < tCharArr.size() - 1 && tCharArr.get(i + 1) == '#') {
                tCharArr.remove(i + 1);
                tCharArr.remove(i);
            }
        }
        tCharArr.removeAll(Collections.singleton('#'));

        return String.valueOf(sCharArr).equals(String.valueOf(tCharArr)) ? Boolean.TRUE : Boolean.FALSE;
    }
}
