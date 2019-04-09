package domain;

import java.time.LocalDate;
import java.util.Objects;

public class DTO_ArtistShow {
    private String artistName;
    private LocalDate date;
    private String location;
    private Integer availableTickets;
    private Integer soldTickets;

    public DTO_ArtistShow(String artistName, LocalDate date, String location, Integer availableTickets, Integer soldTickets) {
        this.artistName = artistName;
        this.date = date;
        this.location = location;
        this.availableTickets = availableTickets;
        this.soldTickets = soldTickets;
    }

    public String getName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(Integer availableTickets) {
        this.availableTickets = availableTickets;
    }

    public Integer getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(Integer soldTickets) {
        this.soldTickets = soldTickets;
    }

    @Override
    public boolean equals(Object o) {
        DTO_ArtistShow that = (DTO_ArtistShow) o;
        return Objects.equals(artistName, that.artistName) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getLocation(), that.getLocation());
    }
}
