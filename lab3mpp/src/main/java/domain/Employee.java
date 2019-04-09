package domain;

public class Employee implements HasID<String> {
    private String ID;
    private String name;
    private String password;

    /***
     * Initializer
     * @param id
     * @param name
     * @param password
     */
    public Employee(String id, String name, String password) {
        this.ID = id;
        this.name = name;
        this.password = password;
    }

    public Employee(){};

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String location) {
        this.password = location;
    }
}
