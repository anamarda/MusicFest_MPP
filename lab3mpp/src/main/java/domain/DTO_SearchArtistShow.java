package domain;

public class DTO_SearchArtistShow {
    private String name;
    private String location;
    private String hour;
    private Integer availableTickets;
    private Artist artist;
    private Show show;

    public DTO_SearchArtistShow(String name, String location, Integer availableTickets) {

        this.name = name;
        this.location = location;
        this.hour = "20:00";
        this.availableTickets = availableTickets;
    }

    public DTO_SearchArtistShow(String name, String location, Integer availableTickets, Artist artist, Show show) {
        this.name = name;
        this.location = location;
        this.hour = "20:00";
        this.availableTickets = availableTickets;
        this.artist = artist;
        this.show = show;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Integer getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(Integer availableTickets) {
        this.availableTickets = availableTickets;
    }
}
