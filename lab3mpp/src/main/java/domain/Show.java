package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Show implements HasID<String> {
    private String ID;
    private String location;
    private LocalDate date;
    private Integer noAvailableTickets;
    private Integer noSoldTickets;

    /***
     *
     * @param ID
     * @param location
     * @param date
     * @param noAvailableTickets
     * @param noSoldTickets
     */
    public Show(String ID, String location, LocalDate date, Integer noAvailableTickets, Integer noSoldTickets) {
        this.ID = ID;
        this.location = location;
        this.date = date;
        this.noAvailableTickets = noAvailableTickets;
        this.noSoldTickets = noSoldTickets;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getNoAvailableTickets() {
        return noAvailableTickets;
    }

    public void setNoAvailableTickets(Integer noAvailableTickets) {
        this.noAvailableTickets = noAvailableTickets;
    }

    public Integer getNoSoldTickets() {
        return noSoldTickets;
    }

    public void setNoSoldTickets(Integer noSoldTickets) {
        this.noSoldTickets = noSoldTickets;
    }
}
