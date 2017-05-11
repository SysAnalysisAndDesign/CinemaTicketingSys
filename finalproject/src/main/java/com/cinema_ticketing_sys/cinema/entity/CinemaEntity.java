package com.cinema_ticketing_sys.cinema.entity;

import javax.persistence.*;

/**
 * Created by huitianrui on 2017/5/11.
 */
@Entity
@Table(name = "cinema", schema = "cinema_ticketing_db")
public class CinemaEntity {
    private int cinemaId;
    private String cinemaName;
    private String address;
    private String description;
    private Integer rate;

    @Id
    @Column(name = "cinema_id")
    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    @Column(name = "rate")
    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CinemaEntity that = (CinemaEntity) o;

        if (cinemaId != that.cinemaId) return false;
        if (cinemaName != null ? !cinemaName.equals(that.cinemaName) : that.cinemaName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cinemaId;
        result = 31 * result + (cinemaName != null ? cinemaName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }
}
