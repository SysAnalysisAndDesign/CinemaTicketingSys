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
    private String posterUrl;

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

    @Basic
    @Column(name = "poster_url")
    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (movieId != movie.movieId) return false;
        if (!movieName.equals(movie.movieName)) return false;
        if (!description.equals(movie.description)) return false;
        if (!price.equals(movie.price)) return false;
        if (!posterUrl.equals(movie.posterUrl)) return false;
        if (!movieCuttings.equals(movie.movieCuttings)) return false;
        if (!comments.equals(movie.comments)) return false;
        return cinema.equals(movie.cinema);
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + movieName.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + posterUrl.hashCode();
        result = 31 * result + movieCuttings.hashCode();
        result = 31 * result + comments.hashCode();
        result = 31 * result + cinema.hashCode();
        return result;
    }
}
