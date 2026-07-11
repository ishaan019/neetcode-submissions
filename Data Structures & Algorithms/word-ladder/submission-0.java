class Solution {
    class Pair {
        String str;
        int seq;

        Pair(String s, int se) {
            str = s;
            seq = se;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList) {
            set.add(s);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        while(queue.isEmpty() == false) {
            Pair top = queue.poll();
            String str = top.str;
            int seq = top.seq;

            if(str.equals(endWord)) {
                return seq;
            }

            for(int i = 0; i < str.length(); i++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    char[] replacedCharArray = str.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedStr = new String(replacedCharArray);

                    if(set.contains(replacedStr)) {
                        set.remove(replacedStr);
                        queue.offer(new Pair(replacedStr, seq + 1));
                    }
                }
            }
        }

        return 0;
    }
}