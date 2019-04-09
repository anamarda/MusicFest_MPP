package domain;

public class Ticket implements HasID<String> {
    private String ID;
    private String IDshow;
    private String purchaser;
    private Integer noOfPersons;

    /***
     * Contructor
     * @param ID
     * @param IDshow
     */
    public Ticket(String ID, String IDshow, String purchaser, Integer noOfPersons) {
        this.ID = ID;
        this.IDshow = IDshow;
        this.purchaser = purchaser;
        this.noOfPersons = noOfPersons;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIDShow() {
        return IDshow;
    }

    public void setShow(String IDshow) {
        this.IDshow = IDshow;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public Integer getNoOfPersons() {
        return noOfPersons;
    }

    public void setNoOfPersons(Integer noOfPersons) {
        this.noOfPersons = noOfPersons;
    }
}
