package com.bestoftheyear.best_of_the_year.classes;

import java.io.Serializable;

public class Song implements Serializable{
    private String id;
    private String titolo;

    public Song() {}

    public Song(String id, String titolo){
        this.id=id;
        this.titolo=titolo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString(){
        return this.titolo;
    }
}
