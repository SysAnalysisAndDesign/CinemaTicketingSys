package com.cinema_ticketing_sys.bought_seat.entity;

import com.cinema_ticketing_sys.movie_cutting.entity.MovieCutting;

import javax.persistence.*;

/**
 * Created by huitianrui on 2017/5/11.
 */
@Entity
@Table(name = "bought_seat", schema = "cinema_ticketing_db")
public class BoughtSeat {
    private int seatId;
    private Integer row;
    private Integer col;

    private MovieCutting movieCutting;

    public BoughtSeat() {}

    // 已购座位 双向多对一关联 电影场次(movie_cutting)
    @ManyToOne(targetEntity = MovieCutting.class)
    @JoinColumn(name = "cutting_id", referencedColumnName = "movie_cutting_id", nullable = false)
    public MovieCutting getMovieCutting() {
        return movieCutting;
    }

    public void setMovieCutting(MovieCutting movieCutting) {
        this.movieCutting = movieCutting;
    }

    @Id
    @Column(name = "seat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    @Basic
    @Column(name = "row")
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    @Basic
    @Column(name = "col")
    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoughtSeat that = (BoughtSeat) o;

        if (seatId != that.seatId) return false;
        if (row != null ? !row.equals(that.row) : that.row != null) return false;
        if (col != null ? !col.equals(that.col) : that.col != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seatId;
        result = 31 * result + (row != null ? row.hashCode() : 0);
        result = 31 * result + (col != null ? col.hashCode() : 0);
        return result;
    }
}
