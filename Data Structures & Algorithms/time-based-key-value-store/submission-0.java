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
        // if(!hashMap.containsKey(key)) {
        //     hashMap.put(key, new ArrayList<>());
        // }

        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(new Val(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(!hashMap.containsKey(key)) {
            return "";
        }

        List<Val> list = hashMap.get(key);

        int seen = -1;
        String ans = "";

        for(Val v : list) {
            if(v.timeStamp <= timestamp) {
                seen = Math.max(seen, v.timeStamp);
                ans = v.value;
            }
        }

        if(seen == -1) {
            return "";
        }

        return ans;

    }
}
