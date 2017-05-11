package com.cinema_ticketing_sys.order.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by huitianrui on 2017/5/11.
 */
@Entity
@Table(name = "order", schema = "cinema_ticketing_db")
public class OrderEntity {
    private int orderId;
    private Timestamp date;
    private String movieName;
    private String cinemaName;
    private String hallNumber;
    private Integer row;
    private Integer col;
    private Double price;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
    @Column(name = "cinema_name")
    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    @Basic
    @Column(name = "hall_number")
    public String getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(String hallNumber) {
        this.hallNumber = hallNumber;
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

        OrderEntity that = (OrderEntity) o;

        if (orderId != that.orderId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (movieName != null ? !movieName.equals(that.movieName) : that.movieName != null) return false;
        if (cinemaName != null ? !cinemaName.equals(that.cinemaName) : that.cinemaName != null) return false;
        if (hallNumber != null ? !hallNumber.equals(that.hallNumber) : that.hallNumber != null) return false;
        if (row != null ? !row.equals(that.row) : that.row != null) return false;
        if (col != null ? !col.equals(that.col) : that.col != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (cinemaName != null ? cinemaName.hashCode() : 0);
        result = 31 * result + (hallNumber != null ? hallNumber.hashCode() : 0);
        result = 31 * result + (row != null ? row.hashCode() : 0);
        result = 31 * result + (col != null ? col.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
