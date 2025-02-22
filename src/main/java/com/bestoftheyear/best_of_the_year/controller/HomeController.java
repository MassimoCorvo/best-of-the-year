package com.bestoftheyear.best_of_the_year.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bestoftheyear.best_of_the_year.classes.Movie;

@Controller
@RequestMapping("/")
public class HomeController {
    ArrayList<Movie> moviesList = new ArrayList<>();

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

    // private ArrayList<Song> getBestSongs(){

    // }
}
