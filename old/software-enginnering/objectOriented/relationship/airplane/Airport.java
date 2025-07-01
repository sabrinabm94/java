package objectOriented.relationship.airplane;

public class Airport {
    private String name;
    private int code;

    private City city = new City();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
