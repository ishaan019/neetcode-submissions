class Solution {

    public String encode(List<String> strs) {
        //["Hello","World"]
        //"50#Hello5#World"

        StringBuilder encodedString = new StringBuilder();

        for(String s : strs) {
            int length = s.length();
            encodedString.append(length).append("#").append(s);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();

        //"50#Hello5#World"

        List<String> decodedList = new ArrayList<>(); 

        int i = 0;
        while(i < n) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i,j));

            i = j + 1;

            String localStr = str.substring(i, i + length);
            decodedList.add(localStr);

            i += length;
        }

        return decodedList;
    }
}
