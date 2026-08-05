class Val {
    String value;
    int timeStamp;

    Val(String val, int ts) {
        this.value = val;
        this.timeStamp = ts;
    }
}
class TimeMap {
    Map<String, List<Val>> hashMap;
    public TimeMap() {
        hashMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(new Val(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!hashMap.containsKey(key)) {
            return "";
        }

        List<Val> list = hashMap.get(key);

        String ans = "";
        int left = 0;
        int right = list.size() - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(list.get(mid).timeStamp <= timestamp) {
                ans = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
