class Solution {

    String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        return rec(digits, 0);
    }

    //34
    List<String> rec(String digits, int i) {

        if(i >= digits.length()) {
            List<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }

        List<String> ans = new ArrayList<>();
        
        List<String> res = rec(digits, i + 1);//[g,h,i]

        String button = keypad[digits.charAt(i) - '0'];//def

        for(int j = 0; j < button.length(); j++) {
            for(int z = 0; z < res.size(); z++) {
                ans.add(button.charAt(j) + res.get(z));
            }
        }

        return ans;
    }
}
