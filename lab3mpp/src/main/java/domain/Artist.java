package domain;

public class Artist implements HasID<String> {
    private String ID;
    private String name;

    /***
     * Contructor
     * @param ID
     * @param name
     */
    public Artist(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
