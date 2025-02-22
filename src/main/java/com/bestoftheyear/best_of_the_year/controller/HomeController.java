package com.bestoftheyear.best_of_the_year.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bestoftheyear.best_of_the_year.classes.Movie;
import com.bestoftheyear.best_of_the_year.classes.Song;

@Controller
@RequestMapping("/")
public class HomeController {
    ArrayList<Movie> moviesList = new ArrayList<>();
    ArrayList<Song> songsList = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Massimo");
        return "index";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("movies", this.getBestMovies());
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songs", this.getBestSongs());
        return "songs";
    }

    private ArrayList<Movie> getBestMovies() {
        if(moviesList.size() == 0){
        Movie movie1 = new Movie("ABCDEF", "Il miglio verde");
        Movie movie2 = new Movie("MNBFFG", "Il gladiatore");
        Movie movie3 = new Movie("WERDSA", "Quo Vadis");
        Movie movie4 = new Movie("WTYDSA", "Ben Hur");
        Movie movie5 = new Movie("PIRDSA", "Gli spietati");
    
        moviesList.add(movie1);
        moviesList.add(movie2);
        moviesList.add(movie3);
        moviesList.add(movie4);
        moviesList.add(movie5);
        }

        return moviesList;
    }

    private ArrayList<Song> getBestSongs(){

        if(songsList.size() == 0){
            songsList.add(new Song("ATYIML", "Numb"));
            songsList.add(new Song("RUYIML", "In the end"));
            songsList.add(new Song("AMJHML", "Die young"));
            songsList.add(new Song("YHYIML", "Posso"));
            songsList.add(new Song("UIDFML", "La cura"));
        }

        return songsList;
     }

     @GetMapping("/movies/{id}")
     public String movie(Model model, @PathVariable("id") String id){
        this.getBestMovies(); //Per popolare la lista

        Movie movieFound = null;

        for (Movie movie : moviesList) {
            if( id.equals(movie.getId())){
                movieFound = movie;
            }
        }


        model.addAttribute("movie", movieFound);

        return "movie";
     }

     @GetMapping("/songs/{id}")
     public String song(Model model, @PathVariable("id") String id){
        this.getBestSongs(); //Per popolare la lista

        Song songFound = null;

        for (Song song : songsList) {
            if( id.equals(song.getId())){
                songFound = song;
            }
        }

        model.addAttribute("song", songFound);
        return "song";
     }
}
