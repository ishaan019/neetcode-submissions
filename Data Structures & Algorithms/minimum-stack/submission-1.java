class MinStack {

    List<int[]> list;

    public MinStack() {
        list = new ArrayList<>();//-2,0,2
    }
    
    public void push(int val) {
        int minVal = list.isEmpty() ? val : Math.min(val, list.get(list.size() - 1)[1]);
        list.add(new int[] {val, minVal});
    }
    
    public void pop() {
        list.removeLast();
    }
    
    public int top() {
        return list.get(list.size() - 1)[0];
    }
    
    public int getMin() {
        return list.get(list.size() - 1)[1];   
    }
}
