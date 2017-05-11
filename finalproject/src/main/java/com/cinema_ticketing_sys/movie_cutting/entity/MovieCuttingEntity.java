package com.cinema_ticketing_sys.movie_cutting.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by huitianrui on 2017/5/11.
 */
@Entity
@Table(name = "movie_cutting", schema = "cinema_ticketing_db")
public class MovieCuttingEntity {
    private int movieCuttingId;
    private Timestamp startTime;
    private Integer length;
    private Integer hallNumber;

    @Id
    @Column(name = "movie_cutting_id")
    public int getMovieCuttingId() {
        return movieCuttingId;
    }

    public void setMovieCuttingId(int movieCuttingId) {
        this.movieCuttingId = movieCuttingId;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "length")
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Basic
    @Column(name = "hall_number")
    public Integer getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(Integer hallNumber) {
        this.hallNumber = hallNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieCuttingEntity that = (MovieCuttingEntity) o;

        if (movieCuttingId != that.movieCuttingId) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (hallNumber != null ? !hallNumber.equals(that.hallNumber) : that.hallNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieCuttingId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (hallNumber != null ? hallNumber.hashCode() : 0);
        return result;
    }
}
