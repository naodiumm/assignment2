public class User {
    private String name;
    private boolean isVIP;

    public User(String name, boolean isVIP) {
        this.name = name;
        this.isVIP = isVIP;
    }

    public String getName() {
        return name;
    }

    public boolean isVIP() {
        return isVIP;
    }
}