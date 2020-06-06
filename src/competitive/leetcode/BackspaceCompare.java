package competitive.leetcode;

import java.util.Stack;


/**
 * https://leetcode.com/problems/backspace-string-compare/
 * Date: 10-05-2020
 */
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
        Stack<Character> opCharStack = new Stack<>();
        String s, t;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!opCharStack.isEmpty()) opCharStack.pop();
            } else {
                opCharStack.push(S.charAt(i));
            }
        }
        for (Character c : opCharStack) {
            sb.append(c);
        }
        s = sb.toString();

        opCharStack.removeAllElements();
        sb.setLength(0);
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!opCharStack.isEmpty()) opCharStack.pop();
            } else {
                opCharStack.push(T.charAt(i));
            }
        }
        for (Character c : opCharStack) {
            sb.append(c);
        }
        t = sb.toString();
        return s.equals(t) ? Boolean.TRUE : Boolean.FALSE;
    }
}

//////////////////////////////////////////////////////////
//public boolean backspaceCompare(String S, String T) {
//
//    List<Character> sCharArr = new ArrayList<>();
//    List<Character> tCharArr = new ArrayList<>();
//    for (Character c : S.toCharArray()) sCharArr.add(c);
//    for (Character c : T.toCharArray()) tCharArr.add(c);
//
//    for (int i = sCharArr.size() - 1; i >= 0; i--) {
//        while (i >= 0 && sCharArr.get(i) == '#') i--;
//        if (i >= 0 && i < sCharArr.size() - 1 && sCharArr.get(i + 1) == '#') {
//            sCharArr.remove(i + 1);
//            sCharArr.remove(i);
//        }
//    }
//    sCharArr.removeAll(Collections.singleton('#'));
//    for (int i = tCharArr.size() - 1; i >= 0; i--) {
//        while (i >= 0 && tCharArr.get(i) == '#') i--;
//        if (i >= 0 && i < tCharArr.size() - 1 && tCharArr.get(i + 1) == '#') {
//            tCharArr.remove(i + 1);
//            tCharArr.remove(i);
//        }
//    }
//    tCharArr.removeAll(Collections.singleton('#'));
//
//    return String.valueOf(sCharArr).equals(String.valueOf(tCharArr)) ? Boolean.TRUE : Boolean.FALSE;
//}
