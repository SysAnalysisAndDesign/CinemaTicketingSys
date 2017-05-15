package com.cinema_ticketing_sys.movie.entity;

import com.cinema_ticketing_sys.cinema.entity.Cinema;
import com.cinema_ticketing_sys.comment.entity.Comment;
import com.cinema_ticketing_sys.movie_cutting.entity.MovieCutting;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huitianrui on 2017/5/11.
 */
@Entity
@Table(name = "movie", schema = "cinema_ticketing_db")
public class Movie {
    private int movieId;
    private String movieName;
    private String description;
    private Double price;

    private Set<MovieCutting> movieCuttings = new HashSet<>();
    private Set<Comment> comments = new HashSet<>();
    private Cinema cinema;

    public Movie() {}

    // 电影 双向一对多关联 评论
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Comment.class, mappedBy = "movie")
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    // 电影 双向多对一关联 影院
    @ManyToOne(targetEntity = Cinema.class)
    @JoinColumn(name = "cinema_id", referencedColumnName = "cinema_id", nullable = false)
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    // 电影 双向一对多关联 电影场次
    @OneToMany(cascade = CascadeType.ALL, targetEntity = MovieCutting.class, mappedBy = "movie")
    public Set<MovieCutting> getMovieCuttings() {
        return movieCuttings;
    }

    public void setMovieCuttings(Set<MovieCutting> movieCuttings) {
        this.movieCuttings = movieCuttings;
    }

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "movie_name")
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie that = (Movie) o;

        if (movieId != that.movieId) return false;
        if (movieName != null ? !movieName.equals(that.movieName) : that.movieName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
