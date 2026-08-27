class TrieNode {
    Map<Character, TrieNode> childrens;
    boolean endOfWord;

    TrieNode() {
        childrens = new HashMap<>();
        endOfWord = false;
    }
}

class WordDictionary {
    TrieNode node;

    public WordDictionary() {
        node = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = node;
        for (char ch : word.toCharArray()) {
            if (!curr.childrens.containsKey(ch)) {
                curr.childrens.put(ch, new TrieNode());
                curr = curr.childrens.get(ch);
            } else {
                curr = curr.childrens.get(ch);
            }
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {

        return dfs(0, word, node);
    }

    boolean dfs(int i, String word, TrieNode node) {
        if(i == word.length()) {
            return node.endOfWord;
        }

        char ch = word.charAt(i);

        if(ch == '.') {
            for(Map.Entry<Character, TrieNode> entry : node.childrens.entrySet()) {//d->trienode, m->
                TrieNode nextNode = node.childrens.get(entry.getKey());

                if(dfs(i + 1, word, nextNode)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode nextNode = node.childrens.get(ch);
            if(nextNode == null) {
                return false;
            }

            return dfs(i + 1, word, nextNode);
        }
    }
}
