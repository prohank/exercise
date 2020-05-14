package datastructures;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("le");
        trie.insert("leet");
        System.out.println("Trie contains " + "le: " + trie.search("le"));
        System.out.println("Trie contains " + "leet: " + trie.search("leet"));
        System.out.println("Trie contains " + "leety: " + trie.search("leety"));
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsChar(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null /*&& node.isEnd()*/;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containsChar(currentChar)) {
                node = node.get(currentChar);
            } else return null;

        }
        return node;
    }
}

class TrieNode {
    private final TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsChar(int ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(int ch) {
        return links[ch - 'a'];
    }

    public void put(int ch, TrieNode node) {
        this.links[ch - 'a'] = node;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = Boolean.TRUE;
    }
}
