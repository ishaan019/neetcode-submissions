static class Singleton {
    private String value;
    private static Singleton obj;

    private Singleton() {
        
    }

    public static Singleton getInstance() {
        if(obj == null) {
            obj = new Singleton();
        }

        return obj;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
