package com.cinema_ticketing_sys.movie.entity;

import com.cinema_ticketing_sys.cinema.entity.Cinema;
import com.cinema_ticketing_sys.comment.entity.Comment;
import com.cinema_ticketing_sys.movie_cutting.entity.MovieCutting;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by huitianrui on 2017/6/3.
 */
@Entity
public class Movie {
    private int movieId;
    private String movieName;
    private String description;
    private Double price;
    private String posterUrl;
    private String director;
    private String cast;
    private String type;
    private String region;
    private String language;
    private Integer length;

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
    @Column(name = "movie_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "movie_name", nullable = true, length = 45)
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "poster_url", nullable = true, length = 45)
    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    @Basic
    @Column(name = "director", nullable = true, length = 45)
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Basic
    @Column(name = "cast", nullable = true, length = 100)
    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "region", nullable = true, length = 45)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "language", nullable = true, length = 45)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "length", nullable = true)
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (movieId != movie.movieId) return false;
        if (movieName != null ? !movieName.equals(movie.movieName) : movie.movieName != null) return false;
        if (description != null ? !description.equals(movie.description) : movie.description != null) return false;
        if (price != null ? !price.equals(movie.price) : movie.price != null) return false;
        if (posterUrl != null ? !posterUrl.equals(movie.posterUrl) : movie.posterUrl != null) return false;
        if (director != null ? !director.equals(movie.director) : movie.director != null) return false;
        if (cast != null ? !cast.equals(movie.cast) : movie.cast != null) return false;
        if (type != null ? !type.equals(movie.type) : movie.type != null) return false;
        if (region != null ? !region.equals(movie.region) : movie.region != null) return false;
        if (language != null ? !language.equals(movie.language) : movie.language != null) return false;
        if (length != null ? !length.equals(movie.length) : movie.length != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (posterUrl != null ? posterUrl.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (cast != null ? cast.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        return result;
    }
}
