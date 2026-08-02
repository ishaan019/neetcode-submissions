class TrieNode {
    boolean endOfWord = false;
    Map<Character, TrieNode> children = new HashMap<>();
}

class WordDictionary {
    TrieNode node;

    public WordDictionary() {
        node = new TrieNode();
    }

    public void addWord(String word) {
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
        return dfs(word, 0, node);
    }

    boolean dfs(String word, int i, TrieNode node) {
        if (i == word.length()) {
            return node.endOfWord;
        }

        char ch = word.charAt(i);

        if (ch == '.') {
            for (Character c : node.children.keySet()) {
                if (dfs(word, i + 1, node.children.get(c))) {
                    return true;
                }
            }
            return false;
        } else {
            if (!node.children.containsKey(ch)) {
                return false;
            }
            return dfs(word, i + 1, node.children.get(ch));
        }
    }
}
