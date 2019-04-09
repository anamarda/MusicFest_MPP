package service;

import domain.*;
import repo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    ArtistDbRepo artistDbRepo;
    EmployeesDbRepo employeesDbRepo;
    ShowDbRepo showDbRepo;
    ShowArtistDbRepo showArtistDbRepo;
    TicketDbRepo ticketDbRepo;

    public Service(ArtistDbRepo artistDbRepo, EmployeesDbRepo employeesDbRepo, ShowDbRepo showDbRepo, ShowArtistDbRepo showArtistDbRepo, TicketDbRepo ticketDbRepo) {
        this.artistDbRepo = artistDbRepo;
        this.employeesDbRepo = employeesDbRepo;
        this.showDbRepo = showDbRepo;
        this.showArtistDbRepo = showArtistDbRepo;
        this.ticketDbRepo = ticketDbRepo;
    }

    public List<DTO_ArtistShow> getArtistsShows(){
        List<DTO_ArtistShow> rez = new ArrayList<>();
        List<Artist> artists = artistDbRepo.findAll();
        List<Show> shows = showDbRepo.findAll();

        for(Artist a : artists){
            for(Show s : shows){
                if(showArtistDbRepo.findAll().contains(s.getID() + "-" + a.getID())){
                    rez.add(new DTO_ArtistShow(a.getName(), s.getDate(), s.getLocation(), s.getNoAvailableTickets(), s.getNoSoldTickets()));
                }
            }
        }
        return rez;
    }

    public List<DTO_SearchArtistShow> getSearchArtistsShows(LocalDate date){
        List<DTO_SearchArtistShow> rez = new ArrayList<>();
        List<Artist> artists = artistDbRepo.findAll();
        List<Show> shows = showDbRepo.findAll();

        for(Artist a : artists){
            for(Show s : shows){
                if(showArtistDbRepo.findAll().contains(s.getID() + "-" + a.getID()) && s.getDate().equals(date)){
                    rez.add(new DTO_SearchArtistShow(a.getName(), s.getLocation(), s.getNoAvailableTickets(), a, s));
                }
            }
        }

        return rez;
    }

    public void buyTickets(DTO_SearchArtistShow show, String purchaser, Integer noOfTickets) throws Exception {
        if(show.getAvailableTickets()==0 || show.getAvailableTickets() < noOfTickets){
            throw new Exception("Not enough available tickets.");
        }
        else {
            Ticket ticket = new Ticket("", show.getShow().getID(), purchaser, noOfTickets);
            Show s = new Show(show.getShow().getID(), show.getShow().getLocation(), show.getShow().getDate(), show.getAvailableTickets() - noOfTickets, show.getShow().getNoSoldTickets() + noOfTickets);

            ticketDbRepo.add(ticket);
            showDbRepo.modify(s);
        }
    }

    public Boolean checkLogin(String name, String pass){
        Employee e = new Employee("", name, pass);
        return employeesDbRepo.findOne(e);
    }

}
