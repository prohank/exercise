package datastructures;

public class Trie {

    private final int ALPHA_SIZE = 26;

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("le");
        trie.insert("leet");
        trie.insert("leetie");
        trie.insert("look");
        trie.insert("lookforthis");
        trie.insert("apple");
        System.out.println("Trie contains " + "le: " + trie.search("le"));
        System.out.println("Trie contains " + "leet: " + trie.search("leet"));
        System.out.println("Trie contains " + "leety: " + trie.search("leety"));
        TrieNode node = trie.searchPrefix("le");
        trie.getTrieFrom(node, "le");
        trie.getTrieFrom(trie.root, "");
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

    public void getTrieFrom(TrieNode node, String startingWith) {
        String s = startingWith;
        StringBuilder sb = new StringBuilder();
        getTrieNodesRecursive(node, s, sb);
        System.out.println(sb);
    }

    private void getTrieNodesRecursive(TrieNode node, String s, StringBuilder sb) {
        if (node != null) {
            if (node.isEnd()) {
                sb.append(s).append(",");
            }
            for (int k = 0; k < ALPHA_SIZE; k++)
                if (null != node.getChild(k)) {
                    getTrieNodesRecursive(node.getChild(k), s + (char) (k + 'a'), sb);
                }
        }
    }

    private static class TrieNode {
        private final TrieNode[] links;
        private final int ALPHA_SIZE = 26;
        private boolean isEnd;

        TrieNode() {
            links = new TrieNode[ALPHA_SIZE];
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

        public TrieNode getChild(int i) {
            return links[i];
        }
    }
}