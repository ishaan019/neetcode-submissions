class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class PrefixTree {
    TrieNode node;

    public PrefixTree() {
        node = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = node;

        for (Character ch : word.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                curr.children.put(ch, new TrieNode());
            }

            curr = curr.children.get(ch);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = node;

        for(Character ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }

        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = node;
        
        for(Character ch : prefix.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }

        return true;
    }
}
