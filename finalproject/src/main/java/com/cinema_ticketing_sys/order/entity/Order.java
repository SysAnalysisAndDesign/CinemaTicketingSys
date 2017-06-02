package com.cinema_ticketing_sys.order.entity;

import com.cinema_ticketing_sys.user.entity.User;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by huitianrui on 2017/5/11.
 */
@Entity
// 真trick order是MySQL的关键字，不能直接拿来当表名，要用``括起来才行
@Table(name = "`order`", schema = "cinema_ticketing_db")
public class Order {
    private int orderId;
    private String date;
    private String movieName;
    private String cinemaName;
    private String hallNumber;
    private Integer row;
    private Integer col;
    private String totalPrice;

    private User user;

    public Order() {}

    // Order 双向多对一关联 User
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "order_user_id", referencedColumnName = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
    @Column(name = "total_price")
    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order that = (Order) o;

        if (orderId != that.orderId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (movieName != null ? !movieName.equals(that.movieName) : that.movieName != null) return false;
        if (cinemaName != null ? !cinemaName.equals(that.cinemaName) : that.cinemaName != null) return false;
        if (hallNumber != null ? !hallNumber.equals(that.hallNumber) : that.hallNumber != null) return false;
        if (row != null ? !row.equals(that.row) : that.row != null) return false;
        if (col != null ? !col.equals(that.col) : that.col != null) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;

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
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }
}
