class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;

    public void addWord(String word) {
        TrieNode curr = this;
        for (char ch : word.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.endOfWord = true;
    }
}

class Solution {
    Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        // Convert String[] words to prefix tree;
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }

        // loop for row and col on board, dp dfs call on every index and check if word present add
        // into the result and return
        int ROWS = board.length;
        int COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(board, r, c, root, "");
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, String word) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#') {
            return;
        }

        if (!node.children.containsKey(board[r][c])) {
            return;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        node = node.children.get(temp);
        word += temp;

        if (node.endOfWord) {
            res.add(word);
        }

        dfs(board, r - 1, c, node, word);
        dfs(board, r + 1, c, node, word);
        dfs(board, r, c - 1, node, word);
        dfs(board, r, c + 1, node, word);

        board[r][c] = temp;
    }
}
