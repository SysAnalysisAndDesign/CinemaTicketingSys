package com.cinema_ticketing_sys.bought_seat.entity;

import javax.persistence.*;

/**
 * Created by huitianrui on 2017/5/11.
 */
@Entity
@Table(name = "bought_seat", schema = "cinema_ticketing_db")
public class BoughtSeatEntity {
    private int seatId;
    private Integer row;
    private Integer col;

    @Id
    @Column(name = "seat_id")
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

        BoughtSeatEntity that = (BoughtSeatEntity) o;

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
